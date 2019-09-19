package com.overstar.order.export.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Sku implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * SKU编码
     */
    private String skuCode;
    /**
     * SKU规格名
     */
    private String skuName;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 优惠价
     */
    private BigDecimal price;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 销量
     */
    private Integer saleCount;

    /**
     * 排序
     */
    private Integer sortIndex;

    /**
     * 可用库存
     */
    private Integer availableStock;

    /**
     * 锁定库存
     */
    private Integer frozenStock;

    /**
     * SKU属性摘要
     */
    private String skuProperties;

    /**
     * 预览图
     */
    private String skuMainPic;

}