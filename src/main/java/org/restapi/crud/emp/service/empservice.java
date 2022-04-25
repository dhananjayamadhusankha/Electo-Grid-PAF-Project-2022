package org.restapi.crud.emp.service;

import java.sql.*;
import java.util.ArrayList;

import org.restapi.crud.emp.model.empmodel;

public class empservice {
	
	Connection con;
	
	public empservice()  {
		
		//Database Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/electrodb", "root","");
			System.out.println("Success");
		}
		catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
public empmodel insertEmp (empmodel emp) {
	
	// create a prepared statement
	String insert = "insert into employee (name, age, address, email, telno, type) values(?,?,?,?,?,?)";
	
	// binding values to user table
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		
		ps.setString(1, emp.getName());
		ps.setLong(2, emp.getAge());
		ps.setString(3, emp.getAddress());
		ps.setString(4, emp.getEmail());
		ps.setString(5, emp.getTelno());
		ps.setString(6, emp.getType());
		
		//execute the statement
		ps.execute();
		System.out.println("Successfully added!");

	} catch (Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return emp;
	}

	//retrieve all data

	public ArrayList<empmodel> getEmp() throws SQLException {
		
		ArrayList<empmodel>  data = new ArrayList<empmodel>();
		
		String select = "select * from employee";
		
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			empmodel emp = new empmodel();
			
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setAddress(rs.getString("address"));
			emp.setEmail(rs.getString("email"));
			emp.setTelno(rs.getString("telno"));
			emp.setType(rs.getString("type"));
			
			data.add(emp);
		}
		
		return data;
	}
	
	//search by id
		public ArrayList<empmodel> getEmpById (int empId) throws SQLException{
			
			ArrayList<empmodel> data = new ArrayList<empmodel>();
			
			String select = "select * from employee where empId = ?";
			
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				empmodel emp = new empmodel();
		
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setAddress(rs.getString("address"));
				emp.setEmail(rs.getString("email"));
				emp.setTelno(rs.getString("telno"));
				emp.setType(rs.getString("type"));
				
				data.add(emp);
			}
			
			return data;
		}
		
	//Update the user details
	public empmodel updateEmp (empmodel emp) {
		
		// create a prepared statement
		String insert = "update employee set name=?, age=?, address=?, email=?, telno=?, type=? "
				+ "where empId=?";
				
		// binding values to user table
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, emp.getName());
			ps.setLong(2, emp.getAge());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getTelno());
			ps.setString(6, emp.getType());
			
			// Execute the statement
			ps.executeUpdate();
			System.out.println("Successfully Updated!");

		} catch (Exception e) {
			System.out.println(e +"data update unsuccess.");
		}
		
		return emp;
	}
			

}
