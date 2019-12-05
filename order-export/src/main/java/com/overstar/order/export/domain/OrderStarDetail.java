package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Data
public class OrderStarDetail implements Serializable {
    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long orderId;
    private Long productId;
    private String productName;
    private Long skuId;
    private String skuMainPic;
    private String skuProperties;
    private BigDecimal marketPrice;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal totalMoney;
    private static final long serialVersionUID = 1L;

}