package com.dongyang.step3;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 * 
 */
@WebServlet("/calcStep3")
public class CalculatorStep3 extends HttpServlet {
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Cookie[] cookies = request.getCookies();	
		
		String v_=request.getParameter("v");
		String operator_=request.getParameter("operator");
		
		int v = 0;
		
		if( !v_.equals("")) 
			v=Integer.parseInt(v_);
		
	
		if(operator_.equals("=")){
			
			int x=0;
			for(Cookie c : cookies){
				if(c.getName().equals("value")){
					x = Integer.parseInt(c.getValue());
					break;
				}					
			}	
			
			String operator ="";
			for(Cookie c : cookies){
				if(c.getName().equals("op")){
					operator = c.getValue();
					break;
					}				
			}				
			
			//int x = (Integer)application.getAttribute("value") ;
			//String op = (String)application.getAttribute("op");

			int result =0 ;
			if (operator.equals("+"))  
				result=x+v;
			else  
				result=x-v;
			
			PrintWriter out=response.getWriter();
			out.write("결과는 " + result);
			
		}else {

			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", operator_);
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calcStep3.html");
		}
		
	
		
		
	}



}
