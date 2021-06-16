package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		out.println(name+"<br>");
		out.println(email);
		
		ServletContext context = getServletContext();
		Details d = new Details();
		d.setName(name);
		d.setEmail(email);
		context.setAttribute("Details", d);
		out.println("<html>");
		out.println("<form action='page2' method='POST'>");
		out.println("College : <input type='text' name='college'>");
		out.println("<br>");
		out.println("<br>");
		out.println("Year    : <input type='text' name='year'>");
		out.println("<br>");
		out.println("<br>");
		out.println("CGPA    : <input type='text' name='cgpa'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='save'>");
		out.println("</form>");
		out.println("</html>");
		
	}

}
