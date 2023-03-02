package com.bit.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.ajax.model.ListDao;

public class UpdateController extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   resp.setHeader("Access-Control-Allow-Origin", "*");
	    resp.setHeader("Access-Control-Allow-Methods","*");//겟만허용
      String param1 = req.getParameter("subject");
      String param2 = req.getParameter("content");
      String param3 = req.getParameter("num");
//      String param3 = req.getParameter("sal");
      String subject = param1.trim();
      String content = param2.trim();
      int num = Integer.parseInt(param3.trim());
      System.out.println(num);
      ListDao dao = new ListDao();
      dao.update(num, subject, content);
//      if(dao.insertOne(subject, content)>0) {
//    	  resp.setStatus(201);
//      }else {
//    	  resp.setStatus(400);
//      }
      System.out.println("updatecontroller");
//      resp.sendRedirect("list.do");
   }
}