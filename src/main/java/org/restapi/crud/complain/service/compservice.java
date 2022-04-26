package org.restapi.crud.complain.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.restapi.crud.complain.model.compmodel;

public class compservice {
	
Connection con;
	
	public compservice () {
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
	
	//Add details about the complain
	public compmodel insertComp(compmodel comp) {
		
		// create a prepared statement
		String insert = "insert into complain (cusId, cusName, date, compType, compDcription) values(?,?,?,?,?) ";
				
		// binding values to user table
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setInt(1, comp.getCusId());
			ps.setString(2, comp.getCusName());
			ps.setString(3, comp.getDate());
			ps.setString(4, comp.getCompType());
			ps.setString(5, comp.getCompDcription());
			
			//execute the statement
			ps.execute();
			System.out.println("Successfully added!");
				
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return comp;
	}
	

}