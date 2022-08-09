package com.dongyang.step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
@WebServlet("/calculator")
public class CaculatorStep5 extends HttpServlet {
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String exp ="0";
		if(cookies != null){			
			for(Cookie c : cookies){
				if(c.getName().equals("exp")){
					exp = c.getValue();
					break;
					}				
			}	
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"utf-8\">");
		out.write("<title>계산기-step5</title>");
		out.write("<style>");
		out.write("input { width:50px; height:50px}");
		out.write(".output {height:50px; background-color:#e9e9e9; text-align:right; padding:0px 5px; font-size:24px;font-weight:bold;}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form method=\"post\">");
		out.write("	<table>");
		out.write("		<tr>");
		out.printf("			<td colspan=\"4\" class=\"output\"> %s </td>", exp);
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\" \"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("			<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("		</tr>		");		
		out.write("	</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>	");	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		expCookie.setPath("calculator");
		response.addCookie(expCookie);
		response.sendRedirect("calculator");
		

	
		
	}
	
	




}
