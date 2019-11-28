package com.overstar.order.export.vo;

import com.overstar.order.export.domain.OrderAddress;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.OrderStarDetail;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 15:57
 */
@Data
public class OrderModel extends OrderBase {
    /**
     * 订单明细
     */
    private List<OrderStarDetail> detailList;
    /**
     * 订单地址
     */
    private OrderAddress orderAddress;
}
