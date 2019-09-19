package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`order_address`")
@Data
public class OrderAddress implements Serializable {
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
     * (可选项)
     */
    @Column(name = "`order_sn`")
    private String orderSn;

    /**
     * (必填项)
     * 收货人
     */
    @Column(name = "`reciver`")
    private String reciver;

    /**
     * (必填项)
     * 区域
     */
    @Column(name = "`area_code`")
    private String areaCode;

    /**
     * (可选项)
     * 详细地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * (可选项)
     * 全地址
     */
    @Column(name = "`full_address`")
    private String fullAddress;

    /**
     * (必填项)
     * 手机号码
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * (可选项)
     * 备用手机号
     */
    @Column(name = "`phone_back`")
    private String phoneBack;

    /**
     * (可选项)
     * 固定电话
     */
    @Column(name = "`tel`")
    private String tel;

    /**
     * (可选项)
     * 邮编
     */
    @Column(name = "`post_code`")
    private String postCode;

    /**
     * (可选项)
     * 电子邮件
     */
    @Column(name = "`email`")
    private String email;

    private static final long serialVersionUID = 1L;

}