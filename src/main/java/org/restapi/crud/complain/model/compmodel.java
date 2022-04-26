package org.restapi.crud.complain.model;

public class compmodel {
	
	private int compid;
	private int cusId;
	private String cusName;
	private String date;
	private String compType;
	private String compDcription;
	
	public compmodel () {
		
	}

	public compmodel(int compid, int cusId, String cusName, String date, String compType, String compDcription) {
		super();
		this.compid = compid;
		this.cusId = cusId;
		this.cusName = cusName;
		this.date = date;
		this.compType = compType;
		this.compDcription = compDcription;
	}

	public int getCompid() {
		return compid;
	}

	public void setCompid(int compid) {
		this.compid = compid;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getCompDcription() {
		return compDcription;
	}

	public void setCompDcription(String compDcription) {
		this.compDcription = compDcription;
	}
	
}