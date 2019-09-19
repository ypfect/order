package com.overstar.order.abs;


import com.overstar.order.export.constants.EnumOrderType;
import com.overstar.order.export.vo.OrderCreateParamBase;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 15:53
 */
public interface IOrderService {

    long orderCreate(OrderCreateParamBase orderCreateParamBase);

    EnumOrderType orderCategory();
}
