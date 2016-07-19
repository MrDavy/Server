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
 * 获取验证码
 */
public class GetCodeServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone=request.getParameter("phone");
		System.out.println(phone+" 来拿验证码！");
		if(out==null||phone==null||phone==""){
			System.out.println("手机号为空");
			out.println("{\"status\":\"error\",\"rs\":\"手机号不能为空\"}");
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
			// 设置session
			session.setAttribute("code", b.toString());
			session.setAttribute("phone", phone);
			// 设置session 120秒有效
			session.setMaxInactiveInterval(120);
			String rs = b.toString();
			System.out.println("生成验证码：" + rs);
			out.println("{\"status\":\"ok\",\"rs\":" + "\""+rs+"\"" + "}");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"获取验证码失败\"}");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
