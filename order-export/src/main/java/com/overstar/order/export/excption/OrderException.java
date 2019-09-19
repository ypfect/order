package com.overstar.order.export.excption;

import com.overstar.order.export.constants.CommonEnum;
import lombok.Data;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 11:12
 */
@Data
public class OrderException extends RuntimeException {

    private String errorMessage;
    private Integer errorCode;

    public OrderException(CommonEnum commonEnum) {
        super(commonEnum.getText());
        this.errorCode = commonEnum.getCode();
        this.errorMessage = commonEnum.getText();
    }

    public OrderException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public OrderException(Integer errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
