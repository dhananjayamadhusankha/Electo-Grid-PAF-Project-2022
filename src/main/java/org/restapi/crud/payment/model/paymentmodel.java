package org.restapi.crud.payment.model;

public class paymentmodel {
	
    private int payID;
	private String cusID;
	private String telNo;
	private String date;
	private double amount;
	private  int cardNumber;
	private int postalNumber;
	
	public paymentmodel() {
		
		
	}

	public paymentmodel(int payID, String cusID, String telNo, String date, double amount, int cardNumber,
			int postalNumber) {
		super();
		this.payID = payID;
		this.cusID = cusID;
		this.telNo = telNo;
		this.date = date;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.postalNumber = postalNumber;
	}

	public int getPayID() {
		return payID;
	}

	public void setPayID(int payID) {
		this.payID = payID;
	}

	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPostalNumber() {
		return postalNumber;
	}

	public void setPostalNumber(int postalNumber) {
		this.postalNumber = postalNumber;
	}


}
