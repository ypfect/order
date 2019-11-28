package com.overstar.order.abs.handler;

import com.alibaba.fastjson.JSON;
import com.overstar.order.abs.AbstractOrderStepCreate;
import com.overstar.order.abs.MQQueueSelector;
import com.overstar.order.export.constants.ErrorCodeEnum;
import com.overstar.order.export.constants.OrderStateEnum;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.OrderStarDetail;
import com.overstar.order.export.excption.OrderException;
import com.overstar.order.export.vo.OrderCreateParamBase;
import com.overstar.order.export.vo.ShoppingCart;
import com.overstar.order.export.vo.Sku;
import com.overstar.order.export.vo.StarOrderCreateParam;
import com.overstar.order.mapper.OrderBaseMapper;
import com.overstar.order.mapper.OrderStarDetailMapper;
import com.overstar.order.utils.CodeGenerateUtils;
import com.overstar.search.export.api.IOrderIndexService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 19:40
 */
@Slf4j
@Service
public class StarOrderCreateStepService extends AbstractOrderStepCreate {

    @Autowired
    private OrderBaseMapper orderBaseMapper;
    @Autowired
    private OrderStarDetailMapper detailMapper;
    @Reference
    public IOrderIndexService indexService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Override
    public boolean validateParam(OrderCreateParamBase orderCreateParamBase) {
        log.info("订单参数校验...");
        StarOrderCreateParam createParam = (StarOrderCreateParam) orderCreateParamBase;

        List<ShoppingCart> shoppingCarts = createParam.getShoppingCarts();
        if (shoppingCarts.isEmpty()) {
            throw new OrderException(ErrorCodeEnum.NO_GOODS2BUY);
        }
        boolean present = shoppingCarts.stream().anyMatch(shoppingCart -> shoppingCart.getSelected() == 1);
        if (!present) {
            throw new OrderException(ErrorCodeEnum.NO_GOODS2BUY);
        }
        if (createParam.getOrderBase().getUserId() == null) {
            throw new OrderException(ErrorCodeEnum.USER_ID_REQUIRED);
        }
        if (createParam.getOrderBase().getShipTime() == null) {
            throw new OrderException(ErrorCodeEnum.SHIP_TIME_REQUIRED);
        }
        if (createParam.getOrderBase().getOrderFrom() == null) {
            throw new OrderException(ErrorCodeEnum.ORDER_FROM_REQUIRED);
        }

        return true;
    }

