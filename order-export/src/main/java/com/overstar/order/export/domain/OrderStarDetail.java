package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
@Data
@Table(name = "`order_star_detail`")
public class OrderStarDetail implements Serializable {
    /**
     * (必填项)
     */
    @Id
    @Column(name = "`id`")
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
     * (可选项)
     */
    @Column(name = "`order_id`")
    private Long orderId;

    /**
     * (必填项)
     */
    @Column(name = "`product_id`")
    private Long productId;

    /**
     * (必填项)
     */
    @Column(name = "`name`")
    private String name;

    /**
     * (必填项)
     */
    @Column(name = "`sku_id`")
    private Long skuId;

    /**
     * (必填项)
     */
    @Column(name = "`sku_main_pic`")
    private String skuMainPic;

    /**
     * (必填项)
     */
    @Column(name = "`sku_properties`")
    private String skuProperties;

    /**
     * (可选项)
     */
    @Column(name = "`market_price`")
    private BigDecimal marketPrice;

    /**
     * (可选项)
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * (必填项)
     */
    @Column(name = "`amount`")
    private BigDecimal amount;

    /**
     * (可选项)
     */
    @Column(name = "`total_money`")
    private BigDecimal totalMoney;

    private static final long serialVersionUID = 1L;

}