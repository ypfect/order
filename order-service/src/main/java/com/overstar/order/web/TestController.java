package com.overstar.order.web;

import com.overstar.order.abs.OrderFactory;
import com.overstar.order.export.constants.EnumOrderType;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.vo.Ret;
import com.overstar.order.export.vo.ShoppingCart;
import com.overstar.order.export.vo.Sku;
import com.overstar.order.export.vo.StarOrderCreateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 17:29
 */
@RequestMapping
@RestController
public class TestController {

    @Autowired
    private OrderFactory orderFactory;

    @RequestMapping("test")
    public Ret testOrderCreate() {
        StarOrderCreateParam starOrderCreateParam = new StarOrderCreateParam();
        List<ShoppingCart> cartList = buildShoppingCarts();
        starOrderCreateParam.setShoppingCarts(cartList);
        OrderBase orderBase = buildOrderBase();
        starOrderCreateParam.setOrderBase(orderBase);
        starOrderCreateParam.setOrderCategory(EnumOrderType.STAR_ORDER);
        long l = orderFactory.create(starOrderCreateParam);
        return Ret.success("吃了", l);
    }

    private OrderBase buildOrderBase() {
        OrderBase base = new OrderBase();
        base.setUserId(222l);
        base.setShipTime("晚上九点不见不散");
        base.setLeaveWord("dingdan xit ..");
        base.setNeedBill((byte) 1);
        base.setShipSendTime(System.nanoTime());
        base.setShipSendTime(System.nanoTime());
        base.setOrderFrom((byte) 2);
        base.setSaleReturnState((byte) 11);
        return base;
    }

    private List<ShoppingCart> buildShoppingCarts() {
        Sku sku = buildSku();
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setAmount(i);
            shoppingCart.setCreateTime(System.currentTimeMillis());
            shoppingCart.setProductId(2005L);
            shoppingCart.setSsoId(2006l);
            shoppingCart.setName("一元购");
            shoppingCart.setSelected((byte) 1);
            shoppingCart.setStoreId(222l);
            shoppingCart.setStoreName("家具");
            shoppingCart.setSkuMainPic("http://pic2.itrip.com/p/2018208-05842.jpg");
            shoppingCart.setSkuProperties("length=111;weight=22");
            shoppingCart.setSkuId(11l);
            shoppingCart.setSku(sku);

            shoppingCarts.add(shoppingCart);
        }
        return shoppingCarts;

    }

    private Sku buildSku() {
        Sku sku = new Sku();
        sku.setAvailableStock(20);
        sku.setCostPrice(new BigDecimal(20.22));
        sku.setCreateTime(System.currentTimeMillis());
        sku.setSkuName("sku名称");
        sku.setUpdateTime(System.nanoTime());
        sku.setFrozenStock(5);
        sku.setProductId(5555l);
        sku.setSaleCount(22222);
        sku.setSkuMainPic("http://pic2.itrip.com/p/2018208-05842.jpg");
        sku.setPrice(new BigDecimal(6666));
        sku.setSkuCode("op-iw-la-00-2a-2d");
        sku.setMarketPrice(new BigDecimal(666.88));
        sku.setSortIndex(20);
        return sku;
    }
}
