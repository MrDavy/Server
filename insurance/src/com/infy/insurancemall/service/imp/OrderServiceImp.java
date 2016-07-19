package com.infy.insurancemall.service.imp;

import java.util.ArrayList;

import com.infy.insurancemall.dao.OrderDao;
import com.infy.insurancemall.dao.OrderDaoImp;
import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.entity.OrderEntity;
import com.infy.insurancemall.service.OrderService;

public class OrderServiceImp implements OrderService {

	@Override
	public void orderSubmit(OrderEntity orderEntity) throws Exception {
		OrderDao dao = new OrderDaoImp();
		dao.orderSubmit(orderEntity);
	}

	@Override
	public ArrayList<OrderDetailEntity> queryOrders(String phone, String payState)
			throws Exception {
		OrderDao dao = new OrderDaoImp();
		ArrayList<OrderDetailEntity> orderEntities = dao.queryOrders(phone, payState);
		return orderEntities;
	}

	@Override
	public OrderDetailEntity queryOrderDetailById(int orderId) throws Exception {
		OrderDao dao=new OrderDaoImp();
		OrderDetailEntity detailEntity=dao.queryOrderDetailById(orderId);
		return detailEntity;
	}

}
