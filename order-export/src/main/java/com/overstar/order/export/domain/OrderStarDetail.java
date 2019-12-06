package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Table(name = "t_order_item")
public class OrderStarDetail implements Serializable {
//    @Column(name = "`id`")
    private long id;
    @Column(name = "`create_time`")
    private LocalDateTime createTime;
    @Column(name = "`update_time`")
    private LocalDateTime updateTime;
    @Column(name = "`order_no`")
    private long orderNo;
    @Column(name = "`product_id`")
    private long productId;
    @Column(name = "`product_name`")
    private String productName;
    @Column(name = "`user_id`")
    private int userId;
    @Column(name = "`sku_id`")
    private long skuId;
    @Column(name = "`sku_main_pic`")
    private String skuMainPic;
    @Column(name = "`sku_properties`")
    private String skuProperties;
    @Column(name = "`market_price`")
    private BigDecimal marketPrice;
    @Column(name = "`price`")
    private BigDecimal price;
    @Column(name = "`amount`")
    private BigDecimal amount;
    @Column(name = "`total_money`")
    private BigDecimal totalMoney;
    private static final long serialVersionUID = 1L;
}