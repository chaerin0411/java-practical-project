package com.dongyang.step2;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 * 
 */
@WebServlet("/calcStep2")
public class CalculatorStep2 extends HttpServlet {
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String v_=request.getParameter("v");
		String operator_=request.getParameter("operator");
		
		int v = 0;
		
		if( !v_.equals("")) v=Integer.parseInt(v_);
		
		ServletContext application= request.getServletContext();
		//HttpSession session = request.getSession();
		
		if(operator_.equals("=")){
			int x = (Integer)application.getAttribute("value") ;
			int y = v;
			String op = (String)application.getAttribute("op");
			
			int result =0 ;
			if (op.equals("+"))  result=x+y;
			else  result=x-y;
			PrintWriter out=response.getWriter();
			out.write("결과는 " + result);
			
		}else {
			application.setAttribute("value", v);
			application.setAttribute("op", operator_);			
		}
		
	
	
		
		
	}



}
