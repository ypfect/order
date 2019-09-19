package com.overstar.order.abs;


import com.overstar.order.export.constants.EnumOrderType;
import com.overstar.order.export.constants.ErrorCodeEnum;
import com.overstar.order.export.excption.OrderException;
import com.overstar.order.export.vo.OrderCreateParamBase;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 19:21
 */
public abstract class AbstractOrderCreate implements IOrderService{

    @Override
    public long orderCreate(OrderCreateParamBase orderCreateParamBase) {
        boolean b = validateParam(orderCreateParamBase);
        if (!b){
            throw new OrderException(ErrorCodeEnum.ORDER_VALIDATE_ERROR);
        }
        if (!amountCalculateHandler(orderCreateParamBase)){
            throw new OrderException(ErrorCodeEnum.ORDER_CALCULATE_ERROR);
        }
        if (!orderDataPrepareHandler(orderCreateParamBase)){
            throw new OrderException(ErrorCodeEnum.ORDER_PREPARE_ERROR);
        }

        if (!oderCreateHandler(orderCreateParamBase)){
            //持久化失败了需要恢复数据，记录失败表格。定期扫描清洗数据
            throw new OrderException(ErrorCodeEnum.ORDER_PERSIS_ERROR);
        }
        if (!orderLog(orderCreateParamBase)){
            throw new OrderException(ErrorCodeEnum.ORDER_LOG_ERROR);
        }
        if (!orderMsgInQueueHandler(orderCreateParamBase)){
            throw new OrderException(ErrorCodeEnum.ORDER_QUEUE_ERROR);
        }

        return orderCreateParamBase.getOrderBase().getId();
    }



    @Override
    public EnumOrderType orderCategory() {
        return EnumOrderType.STAR_ORDER;
    }

    /**
     * 订单参数校验
     */
    public abstract boolean validateParam(OrderCreateParamBase orderCreateParamBase);


    /**
     * 算价
     * @param orderCreateParamBase
     * @return
     */
    public abstract boolean amountCalculateHandler(OrderCreateParamBase orderCreateParamBase);

    /**
     * 数据转换封装
     * @param orderCreateParamBase
     * @return
     */
    public abstract boolean orderDataPrepareHandler(OrderCreateParamBase orderCreateParamBase);

    /**
     * 订单数据持久化
     * @param orderCreateParamBase
     * @return
     */
    public abstract boolean oderCreateHandler(OrderCreateParamBase orderCreateParamBase);

    /**
     * 日志记录
     * @param orderCreateParamBase
     * @return
     */
    public abstract boolean orderLog(OrderCreateParamBase orderCreateParamBase);

    /**
     * 加入延时队列  方便提示支付 以及超时取消操作
     * @param orderCreateParamBase
     * @return
     */
    public abstract boolean orderMsgInQueueHandler(OrderCreateParamBase orderCreateParamBase);

}
