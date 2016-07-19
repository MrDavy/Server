package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.service.OrderService;
import com.infy.insurancemall.service.imp.OrderServiceImp;

/**
 * 订单查询
 */
public class OrderQueryServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");
		String userPhone = request.getParameter("phone");
		System.out.println("phone="+userPhone);
		PrintWriter out = response.getWriter();
		String payState = "";
		String uri = request.getRequestURI();
		System.out.println(uri);
		uri = uri.substring(uri.indexOf("order/") + 6);
		System.out.println(uri);
		if (uri.equals("myorder")) {
			payState = "待支付";
		} else if (uri.equals("myinsurance")) {
			payState = "已支付";
		} else {
			return;
		}
		ArrayList<OrderDetailEntity> orderEntities = null;
		try {
			OrderService service = new OrderServiceImp();
			
			System.out.println("payState="+payState);
			orderEntities = service.queryOrders(userPhone, payState);
			JSONArray array = JSONArray.fromObject(orderEntities);
			String json = array.toString();
			System.out.println(json);
			out.println("{\"status\":\"ok\",\"rs\":" + json + "}");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"获取订单数据失败\"}");
		} finally {
			if(out!=null){
				out.close();
			}
		}
	}

}
