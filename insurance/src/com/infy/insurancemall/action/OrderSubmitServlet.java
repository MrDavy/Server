package com.infy.insurancemall.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.insurancemall.entity.OrderEntity;
import com.infy.insurancemall.exception.JsonNullPointerException;
import com.infy.insurancemall.parser.JsonParser;
import com.infy.insurancemall.service.OrderService;
import com.infy.insurancemall.service.imp.OrderServiceImp;

/**
 * �����ύ
 */
@WebServlet("/ordersubmit")
public class OrderSubmitServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		OrderEntity orderEntity = null;
		InputStream in = null;
		BufferedReader reader = null;
		try {
			in = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			StringBuilder builder = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			line = builder.toString();
			System.out.println(line);
			if (line != "") {
				/** ����json�ַ���,�õ�����ʵ�� */
				JsonParser jsonParser = new JsonParser();
				orderEntity = jsonParser.parseOrderData(line);
				System.out.println(orderEntity.toString());
				OrderService service = new OrderServiceImp();
				service.orderSubmit(orderEntity);
				out.println("{\"status\":\"ok\"}");
			} else {
				throw new JsonNullPointerException();
			}
		} catch (JsonNullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\", \"rs\":\"ϵͳ�쳣\" }");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
