package org.restapi.crud.complain.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	//retrieve all data
		public ArrayList<compmodel> getComp() throws SQLException{
			
			ArrayList<compmodel> data = new ArrayList<compmodel>();
			
			String select = "select * from complain";
			
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				compmodel comp = new compmodel();
				
				comp.setCusId(rs.getInt("cusId"));
				comp.setCusName(rs.getString("cusName"));
				comp.setDate(rs.getString("date"));
				comp.setCompType(rs.getString("compType"));
				comp.setCompDcription(rs.getString("compDcription"));
				
				data.add(comp);
			}
			
			return data;
			
		}
		
		//search by id
		public ArrayList<compmodel> getCompById(int compid) throws SQLException{
			
			ArrayList<compmodel> data = new ArrayList<compmodel>();
				
			String select = "select * from complain where compid = ?";
			
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, compid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				compmodel model = new compmodel();
				
				model.setCusId(rs.getInt("cusId"));
				model.setCusName(rs.getString("cusName"));
				model.setDate(rs.getString("date"));
				model.setCompType(rs.getString("compType"));
				model.setCompDcription(rs.getString("compDcription"));
				
				data.add(model);
			}
			
			return data;
		}
		
}