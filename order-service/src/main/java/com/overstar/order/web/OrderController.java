package com.overstar.order.web;

import com.overstar.order.abs.OrderFactory;
import com.overstar.order.export.vo.StarOrderCreateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/17 23:06
 */
@RestController
public class OrderController {
    @Autowired
    private OrderFactory orderFactory;
    @RequestMapping("/create")
    public long orderCreat(StarOrderCreateParam orderCreateParam){
        return orderFactory.create(orderCreateParam);
    }
}
