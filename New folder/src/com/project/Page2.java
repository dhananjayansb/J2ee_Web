package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		out.println("Welcome Home "+name);
		
	}

}
