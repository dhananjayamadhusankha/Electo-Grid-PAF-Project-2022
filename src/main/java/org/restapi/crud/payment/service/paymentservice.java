package org.restapi.crud.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.payment.model.paymentmodel;


public class paymentservice {
	
	
Connection con;
	
	public paymentservice () {
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
	public paymentmodel insertPayment(paymentmodel payment) {
		
		// create a prepared statement
		String insert = "insert into payment (cusID, telNo, date, amount, cardNumber, postalNumber) values(?,?,?,?,?,?) ";
				
		// binding values to user table
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, payment.getCusID());
			ps.setString(2, payment.getTelNo());
			ps.setString(3, payment.getDate());
			ps.setDouble(4, payment.getAmount());
			ps.setInt(5, payment.getCardNumber());
			ps.setInt(6, payment.getPostalNumber());
			
			//execute the statement
			ps.execute();
			System.out.println("Successfully added!");
				
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return payment;
	}
	
	//retrieve all data
	public ArrayList<paymentmodel> getPayment() throws SQLException{
		
		ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
		
		String select = "select * from payment";
		
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			paymentmodel payment = new paymentmodel();
			
			payment.setCusID(rs.getString("cusID"));
			payment.setTelNo(rs.getString("telNo"));
			payment.setDate(rs.getString("date"));
			payment.setAmount(rs.getDouble("amount"));
			payment.setCardNumber(rs.getInt("cardNumber"));
			payment.setPostalNumber(rs.getInt("postalNumber"));
			
			data.add(payment);
		}
		
		return data;
	}
	//search by id
		public ArrayList<paymentmodel> getPaymentByID(int payID) throws SQLException{
			
			ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
				
			String select = "select * from payment where payID = ?";
			
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, payID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				paymentmodel model = new paymentmodel();
				
				model.setCusID(rs.getString("cusID"));
				model.setTelNo(rs.getString("telNo"));
				model.setDate(rs.getString("date"));
				model.setAmount(rs.getDouble("amount"));
				model.setCardNumber(rs.getInt("cardNumber"));
				model.setPostalNumber(rs.getInt("postalNumber"));
				
				data.add(model);
			}

			return data;
		}
		
		//Update the power details
		public paymentmodel updatePayment (paymentmodel payment) {
			
		// create a prepared statement
		String insert = "update payment set cusID=?, telNo=?, date=?, amount=?, cardNumber=?, postalNumber=?"
				+ "where payID=?";
		
		// binding values to query
		try {
			PreparedStatement ps = con.prepareStatement(insert);
				
			ps.setString(1, payment.getCusID());
			ps.setString(2, payment.getTelNo());
			ps.setString(3, payment.getDate());
			ps.setDouble(4, payment.getAmount());
			ps.setInt(5, payment.getCardNumber());
			ps.setInt(6, payment.getPostalNumber());
			ps.setInt(7, payment.getPayID());
			
			// Execute the statement
			ps.executeUpdate();
			System.out.println("Successfully Updated!");
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			return payment;
		}
		
		// implement the delete power
		public int deletePayment (int payID) {
			
		// create a prepared statement
		String insert = "delete from payment where payID=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setInt(1, payID);
			
			// executing the statements
			ps.executeUpdate();
			System.out.println("Successfully deleted!");
				
		} catch(Exception e) {
			System.out.println(e +"data delete unsuccess.");
		}
		
		return payID;
		
		}
	
	

}
