package com.overstar.order.export.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingCart implements Serializable {
    private Long id;
    private Long createTime;
    /**
     * 登录用户
     */
    private Long ssoId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * SKU ID
     */
    private Long skuId;

    /**
     * 图片
     */
    private String skuMainPic;

    /**
     * 名称
     */
    private String name;

    /**
     * 商家
     */
    private Long storeId;

    /**
     * 商家名
     */
    private String storeName;

    /**
     * 规格说明
     */
    private String skuProperties;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 是否选中
     */
    private Byte selected = 0;

    /**
     * 购物车sku数据
     */
    private Sku sku;

}