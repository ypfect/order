package com.overstar.order.export.constants;

import lombok.Getter;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 11:12
 */
@Getter
public enum OrderStateEnum {
    WAIT_PAY("待付款！", (byte) 0),
    WAIT_SHIP_SEND("待发货！", (byte) 1),
    WAIT_SHIP_TAKE("待收货！", (byte) 2),
    FINISHED("已完成！", (byte) 3),
    CANCEL_APPLY("取消申请！", (byte) 4),
    CLOSED("交易关闭！", (byte) 5),
    DELETED("删除！", (byte) 9);

    private String text;
    private byte code;

    OrderStateEnum(String text, byte code) {
        this.text = text;
        this.code = code;
    }
}
