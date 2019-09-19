package com.overstar.order.export.vo;

import com.overstar.order.export.domain.OrderStarDetail;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 15:58
 */
@Data
public class StarOrderCreateParam extends OrderCreateParamBase {
    private List<ShoppingCart> shoppingCarts;
    private List<OrderStarDetail> details;
}
