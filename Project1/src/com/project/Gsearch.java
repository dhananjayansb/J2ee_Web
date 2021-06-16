package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Gsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String search = request.getParameter("search");
		response.sendRedirect("https://www.google.com/search?q="+search);
	}

}
