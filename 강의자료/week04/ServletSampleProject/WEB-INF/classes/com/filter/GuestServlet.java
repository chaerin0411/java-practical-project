package com.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/guest")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vistor_=request.getParameter("vistor");
		String contents_=request.getParameter("contents");
		request.setAttribute("vistor", vistor_);
		request.setAttribute("contents", contents_);
		RequestDispatcher dispatcher = request.getRequestDispatcher("guestBookFinal.jsp");
		dispatcher.forward(request, response);
	}

}
