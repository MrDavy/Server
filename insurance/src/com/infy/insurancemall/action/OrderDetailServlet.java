package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.service.OrderService;
import com.infy.insurancemall.service.imp.OrderServiceImp;

/**
 * 订单详情
 */
@WebServlet("/orderdetail")
public class OrderDetailServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String uri = request.getRequestURI();
		System.out.println(uri);
		String _id = uri.substring(uri.lastIndexOf("/") + 1);
		int orderId = Integer.parseInt(_id);
		System.out.println(orderId);
		OrderDetailEntity detailEntity=null;
		try{
			OrderService service=new OrderServiceImp();
			detailEntity=service.queryOrderDetailById(orderId);
			JSONObject jsonObject=JSONObject.fromObject(detailEntity);
			String json=jsonObject.toString();
			System.out.println(json);
			out.println("{\"status\":\"ok\",\"rs\":" + json + "}");
		}catch(Exception e){
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"获取数据失败\"}");
		}finally{
			if(out!=null){
				out.close();
			}
		}

	}

}
