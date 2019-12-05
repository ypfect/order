package com.overstar.order.service;

import com.overstar.order.OrderServiceApplication;
import com.overstar.order.export.domain.OrderStarDetail;
import com.overstar.order.mapper.OrderStarDetailMapper;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceApplication.class)
//@ImportResource(locations = "classpath:application-dev.properties")
@ActiveProfiles("dev")
public class OrderServiceApplicationTests {

    @Autowired
    private OrderStarDetailMapper mapper;

    @Test
    public void contextLoads() {
        System.out.println(1);
    }


    @Test
    public void testItem(){
        OrderStarDetail orderStarDetail = new OrderStarDetail();
        orderStarDetail.setOrderNo(222222l);
        orderStarDetail.setProductName("test");
        orderStarDetail.setMarketPrice(BigDecimal.ONE);
        orderStarDetail.setUpdateTime(LocalDateTime.now());
        orderStarDetail.setProductId(2222l);
        orderStarDetail.setSkuMainPic("/asdwaw");
        orderStarDetail.setSkuId(1l);
        orderStarDetail.setUserId(33);
        mapper.insert(orderStarDetail);
    }

}
