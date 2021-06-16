package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Form2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String college = request.getParameter("college");
		String year = request.getParameter("year");
		String cgpa = request.getParameter("cgpa");
		ServletContext context = getServletContext();
		Details d = (Details)context.getAttribute("Details");
		String name = d.getName();
		String email = d.getEmail();
		out.println("<center>");
		out.println("<h1>Application Form</h1>");
		out.println("<br>"+"<br>");
		out.println("Name : "+name+"<br>"+"<br>");
		out.println("Email : "+email+"<br>"+"<br>");
		out.println("Collage Name : "+college+"<br>"+"<br>");
		out.println("Passed out year : "+year+"<br>"+"<br>");
		out.println("CGPA obtained : "+cgpa);
		
			
	}

}
