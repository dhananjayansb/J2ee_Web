package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		if(username.equals("Dhananjayan") && password.equals("Djrog@26"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("callp2");
			rd.forward(request, response);	
		}
		else
		{
			out.println("Sorry ERROR !! try again :)");
			RequestDispatcher rd =request.getRequestDispatcher("/page1.html");
			rd.include(request, response);
		}
	}

}
