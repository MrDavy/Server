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
 * ��½
 * 
 * @author Davy_Tian
 *
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��½�ˣ��쿪�ţ�");
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		System.out.println("���յ���֤�룺"+code);
		System.out.println("���յ��ֻ��ţ�"+phone);
		HttpSession session = request.getSession();
		String scode = (String) session.getAttribute("code");
		String sphone=(String) session.getAttribute("phone");
		System.out.println("�������֤�룺"+scode);
		System.out.println("������ֻ��ţ�"+sphone);
		if(!phone.equals(sphone)){
			out.println("{\"status\":\"error\", \"rs\":\"�ֻ��Ŵ���\" }");
			out.close();
			return;
		}
		if (!code.equals(scode)) {
			out.println("{\"status\":\"error\", \"rs\":\"��֤�����\" }");
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
			out.println("{\"status\":\"error\", \"rs\":\"ϵͳ�쳣\" }");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
