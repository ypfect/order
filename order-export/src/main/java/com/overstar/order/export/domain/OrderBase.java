package com.overstar.order.export.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "`order_base`")
@Data
public class OrderBase implements Serializable {
    /**
     * (必填项)
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * (可选项)
     */
    @Column(name = "`create_time`")
    private Long createTime;

    /**
     * (可选项)
     */
    @Column(name = "`update_time`")
    private Long updateTime;

    /**
     * (必填项)
     * 登录账号
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * (必填项)
     * 订单号
     */
    @Column(name = "`order_no`")
    private String orderNo;

    /**
     * (可选项)
     * 商户
     */
    @Column(name = "`store_id`")
    private Long storeId;

    /**
     * (可选项)
     * 商户名
     */
    @Column(name = "`store_name`")
    private String storeName;

    /**
     * (可选项)
     * 留言
     */
    @Column(name = "`leave_word`")
    private String leaveWord;

    /**
     * (必填项)
     * 状态
     */
    @Column(name = "`state`")
    private Byte state;

    /**
     * (必填项)
     * 运费
     */
    @Column(name = "`carriage_fee`")
    private BigDecimal carriageFee;

    /**
     * (可选项)
     * 管理员备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * (必填项)
     * 订单总价
     */
    @Column(name = "`total_money`")
    private BigDecimal totalMoney;

    /**
     * (必填项)
     * 优惠总额
     */
    @Column(name = "`discount_money`")
    private BigDecimal discountMoney;

    /**
     * (必填项)
     * 实际金额
     */
    @Column(name = "`real_money`")
    private BigDecimal realMoney;

    /**
     * (必填项)
     * 实付金额
     */
    @Column(name = "`pay_money`")
    private BigDecimal payMoney;

    /**
     * (可选项)
     * 支付方式
     */
    @Column(name = "`pay_channel`")
    private Byte payChannel;

    /**
     * (可选项)
     * 支付时间
     */
    @Column(name = "`pay_time`")
    private Long payTime;

    /**
     * (可选项)
     * 优惠券ID
     */
    @Column(name = "`coupon_id`")
    private Long couponId;

    /**
     * (可选项)
     * 优惠券金额
     */
    @Column(name = "`coupon_money`")
    private BigDecimal couponMoney;

    /**
     * (可选项)
     * 促销
     */
    @Column(name = "`promotion_id`")
    private Integer promotionId;

    /**
     * (可选项)
     * 促销金额
     */
    @Column(name = "`promotion_money`")
    private BigDecimal promotionMoney;

    /**
     * (必填项)
     * 订单来源
     */
    @Column(name = "`order_from`")
    private Byte orderFrom;

    /**
     * (可选项)
     * 交易完成时间
     */
    @Column(name = "`finished_time`")
    private Long finishedTime;

    /**
     * (必填项)
     * 评价状态
     */
    @Column(name = "`comment_status`")
    private Byte commentStatus;

    /**
     * (可选项)
     * 评价时间
     */
    @Column(name = "`comment_time`")
    private Long commentTime;

    /**
     * (可选项)
     * 快递服务商
     */
    @Column(name = "`ship_store`")
    private Long shipStore;

    /**
     * (可选项)
     * 快递单号
     */
    @Column(name = "`ship_no`")
    private String shipNo;

    /**
     * (必填项)
     * 配送时间
     */
    @Column(name = "`ship_time`")
    private String shipTime;

    /**
     * (可选项)
     * 配送时间
     */
    @Column(name = "`ship_send_time`")
    private Long shipSendTime;

    /**
     * (可选项)
     * 订单摘要
     */
    @Column(name = "`digest`")
    private String digest;

    /**
     * (必填项)
     * 退换货状态
     */
    @Column(name = "`sale_return_tate`")
    private Byte saleReturnTate;

    /**
     * (可选项)
     * 退货单号
     */
    @Column(name = "`return_order_no`")
    private String returnOrderNo;

    /**
     * (可选项)
     * 换货单号
     */
    @Column(name = "`change_order_no`")
    private String changeOrderNo;

    /**
     * (必填项)
     * 是否需要发票
     */
    @Column(name = "`need_bill`")
    private Byte needBill;

    /**
     * (可选项)
     * 确认收货截止时间
     */
    @Column(name = "`last_confirm_ship_time`")
    private Long lastConfirmShipTime;

    /**
     * (可选项)
     * 支付截止时间
     */
    @Column(name = "`last_pay_time`")
    private Long lastPayTime;

    private static final long serialVersionUID = 1L;

}