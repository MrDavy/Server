package com.infy.insurancemall.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.infy.insurancemall.entity.InsureEntity;
import com.infy.insurancemall.service.imp.InsuranceServiceImp;
import com.infy.insurancemall.util.Consts;

/**
 * ���������ͻ�ȡ������Ϣ
 */
public class InsuranceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		System.out.println(uri);
		String ty = uri.substring(uri.lastIndexOf("/") + 1);
		ArrayList<InsureEntity> entities = null;
		try {
			InsuranceServiceImp serviceImp = new InsuranceServiceImp();
			if (ty.equals("favorate")) {
				entities = serviceImp.favorateInsurance(Consts.DATA_COUNTS);
			} else if(ty.matches("[\\d]")){
				System.out.println("����ƥ��");
				int type = Integer.parseInt(ty);
				entities = serviceImp.findInsuranceByType(type);
			}
			JSONArray array = JSONArray.fromObject(entities);
			String json = array.toString();
			System.out.println(json);
			out.println("{\"status\":\"ok\",\"rs\":" + json + "}");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"status\":\"error\",\"rs\":\"��ȡ����ʧ��\"}");
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}
}
