package com.overstar.order.export.vo;


import com.overstar.order.export.constants.EnumOrderType;
import com.overstar.order.export.domain.OrderBase;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 15:58
 */
@Data
public class OrderCreateParamBase implements Serializable {
    /**
     * 品类
     */
    private EnumOrderType orderCategory;
    /**
     * 订单基础信息
     */
    private OrderBase orderBase;
}
