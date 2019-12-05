package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Table(name = "t_order_item")
public class OrderStarDetail implements Serializable {
    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long orderNo;
    private Long productId;
    private String productName;
    private Integer userId;
    private Long skuId;
    private String skuMainPic;
    private String skuProperties;
    private BigDecimal marketPrice;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal totalMoney;
    private static final long serialVersionUID = 1L;

}