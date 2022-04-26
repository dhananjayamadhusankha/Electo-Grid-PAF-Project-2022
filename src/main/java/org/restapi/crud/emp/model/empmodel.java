package org.restapi.crud.emp.model;

public class empmodel {
	
	private int empId;
	private String name;
	private int age;
	private String address;
	private String email;
	private String telno;
	private String type;
	
	public empmodel() {
		
	}
	
	public empmodel(int empId, String name, int age, String address, String email, String telno, String type) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.telno = telno;
		this.type = type;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
