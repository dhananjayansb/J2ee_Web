package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao 
{
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Employee e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into employee(name,fathername,email,phone,designation,salary,address,gender,dob) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getFathername());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getPhone());
			ps.setString(5,e.getDesignation());
			ps.setFloat(6,e.getSalary());
			ps.setString(7,e.getAddress());
			ps.setString(8,e.getGender());
			ps.setString(9,e.getDob());

			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Employee e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update employee set name=?,fathername=?,email=?,phone=?,designation=?,salary=?,address=?,gender=?,dob=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getFathername());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getPhone());
			ps.setString(5,e.getDesignation());
			ps.setFloat(6,e.getSalary());
			ps.setString(7,e.getAddress());
			ps.setString(8,e.getGender());
			ps.setString(9,e.getDob());
			ps.setInt(10,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Employee getEmployeeById(int id){
		Employee e=new Employee();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setFathername(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setDesignation(rs.getString(6));
				e.setSalary(rs.getFloat(7));
				e.setAddress(rs.getString(8));
				e.setGender(rs.getString(9));
				e.setDob(rs.getString(10));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Employee> getAllEmployees(){
		List<Employee> list=new ArrayList<Employee>();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setFathername(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setDesignation(rs.getString(6));
				e.setSalary(rs.getFloat(7));
				e.setAddress(rs.getString(8));
				e.setGender(rs.getString(9));
				e.setDob(rs.getString(10));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}	
