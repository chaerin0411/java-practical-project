package com.dongyang.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcStep1")
public class CalucatorStep1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String x_=request.getParameter("x");
		String y_=request.getParameter("y");
		String operator_=request.getParameter("operator");
		
		int x = 0;
		int y = 0;
		
		if( !x_.equals("")) x=Integer.parseInt(x_);
		if( !y_.equals("")) y=Integer.parseInt(y_);
		
		int result =0 ;
		if (operator_.equals("덧셈"))  result=x+y;
		else  result=x-y;
		
		PrintWriter out=response.getWriter();
		out.write(x_ + " " +operator_ + " " + y_ + "=" + result);
		
	}

}
