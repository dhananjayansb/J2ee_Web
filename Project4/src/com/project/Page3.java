package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		Details3 d3 = new Details3();
		d3.setPhone(phone);
		HttpSession session= request.getSession(false);
		session.setAttribute("Details3", d3);
		Details d = (Details)session.getAttribute("Details");
		Details2 d2 = (Details2)session.getAttribute("Details2");
		String name = d.getName();
		String email = d.getEmail();
		String college = d2.getCollege();
		String year = d2.getYear();
		String cgpa = d2.getCgpa();
		
		out.println("<center>");
		out.println("<h1>Application Form</h1>");
		out.println("<br>"+"<br>");
		out.println("Name : "+name+"<br>"+"<br>");
		out.println("Email : "+email+"<br>"+"<br>");
		out.println("Collage Name : "+college+"<br>"+"<br>");
		out.println("Passed out year : "+year+"<br>"+"<br>");
		out.println("CGPA obtained : "+cgpa+"<br>"+"<br>");
		out.println("Phone Number : "+phone);
		
	
	}

}
