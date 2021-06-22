package com.model;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String fathername=request.getParameter("fathername");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String designation=request.getParameter("designation");
		float salary=Float.parseFloat(request.getParameter("salary"));
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setFathername(fathername);
		e.setEmail(email);
		e.setPhone(phone);
		e.setDesignation(designation);
		e.setSalary(salary);
		e.setAddress(address);
		e.setGender(gender);
		e.setDob(dob);
		
		int status=EmployeeDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}

