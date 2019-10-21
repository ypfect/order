package com.overstar.order.export.api;

import com.overstar.core.vo.Result;
import com.overstar.order.export.domain.OrderBase;
import com.overstar.order.export.domain.PayBill;

import java.util.Map;

public interface IOrderService {

	/**
	 * 
	 * @param formOrderBase 订单数据
	 * @param addressId 收货地址id
	 * @param billId 发票id
	 * @return
	 */
	Result create(OrderBase formOrderBase, Long addressId, Long billId);

	/**
	 * 通知订单支付成功
	 * @param payBill
	 */
	void notifyPayed(PayBill payBill);

	/**
	 * 通过ssoId查询订单数量
	 * @param ssoId 用户id
	 * @param year 年份
	 * @return
	 * Map: allCount, waitPay, waitSend, waitTake, waitComment
	 */
	Map<String, Integer> orderCountBySso(Long ssoId, Integer year);

	/**
	 * 通过订单号查询订单
	 * @param orderBaseSn
	 * @return
	 */
	OrderBase getBySn(String orderBaseSn);
	
	/**
	 * 通过订单id获取订单
	 * @param id
	 * @return
	 */
	OrderBase getById(Long id);

	/**
	 * 用户取消订单
	 * @param ssoId
	 * @param orderBaseId
	 */
	void cancelBySso(Long ssoId, Long orderBaseId);
	
	/**
	 * 取消订单
	 * @param orderBaseId
	 */
	void cancel(Long orderBaseId);

	/**
	 * 订单取消失败
	 * @param oldBisKey
	 */
	void cancelFailed(Long oldBisKey);

	/**
	 * 订单取消成功
	 * @param oldBisKey
	 */
	void cancelFinished(Long oldBisKey);

	/**
	 * 用户批量删除订单
	 * @param orderBaseIdArr
	 * @param ssoId
	 */
	void deleteBatch(Long ssoId, Long[] orderBaseIdArr);

	/**
	 * 发货确认
	 * @param orderBaseIdArr
	 * @param shipStore 快递服务商ID
	 * @param shipSn 快递单号
	 */
	void sendShip(Long[] orderBaseIdArr, Long shipStore, String shipSn);

	/**
	 * 系统确认收货（订单完成）
	 * @param orderBaseId
	 */
	void confirmFinish(long orderBaseId);

	/**
	 * 用户确认收货（订单完成）
	 * @param ssoId
	 * @param orderBaseId
	 */
	void confirmFinishBySso(Long ssoId, Long orderBaseId);

	/**
	 * 由支付过期定时任务取消
	 * @param orderBaseId
	 */
	void cancelByQuartz(long orderBaseId);

	/**
	 * 由确认收货过期定时任务确认
	 * @param orderBaseId
	 */
	void confirmFinishByQuartz(long orderBaseId);
	
}
