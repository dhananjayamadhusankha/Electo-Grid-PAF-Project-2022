package org.restapi.crud.ElectroGrid.service;


import java.sql.*;
import java.util.ArrayList;

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
	
	public ArrayList<crudmodel> getUser() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from user";

		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setName(rs.getString("name"));
			model.setEmail(rs.getString("email"));
			model.setAddress(rs.getString("address"));
			model.setPhoneno(rs.getString("phoneno"));
			model.setType(rs.getString("type"));
			
			data.add(model);
		}
		
		return data;
	}
	
	

}
