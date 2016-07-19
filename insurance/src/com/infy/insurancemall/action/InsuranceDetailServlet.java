package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.infy.insurancemall.entity.InsureEntity;
import com.infy.insurancemall.service.InsuranceService;
import com.infy.insurancemall.service.imp.InsuranceServiceImp;

/**
 * 查询保险详细信息
 */
public class InsuranceDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// ObjectOutputStream oos=new
		// ObjectOutputStream(response.getOutputStream());
		String uri = request.getRequestURI();
		System.out.println(uri);
		String _id = uri.substring(uri.lastIndexOf("/") + 1);
		int id = Integer.parseInt(_id);
		System.out.println(id);
		try {
			InsuranceService service = new InsuranceServiceImp();
			InsureEntity entity = service.findInsureDetailEntityById(id);
			// oos.writeObject(entity);
			System.out.println(entity.toString());
			JSONObject jsonObject = JSONObject.fromObject(entity);
			String json = jsonObject.toString();
			System.out.println(json);
			out.println("{\"status\":\"ok\",\"rs\":" + json + "}");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"获取数据失败\"}");
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}

}
