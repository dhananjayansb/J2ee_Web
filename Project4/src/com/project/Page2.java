package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String college = request.getParameter("college");
		String year = request.getParameter("year");
		String cgpa = request.getParameter("cgpa");
		Details2 d2 = new Details2();
		d2.setCollege(college);
		d2.setYear(year);
		d2.setCgpa(cgpa);
		HttpSession session= request.getSession(false);
		session.setAttribute("Details2", d2);
		out.println("<html>");
		out.println("<form action='call3' method='POST'>");
		out.println("Phone : <input type='text' name='phone'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Save'>");
		out.println("</form>");
		out.println("</html>");
	
	}

}
