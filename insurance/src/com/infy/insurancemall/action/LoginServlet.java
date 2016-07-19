package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.insurancemall.exception.PhoneNumFormatErrorException;
import com.infy.insurancemall.service.LoginService;
import com.infy.insurancemall.service.imp.LoginServiceImp;

/**
 * 登陆
 * 
 * @author Davy_Tian
 *
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("登陆了，快开门！");
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		System.out.println("接收的验证码："+code);
		System.out.println("接收的手机号："+phone);
		HttpSession session = request.getSession();
		String scode = (String) session.getAttribute("code");
		String sphone=(String) session.getAttribute("phone");
		System.out.println("服务端验证码："+scode);
		System.out.println("服务端手机号："+sphone);
		if(!phone.equals(sphone)){
			out.println("{\"status\":\"error\", \"rs\":\"手机号错误\" }");
			out.close();
			return;
		}
		if (!code.equals(scode)) {
			out.println("{\"status\":\"error\", \"rs\":\"验证码错误\" }");
			out.close();
			return;
		}
		try {
			LoginService service = new LoginServiceImp();
			service.login(phone);
			out.println("{\"status\":\"ok\"}");
		} catch (PhoneNumFormatErrorException e1) {
			out.println("{\"status\":\"error\", \"rs\":" + e1.getMessage()
					+ " }");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\", \"rs\":\"系统异常\" }");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
