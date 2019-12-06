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
    @Column(name = "`create_time`")
    private LocalDateTime createTime;
    @Column(name = "`update_time`")
    private LocalDateTime updateTime;
    @Column(name = "`user_id`")
    private int userId;
    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!                           !!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!  不能是包装类型，不能为null！！！     !!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!                              !!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */
//    @Column(name = "`order_no`")
    private long orderNo;
    //商户ID
    @Column(name = "`store_id`")
    private long storeId;
    @Column(name = "`store_name`")
    private String storeName;
    //留言
    @Column(name = "`leave_word`")
    private String leaveWord;
    //状态
    @Column(name = "`state`")
    private Byte state;
    //运费
    @Column(name = "`carriage_fee`")
    private BigDecimal carriageFee;
    @Column(name = "`remark`")
    private String remark;
    /**
     * 订单总价
     */
    @Column(name = "`total_money`")
    private BigDecimal totalMoney;
    /**
     * 优惠总额
     */
    @Column(name = "`discount_money`")
    private BigDecimal discountMoney;
    /**
     * (必填项)
     */
    @Column(name = "`real_money`")
    private BigDecimal realMoney;
    /**
     * 实付金额
     */
    @Column(name = "`pay_money`")
    private BigDecimal payMoney;
    /**
     * 支付方式
     */
    @Column(name = "`pay_channel`")
    private Byte payChannel;

    /**
     * 支付时间
     */
    @Column(name = "`pay_time`")
    private LocalDateTime payTime;

    /**
     * 优惠券ID
     */
    @Column(name = "`coupon_id`")
    private Long couponId;

    /**
     * 优惠券金额
     */
    @Column(name = "`coupon_money`")
    private BigDecimal couponMoney;

    /**
     * 促销
     */
    @Column(name = "`promotion_id`")
    private Integer promotionId;

    /**
     * 促销金额
     */
    @Column(name = "`promotion_money`")
    private BigDecimal promotionMoney;

    /**
     * 订单来源
     */
    @Column(name = "`order_from`")
    private Byte orderFrom;

    /**
     * 交易完成时间
     */
    @Column(name = "`finished_time`")
    private LocalDateTime finishedTime;

    /**
     * 评价状态
     */
    @Column(name = "`comment_status`")
    private Byte commentStatus;

    /**
     * 评价时间
     */
    @Column(name = "`comment_time`")
    private LocalDateTime commentTime;

    /**
     * 快递服务商
     */
    @Column(name = "`ship_store`")
    private Long shipStore;

    /**
     * 快递单号
     */
    @Column(name = "`ship_no`")
    private String shipNo;

    /**
     * 配送时间
     */
    @Column(name = "`ship_time`")
    private LocalDateTime shipTime;

    /**
     * 配送时间
     */
    @Column(name = "`ship_send_time`")
    private LocalDateTime shipSendTime;

    /**
     * 订单摘要
     */
    @Column(name = "`digest`")
    private String digest;

    /**
     * 退换货状态
     */
    @Column(name = "`sale_return_state`")
    private Byte saleReturnState;
    /**
     * 退货单号
     */
    @Column(name = "`return_order_no`")
    private String returnOrderNo;
    /**
     * 换货单号
     */
    @Column(name = "`change_order_no`")
    private String changeOrderNo;
    /**
     * 是否需要发票
     */
    @Column(name = "`need_bill`")
    private Byte needBill;
    /**
     * 确认收货截止时间
     */
    @Column(name = "`last_confirm_ship_time`")
    private LocalDateTime lastConfirmShipTime;
    /**
     * 支付截止时间
     */
    @Column(name = "`last_pay_time`")
    private LocalDateTime lastPayTime;
    private static final long serialVersionUID = 1L;

}