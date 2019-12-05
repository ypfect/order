package com.overstar.order.web;

import com.overstar.order.export.domain.OrderStarDetail;
import com.overstar.order.mapper.OrderStarDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/12/5 16:35
 */
@RestController
public class MasterSlaveController {

    @Autowired
    private OrderStarDetailMapper mapper;

    @RequestMapping("/ms")
    public String ms(){
        OrderStarDetail orderStarDetail = new OrderStarDetail();
        orderStarDetail.setId(1l);
        orderStarDetail.setOrderNo(222222l);
        orderStarDetail.setProductName("test");
        orderStarDetail.setMarketPrice(BigDecimal.ONE);
        orderStarDetail.setUpdateTime(LocalDateTime.now());
        orderStarDetail.setSkuId(1l);
        mapper.insert(orderStarDetail);
        return "success";
    }
}
