package com.infy.insurancemall.dao;

import java.util.ArrayList;

import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.entity.OrderEntity;

/**
 * 订单数据持久化
 * 
 * @author Davy_Tian
 *
 */
public interface OrderDao {
	/**
	 * 保存客户信息和订单信息
	 * @param applicantEntity 投保人实体
	 * @param recognizeeEntity  被保人实体
	 * @param orderEntity 订单实体
	 * @throws Exception
	 */
	public void orderSubmit(OrderEntity orderEntity)
			throws Exception;
	
	/**
	 * 根据登陆用户手机号和付款状态查询订单
	 * @param phone 用户手机号
	 * @param payState	支付状态，"已支付"，"待付款"
	 * @return	所有满足条件的订单实体
	 * @throws Exception
	 */
	public ArrayList<OrderDetailEntity> queryOrders(String phone,String payState) throws Exception;
	
	/**
	 * 根据订单id查询订单详情
	 * @param orderId 订单id
	 * @return 订单详细信息
	 * @throws Exception
	 */
	public OrderDetailEntity queryOrderDetailById(int orderId) throws Exception;

}
