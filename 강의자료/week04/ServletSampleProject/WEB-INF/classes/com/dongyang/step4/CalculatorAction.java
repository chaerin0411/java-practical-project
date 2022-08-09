package com.dongyang.step4;


import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
@WebServlet("/calcAction")
public class CalculatorAction extends HttpServlet {
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();	
		
		String value_=request.getParameter("value");
		String operator_=request.getParameter("operator");
		String dot_=request.getParameter("dot");
		
		String exp="";
		
		if(cookies != null){			
			for(Cookie c : cookies){
				if(c.getName().equals("exp")){
					exp = c.getValue();
					break;
					}				
			}	
		}	
		
		if( operator_ != null && operator_.equals("=")){
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		} else if( operator_ != null && operator_.equals("C")){
			exp="";
		
		}else {
			exp += (value_ == null)? "":value_;
			exp += (operator_ == null)? "":operator_;
			exp += (dot_ == null)? "":dot_;	
		}
	
		
		Cookie expCookie = new Cookie("exp", exp);
		if( operator_ != null && operator_.equals("C")){
			expCookie.setMaxAge(0);
		}
		response.addCookie(expCookie);
		response.sendRedirect("calcStep4");
		

	
		
		
	}



}
