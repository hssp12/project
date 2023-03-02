package com.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.ajax.model.ListDao;
import com.bit.ajax.model.ListDto;

public class OneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
	    resp.setHeader("Access-Control-Allow-Methods","*");//겟만허용
		int num=Integer.parseInt(req.getParameter("num"));
//		System.out.println("one param:"+num);
		ListDao dao=new ListDao();
		dao.readCount(num);
		ListDto bean=dao.getOne(num);
		System.out.println("doget=="+num);
//		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		try {
//			out.print("{\"subject\":\"test\",\"content\":\"test\"}");
			out.println("{\"list\":[");
			out.println("{\"subject\":\""+bean.getSubject()
				+"\",\"content\":\""+bean.getContent()
				+"\",\"num\":\""+bean.getNum()
				+"\",\"date\":\""+bean.getDate()
				+"\"}");
			out.println("]}");
//			System.out.println("one param:"+bean.getContent());
		}finally {
			if(out!=null)out.close();
		}
   }
}