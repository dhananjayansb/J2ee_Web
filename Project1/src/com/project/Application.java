package com.project;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("na");
		PrintWriter out = response.getWriter();
		out.println(name);
		out.println("<br>");
		out.println("<br>");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action = 'call2' method='POST'>");
		out.println("Email ID : <input type='text' name='email'>");
		out.println("<br><br>");
		out.println("<input type='submit' value='click'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
