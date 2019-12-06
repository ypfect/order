package com.overstar.order.service;

import com.overstar.order.OrderServiceApplication;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.OrderStarDetail;
import com.overstar.order.mapper.OrderBaseMapper;
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
    @Autowired
    private OrderBaseMapper orderBase;

    @Test
    public void contextLoads() {
        System.out.println(1);
    }


    @Test
    public void testItem(){
        OrderStarDetail orderStarDetail = new OrderStarDetail();
        orderStarDetail.setSkuId(111l);
        orderStarDetail.setOrderNo(222222l);
        orderStarDetail.setProductName("test");
        orderStarDetail.setMarketPrice(BigDecimal.ONE);
        orderStarDetail.setUpdateTime(LocalDateTime.now());
        orderStarDetail.setProductId(2222l);
        orderStarDetail.setAmount(BigDecimal.ONE);
        orderStarDetail.setSkuProperties("asdasd");
        orderStarDetail.setSkuMainPic("/asdwaw");
        orderStarDetail.setUserId(33);
        mapper.insert(orderStarDetail);
    }




    @Test
    public void testOrder(){
        OrderBase base = new OrderBase();
        base.setUserId(222);
        base.setShipTime(LocalDateTime.now());
        base.setLeaveWord("dingdan xit ..");
        base.setNeedBill((byte) 1);
        base.setShipSendTime(LocalDateTime.now());
        base.setShipSendTime(LocalDateTime.now());
        base.setOrderFrom((byte) 2);
        base.setSaleReturnState((byte) 11);
        base.setNeedBill((byte)1);
        base.setSaleReturnState((byte)1);
        base.setCommentStatus((byte)3);
        base.setTotalMoney(BigDecimal.ONE);
        base.setDiscountMoney(BigDecimal.ONE);
        base.setRealMoney(BigDecimal.ONE);
        base.setState((byte)1);
        base.setPayMoney(BigDecimal.ONE);
        base.setCarriageFee(BigDecimal.ONE);
        orderBase.insert(base);
    }

}