    @Override
    public boolean amountCalculateHandler(OrderCreateParamBase orderCreateParamBase) {
        log.info("订单金额计算等...");
        StarOrderCreateParam createParam = (StarOrderCreateParam) orderCreateParamBase;
        List<ShoppingCart> shoppingCarts = createParam.getShoppingCarts();
        //获取选中的商品信息
        BigDecimal totalAmount = BigDecimal.ZERO;
        StringBuilder digest = new StringBuilder("商品摘要");
        List<ShoppingCart> collect = shoppingCarts.stream().filter(shoppingCart -> shoppingCart.getSelected() == 1).collect(Collectors.toList());
        for (ShoppingCart shoppingCart : collect) {
            // 当前sku
            Sku sku = shoppingCart.getSku();
            // 当前可用库存
            Integer availableStock = sku.getAvailableStock();
            // 购买数量
            Integer amount = shoppingCart.getAmount();
            // 库存不足
            if (amount > availableStock) {
                throw new OrderException(ErrorCodeEnum.ORDER_STOCK_NOT_ENOUGH);
            }
            // 库存充足，扣除库存
            sku.setAvailableStock(sku.getAvailableStock() - amount);
            sku.setFrozenStock(sku.getFrozenStock() + amount);
            // todo .updateSku(sku);

            // TODO .增加商品的销量
            // 获取商品订单总价
            totalAmount.add(shoppingCart.getSku().getPrice().multiply(new BigDecimal(shoppingCart.getAmount())));
            // 获取摘要
            digest.append(shoppingCart.getName());
            String skuProperties = shoppingCart.getSkuProperties();
            String[] propArr = skuProperties.split("_");
            for (String props : propArr) {
                String[] propValueArr = props.split(":");
                digest.append("-").append(propValueArr[0]);
            }
            digest.append("×").append(shoppingCart.getAmount()).append(",");
        }

        OrderBase orderBase = orderCreateParamBase.getOrderBase();
        orderBase.setTotalMoney(totalAmount);
        String orderSn = CodeGenerateUtils.generateOrderSn(orderBase.getUserId());// 订单号
        // TODO .计算运费
        BigDecimal careyFee = BigDecimal.ZERO; // 运费
        // TODO .计算优惠金额（会员折扣）
        BigDecimal discountMoney = BigDecimal.ZERO; // 优惠金额
        // TODO .计算优惠券金额（并使用优惠券）
        Long couponId = null; // 优惠券ID
        BigDecimal couponMoney = BigDecimal.ZERO;// 优惠券金额
        // TODO .计算促销活动金额（并记录参与促销活动记录）
        Integer promotionId = null;// 活动促销id
        BigDecimal promotionMoney = BigDecimal.ZERO;// 活动促销金额
        // 计算支付截止时间
        BigDecimal hours = new BigDecimal(24);
        BigDecimal millsExpires = hours.multiply(new BigDecimal(3600000));
        long lastPayTime = (millsExpires.add(new BigDecimal(System.currentTimeMillis()))).longValue();

        // 实际金额 : 商品总价totalMoney + 运费carrageFee
        // - 优惠金额discountMoney - 优惠券金额 couponMoney- 活动促销金额promotionMoney
        BigDecimal realMoney = totalAmount.add(careyFee).subtract(discountMoney).subtract(couponMoney).subtract(promotionMoney);

        // 设置订单信息
        orderBase.setOrderNo(orderSn);
        orderBase.setStoreId(1L);
        orderBase.setStoreName("overstar");
        orderBase.setState(OrderStateEnum.WAIT_PAY.getCode());
        orderBase.setCarriageFee(careyFee);
        orderBase.setTotalMoney(totalAmount);
        orderBase.setDiscountMoney(discountMoney);
        orderBase.setRealMoney(realMoney);
        orderBase.setPayMoney(BigDecimal.ZERO);// 已支付 0
        orderBase.setCouponId(couponId);
        orderBase.setCouponMoney(couponMoney);
        orderBase.setPromotionId(promotionId);
        orderBase.setPromotionMoney(promotionMoney);
        orderBase.setCommentStatus((byte) 0);
        orderBase.setDigest(digest.toString());
        orderBase.setCreateTime(System.currentTimeMillis());
        orderBase.setUpdateTime(System.currentTimeMillis());
        orderBase.setLastPayTime(lastPayTime);
        return true;
    }

    @Override
    public boolean orderDataPrepareHandler(OrderCreateParamBase orderCreateParamBase) {
        log.info("订单参数封装,为持久化准备...");
        StarOrderCreateParam createParam = (StarOrderCreateParam) orderCreateParamBase;
        OrderBase orderBase = createParam.getOrderBase();
        List<OrderStarDetail> details = new ArrayList<>();
        List<ShoppingCart> shoppingCarts = createParam.getShoppingCarts();
        for (ShoppingCart vipCart : shoppingCarts) {
            Sku sku = vipCart.getSku();
            OrderStarDetail orderDetail = new OrderStarDetail();
            orderDetail.setAmount(new BigDecimal(vipCart.getAmount()));
            orderDetail.setCreateTime(System.currentTimeMillis());
            orderDetail.setMarketPrice(sku.getMarketPrice());
            orderDetail.setName(vipCart.getName());
            orderDetail.setOrderId(orderBase.getId());
            orderDetail.setPrice(sku.getPrice());
            orderDetail.setProductId(vipCart.getProductId());
            orderDetail.setSkuId(vipCart.getSkuId());
            orderDetail.setSkuMainPic(vipCart.getSkuMainPic());
            orderDetail.setSkuProperties(vipCart.getSkuProperties());
            orderDetail.setTotalMoney(new BigDecimal(vipCart.getAmount()).multiply(sku.getPrice()));
            orderDetail.setUpdateTime(orderDetail.getCreateTime());
            details.add(orderDetail);
        }
        ((StarOrderCreateParam) orderCreateParamBase).setDetails(details);
        return true;
    }

