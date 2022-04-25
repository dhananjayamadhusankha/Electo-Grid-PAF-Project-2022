package org.restapi.crud.power.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	//retrieve all data
	public ArrayList<powermodel> getPower() throws SQLException{
		
		ArrayList<powermodel> data = new ArrayList<powermodel>();
		
		String select = "select * from power";
		
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			powermodel power = new powermodel();
			
			power.setCusname(rs.getString("cusname"));
			power.setpAccNo(rs.getString("pAccNo"));
			power.setPsUnit(rs.getInt("psUnit"));
			power.setpDate(rs.getString("pDate"));
			power.setpAmout(rs.getDouble("pAmout"));
			
			data.add(power);
		}
		
		return data;
	}
	


}
