package com.overstar.order.export.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayBill implements Serializable {
    private Long id;
    private Long updateTime;
    private Long createTime;

    /**
     * 用户id
     */
    private Long ssoId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 统一支付单号
     */
    private String unionPaySn;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 业务类型
     */
    private Byte businessType;

    /**
     * 关联业务键
     */
    private Long businessKey;

    private Byte payChannel;

    /**
     * 备注
     */
    private String note;

    /**
     * 交易摘要
     */
    private String digest;

    /**
     * 支付状态
     */
    private Byte state;

    /**
     * 原支付单
     */
    private Long originalPayBillId;

    /**
     * 原统一支付单号
     */
    private String originalUnionPaySn;

    /**
     * 支付截止时间
     */
    private Long lastPayTime;

    private static final long serialVersionUID = 1L;
}