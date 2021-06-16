package com.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class App2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		ServletContext context = getServletContext();
		String phone = context.getInitParameter("phone");
		out.println("Phone number :"+phone);
		out.println("Email : "+email);
		Cookie ck[]=request.getCookies();
		out.print("Welcome Mr. "+ck[0].getValue());
		out.close();
		out.println("<br>");
		out.println("<br>");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action = 'gcall' method='POST'>");
		out.println("Search : <input type='text' name='search'>");
		out.println("<br><br>");
		out.println("<input type='submit' value='Search'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
