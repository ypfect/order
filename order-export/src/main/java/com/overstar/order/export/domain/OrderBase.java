package com.overstar.order.export.domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "t_order")
public class OrderBase implements Serializable{
    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    private Integer userId;
    private Long orderNo;
    //商户ID
    private Long storeId;
    private String storeName;
    //留言
    private String leaveWord;
    //状态
    private Byte state;
    //运费
    private BigDecimal carriageFee;
    private String remark;
    /**
     * 订单总价
     */
    private BigDecimal totalMoney;
    /**
     * 优惠总额
     */
    private BigDecimal discountMoney;
    /**
     * (必填项)
     */
    private BigDecimal realMoney;
    /**
     * 实付金额
     */
    private BigDecimal payMoney;
    /**
     * 支付方式
     */
    private Byte payChannel;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 优惠券ID
     */
    private Long couponId;

    /**
     * 优惠券金额
     */
    private BigDecimal couponMoney;

    /**
     * 促销
     */
    private Integer promotionId;

    /**
     * 促销金额
     */
    private BigDecimal promotionMoney;

    /**
     * 订单来源
     */
    private Byte orderFrom;

    /**
     * 交易完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 评价状态
     */
    private Byte commentStatus;

    /**
     * 评价时间
     */
    private LocalDateTime commentTime;

    /**
     * 快递服务商
     */
    private Long shipStore;

    /**
     * 快递单号
     */
    private String shipNo;

    /**
     * 配送时间
     */
    private LocalDateTime shipTime;

    /**
     * 配送时间
     */
    private LocalDateTime shipSendTime;

    /**
     * 订单摘要
     */
    private String digest;

    /**
     * 退换货状态
     */
    private Byte saleReturnState;
    /**
     * 退货单号
     */
    private String returnOrderNo;
    /**
     * 换货单号
     */
    private String changeOrderNo;
    /**
     * 是否需要发票
     */
    private Byte needBill;
    /**
     * 确认收货截止时间
     */
    private LocalDateTime lastConfirmShipTime;
    /**
     * 支付截止时间
     */
    private LocalDateTime lastPayTime;
    private static final long serialVersionUID = 1L;

}