    @Override
    @Transactional
    public boolean oderCreateHandler(OrderCreateParamBase orderCreateParamBase) {
        int insert = 0;
        try {
            log.info("订单数据持久化,主订单，订单详情...");
            StarOrderCreateParam paramBase = (StarOrderCreateParam) orderCreateParamBase;
            OrderBase orderBase = paramBase.getOrderBase();
            List<OrderStarDetail> details = paramBase.getDetails();
            insert = orderBaseMapper.insertUseGeneratedKeys(orderBase);
            Long id = orderBase.getId();
            for (OrderStarDetail detail : details) {
                detail.setOrderId((long) insert);
                detail.setOrderId(id);
            }
            detailMapper.insertList(details);

            //调用es服务处理索引数据
//            boolean b = indexService.indexOrderInfo(orderBase, details);
//            System.out.println(b+"==================================");

        } catch (Exception e) {
            e.printStackTrace();
            //todo 删除订单信息和详细信息
            return false;
        }
        return true;
    }

    @Override
    public boolean orderLog(OrderCreateParamBase orderCreateParamBase) {
        log.info("订单日志记录...");
        return true;
    }

    /**
     * 加入redis延时队列，
     * 倒计时发送短信提醒支付，发送消息到notice系统
     * 到时间触发取消操作
     *
     * @param orderCreateParamBase
     * @return
     */
    @Override
    public boolean orderMsgInQueueHandler(OrderCreateParamBase orderCreateParamBase) {
        log.info("订单信息追加到延时队列,订单付款通知,订单超时取消...");
        log.info("发送测试消息到es系统处理...");
        Message<String> message = MessageBuilder
                .withPayload(JSON.toJSONString(orderCreateParamBase))
                .setHeader("oj8k", "吃了！")
                .setHeader(RocketMQHeaders.MESSAGE_ID, "C320320320320")
                .setHeader(RocketMQHeaders.KEYS, "keya key")
                .setHeader(RocketMQHeaders.TRANSACTION_ID, "320320320320")
                .build();
        //只能发送到单个tag，如果需要整个topic都可以收到的话，可以不指定tag
        String tags = "order_create";
        String topicTags = "testMQ:" + tags;

//        //设置生产者发布选择器
//        rocketMQTemplate.setMessageQueueSelector(new MQQueueSelector());
//        rocketMQTemplate.asyncSendOrderly(topicTags, message, String.valueOf(320320320), new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                log.info("消息发送成功！res={}", JSON.toJSONString(sendResult));
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                log.error("消息发送失败", throwable);
//            }
//        }, 2000);

        sendScheduldeMsg();
        return true;
    }


    /**
     * 发送延时消息
     */
    public void sendScheduldeMsg() {
        OrderBase.OrderBaseBuilder orderBaseBuilder = OrderBase.builder()
                .digest("测试订单")
                .orderNo("3205581174581")
                .digest("简单的备注秒速")
                .couponMoney(new BigDecimal(1.22))
                .finishedTime(new Date().getTime());

        Message<String> message = MessageBuilder
                .withPayload(JSON.toJSONString(orderBaseBuilder.build()))
                .setHeader(RocketMQHeaders.MESSAGE_ID, "C320320320320")
                .setHeader(RocketMQHeaders.KEYS, "key")
                .setHeader(RocketMQHeaders.TRANSACTION_ID, "320320320320")
                .build();

        String tags = "order_create";
        String topicTags = "testMQ:" + tags;

        rocketMQTemplate.setMessageQueueSelector(new MQQueueSelector());
        SendResult sendResult = rocketMQTemplate.syncSend(topicTags, message, 2000, 3);

    }
}
