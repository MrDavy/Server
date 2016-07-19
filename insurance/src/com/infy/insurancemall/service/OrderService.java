package com.infy.insurancemall.service;

import java.util.ArrayList;

import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.entity.OrderEntity;

public interface OrderService {
	/**
	 * �������ͻ���Ϣ����
	 * @param applicantEntity
	 * @param recognizeeEntity
	 * @param orderEntity
	 * @throws Exception
	 */
	public void orderSubmit(OrderEntity orderEntity)
			throws Exception;
	
	/**
	 * ���ݵ�½�û��ֻ��ź͸���״̬��ѯ����
	 * @param phone �û��ֻ���
	 * @param payState	֧��״̬��"��֧��"��"������"
	 * @return	�������������Ķ���ʵ��
	 * @throws Exception
	 */
	public ArrayList<OrderDetailEntity> queryOrders(String phone,String payState) throws Exception;
	
	/**
	 * ���ݶ���id��ѯ��������
	 * @param orderId ����id
	 * @return ������ϸ��Ϣ
	 * @throws Exception
	 */
	public OrderDetailEntity queryOrderDetailById(int orderId) throws Exception;
}
