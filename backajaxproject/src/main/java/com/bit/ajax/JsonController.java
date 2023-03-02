package com.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.ajax.model.ListDao;
import com.bit.ajax.model.ListDto;

public class JsonController extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("jsoncontroller");
	resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setHeader("Access-Control-Allow-Methods","*");//겟만허용
//    resp.setContentType("application/json; charset=utf8");
   ListDao dao = new ListDao();
   resp.setCharacterEncoding("utf-8");
   PrintWriter out = resp.getWriter();
   try {
      out.println("{\"list\":[");
      List<ListDto> list = dao.getList();
      for(int i = 0; i<list.size(); i++) {
         ListDto bean = list.get(i);
//         System.out.println(bean.getDate());
         if(i != 0) out.print(",");
         out.println("{\"num\":"+bean.getNum()+", \"subject\":\"" + bean.getSubject() + "\", \"content\":\""+bean.getContent()
         +"\", \"date\":\""+bean.getDate()+"\", \"readcount\":"+bean.getReadcount()+"}");
      }
      out.println("]}");
      
   }finally { 
      if(out != null) out.close();
   }
}
}