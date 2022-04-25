package org.restapi.crud.power.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.restapi.crud.power.model.powermodel;

public class powerservice {
	
	Connection con;
	
	public powerservice () {
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
	
	//Add details about the power bill
	public powermodel insertPower(powermodel power) {
		
		// create a prepared statement
		String insert = "insert into power (cusname, pAccNo, psUnit, pDate, pAmout) values(?,?,?,?,?) ";
				
		// binding values to user table
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, power.getCusname());
			ps.setString(2, power.getpAccNo());
			ps.setLong(3, power.getPsUnit());
			ps.setString(4, power.getpDate());
			ps.setDouble(5, power.getpAmout());
			
			
			//execute the statement
			ps.execute();
			System.out.println("Successfully added!");
				
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return power;
	}


}
