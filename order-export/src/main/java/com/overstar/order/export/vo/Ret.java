package com.overstar.order.export.vo;

import com.overstar.order.export.constants.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 11:08
 */
@Data
public class Ret implements Serializable {
    private String msg;
    private Integer code;
    private Object data;
    private boolean success;

    public Ret() {
    }

    public Ret(String msg, Integer code, Object data, boolean success) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public Ret(ErrorCodeEnum errorCodeEnum) {
        this.success = false;
        this.msg = errorCodeEnum.getText();
        this.code = errorCodeEnum.getCode();
    }

    public static Ret success(String msg,Object data){
        return new Ret(msg,200,data,true);
    }
}
