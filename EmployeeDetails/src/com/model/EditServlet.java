package com.model;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Employee e=EmployeeDao.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name :</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Father Name :</td><td><input type='text' name='fathername' value='"+e.getFathername()+"'/></td></tr>");
		out.print("<tr><td>Email :</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Phone :</td><td><input type='number' name='phone' value='"+e.getPhone()+"'/></td></tr>");
		out.print("<tr><td>Designation:</td><td>");
		out.print("<select name='designation' style='width:150px'>");
		out.print("<option>Full Stack Developer</option>");
		out.print("<option>Back End Developer</option>");
		out.print("<option>Front End Developer</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>Salary :</td><td><input type='float' name='salary' value='"+e.getSalary()+"'/></td></tr>");
		out.print("<tr><td>Address :</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td>Gender :</td><td><input type=\"radio\" id=\"genderChoice1\"\r\n" + 
				"     name=\"gender\" value=\"male\">\r\n" + 
				"    <label for=\"Choice1\">Male</label>\r\n" + 
				"    <input type=\"radio\" id=\"genderChoice2\"\r\n" + 
				"     name=\"gender\" value=\"female\">\r\n" + 
				"    <label for=\"Choice2\">Female</label></td></tr>");
		out.print("<tr><td>Date of Birth :</td><td><input type='date' name='dob' value='"+e.getDob()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
