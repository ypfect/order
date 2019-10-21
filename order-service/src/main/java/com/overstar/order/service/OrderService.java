package com.overstar.order.service;

import com.overstar.order.export.api.IOrderService;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.PayBill;
import com.overstar.order.export.vo.Ret;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 14:22
 */
@Service
public class OrderService implements IOrderService {
    @Override
    public Ret create(OrderBase formOrderBase, Long addressId, Long billId) {
        return Ret.success("下单成功！",200);
    }

    @Override
    public void notifyPayed(PayBill payBill) {

    }

    @Override
    public Map<String, Integer> orderCountBySso(Long ssoId, Integer year) {
        return null;
    }

    @Override
    public OrderBase getBySn(String orderBaseSn) {
        return null;
    }

    @Override
    public OrderBase getById(Long id) {
        return null;
    }

    @Override
    public void cancelBySso(Long ssoId, Long orderBaseId) {

    }

    @Override
    public void cancel(Long orderBaseId) {

    }

    @Override
    public void cancelFailed(Long oldBisKey) {

    }

    @Override
    public void cancelFinished(Long oldBisKey) {

    }

    @Override
    public void deleteBatch(Long ssoId, Long[] orderBaseIdArr) {

    }

    @Override
    public void sendShip(Long[] orderBaseIdArr, Long shipStore, String shipSn) {

    }

    @Override
    public void confirmFinish(long orderBaseId) {

    }

    @Override
    public void confirmFinishBySso(Long ssoId, Long orderBaseId) {

    }

    @Override
    public void cancelByQuartz(long orderBaseId) {

    }

    @Override
    public void confirmFinishByQuartz(long orderBaseId) {

    }
}
