package com.overstar.order.abs;

import com.overstar.order.export.constants.EnumOrderType;
import com.overstar.order.export.constants.ErrorCodeEnum;
import com.overstar.order.export.excption.OrderException;
import com.overstar.order.export.vo.OrderCreateParamBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/18 20:04
 */
@Service
public class OrderFactory {

    @Autowired
    private Map<String, IOrderStepService> autoMap;
    private static HashMap<EnumOrderType, IOrderStepService> orderServiceMap = new HashMap<>();

    /**
     * 初始化服务
     */
    @PostConstruct
    private void initOrderServer() {
        //这里直接直接autowired
        Map<String, IOrderStepService> beans = autoMap;
        if (CollectionUtils.isEmpty(beans)) {
            throw new OrderException(ErrorCodeEnum.ORDER_INIT_ERROR);
        }
        orderServiceMap.clear();
        beans.forEach((s, iOrderStepService) -> {
            if (iOrderStepService.orderCategory() == null) return;
            if (orderServiceMap.containsKey(iOrderStepService.orderCategory())) {
                throw new RuntimeException(iOrderStepService.getClass().getName() + ", handlerType return value repeat with "
                        + orderServiceMap.get(iOrderStepService.orderCategory()).getClass().getName());
            }
            orderServiceMap.put(iOrderStepService.orderCategory(), iOrderStepService);
        });

    }



    public long create(OrderCreateParamBase createParamBase) {
        EnumOrderType orderCategory = createParamBase.getOrderCategory();
        IOrderStepService iOrderStepService = orderServiceMap.get(orderCategory);
        return iOrderStepService.orderCreate(createParamBase);
    }

}
