package com.overstar.order.service;

import com.overstar.core.exception.BaseException;
import com.overstar.core.vo.Result;
import com.overstar.order.export.api.IOrderService;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.PayBill;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 14:22
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class OrderService implements IOrderService {
    @Override
    public Result create(OrderBase formOrderBase, Long addressId, Long billId) {
        BaseException baseException = new BaseException();
        return Result.fail(baseException,"一个异常！");
//        return Result.success("就是一个data");
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
