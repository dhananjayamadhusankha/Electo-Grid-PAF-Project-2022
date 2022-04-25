package org.restapi.crud.ElectroGrid.service;


import java.sql.*;

import org.restapi.crud.ElectroGrid.model.crudmodel;


public class crudservice {
	
	Connection con;
	
	public crudservice()  {
		
		try {
			String url =String.format("jdbc:mysql://localhost/electrodb");
			String uname ="root";
			String pwd ="root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
			
		} catch (Exception e) {
			System.out.println(e + "data insert unsucess");
		}
	}
	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into user(id, name, email, address, phoneno, type) values(?,?,?,?,?,?) ";
		
		try {
		PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getAddress());
				ps.setString(5, user.getPhoneno());
				ps.setString(6, user.getType());
				
				ps.execute();
				System.out.println("Successfully added!");
				
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
	
	}
	
	

}
