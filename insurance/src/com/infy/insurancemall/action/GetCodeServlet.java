package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��ȡ��֤��
 */
public class GetCodeServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone=request.getParameter("phone");
		System.out.println(phone+" ������֤�룡");
		if(out==null||phone==null||phone==""){
			System.out.println("�ֻ���Ϊ��");
			out.println("{\"status\":\"error\",\"rs\":\"�ֻ��Ų���Ϊ��\"}");
			out.close();
			return;
		}
		HttpSession session = request.getSession();
		String str[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		Random r = new Random();
		String s = "";
		try {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int index = r.nextInt(10);
				b.append(str[index]);
			}
			// ����session
			session.setAttribute("code", b.toString());
			session.setAttribute("phone", phone);
			// ����session 120����Ч
			session.setMaxInactiveInterval(120);
			String rs = b.toString();
			System.out.println("������֤�룺" + rs);
			out.println("{\"status\":\"ok\",\"rs\":" + "\""+rs+"\"" + "}");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"��ȡ��֤��ʧ��\"}");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
