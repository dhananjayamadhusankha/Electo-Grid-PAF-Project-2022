package org.restapi.crud.ElectroGrid.model;

public class crudmodel {
	
	private String name;
	private String email;
	private String address;
	private String phoneno;
	private String type;
	
	public crudmodel() {
		
	}

	public crudmodel(String name, String email, String address, String phoneno, String type) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneno = phoneno;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
