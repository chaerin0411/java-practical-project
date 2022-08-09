package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MvcControllerSimple
 */
@WebServlet("/controllerSimple")
public class MvcControllerSimple extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num_ = request.getParameter("n");
		  int num = 0;
		  if(num_!=null && !num_.equals("")){
				num = Integer.parseInt(num_);}
		  String model = ""; 
		  if(num%2==0){
			  model = "짝수";
		  } else {
			  model = "홀수";
		  }
		 request.setAttribute("result", model);
		  
		 RequestDispatcher dispatcher = request.getRequestDispatcher("mvcSimple3.jsp");
		 dispatcher.forward(request, response);
		  
	}
	
	
}
