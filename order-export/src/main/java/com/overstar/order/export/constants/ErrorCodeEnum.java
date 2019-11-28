package com.overstar.order.export.constants;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 11:10
 */
public enum ErrorCodeEnum implements CommonEnum {

    SYS_ERROR("系统异常！", 5000),
    INDEX_ERROR("索引异常", 10001),
    ORDER_VALIDATE_ERROR("订单参数验证失败", 21000),
    USER_ID_REQUIRED("用户ID不能为空", 21001),
    ORDER_FROM_REQUIRED("订单来源不能为空", 21002),
    SHIP_TIME_REQUIRED("配送时间不能为空", 21003),
    NO_GOODS2BUY("没有可购买的商品", 21004),


    ORDER_CALCULATE_ERROR("订单算价失败", 22000),
    ORDER_STOCK_NOT_ENOUGH("库存不足", 22001),


    ORDER_PREPARE_ERROR("订单参数封装失败", 20003),
    ORDER_PERSIS_ERROR("订单持久化失败", 20004),
    ORDER_QUEUE_ERROR("订单加入延时队列失败", 20005),
    ORDER_INIT_ERROR("订单处理handler初始化失败", 20006),
    ORDER_LOG_ERROR("订单日志失败", 20006),
    ;

    private String text;
    private Integer code;

    ErrorCodeEnum(String text, Integer code) {
        this.text = text;
        this.code = code;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
