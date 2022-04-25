package org.restapi.crud.ElectroGrid.service;


import java.sql.*;

import org.restapi.crud.ElectroGrid.model.crudmodel;


public class crudservice {
	
	Connection con;
	
	public crudservice()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/electrodb", "root","");
			System.out.println("Success");
		}
		catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into user(name, email, address, phoneno, type) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getPhoneno());
			ps.setString(5, user.getType());
			
			ps.execute();
			System.out.println("Successfully added!");
				
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
	
	}
	
	

}
