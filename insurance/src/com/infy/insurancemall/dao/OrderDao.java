package com.infy.insurancemall.dao;

import java.util.ArrayList;

import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.entity.OrderEntity;

/**
 * �������ݳ־û�
 * 
 * @author Davy_Tian
 *
 */
public interface OrderDao {
	/**
	 * ����ͻ���Ϣ�Ͷ�����Ϣ
	 * @param applicantEntity Ͷ����ʵ��
	 * @param recognizeeEntity  ������ʵ��
	 * @param orderEntity ����ʵ��
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
