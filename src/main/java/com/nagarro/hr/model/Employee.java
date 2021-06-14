package com.nagarro.hr.model;

public class Employee {

	private int employeecode;
	private String name;
	private String location;
	private String email;
	private String dob;

	public void setEmployeeCode(int employeeCode) {
		this.employeecode = employeeCode;
	}

	public int getEmployeeCode() {
		return employeecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
