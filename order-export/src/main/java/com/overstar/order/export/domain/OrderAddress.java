package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
public class OrderAddress implements Serializable {
    private Long id;
    private Long createTime;
    private Long updateTime;
    private Long orderId;
    private String orderSn;
    private String areaCode;
    private String receiver;
    private String address;
    private String fullAddress;
    private String phone;
    private String phoneBack;
    private String tel;
    //邮编
    private String postCode;
    private String email;
    private static final long serialVersionUID = 1L;

}