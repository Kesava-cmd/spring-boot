package com.org.employee.dto;

public class CreateEmployeeRequest {

	private Integer id;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeMiddleName;
	private String employeeEmail;
	private String employeePhone;
	private String employeeCity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeMiddleName() {
		return employeeMiddleName;
	}

	public void setEmployeeMiddleName(String employeeMiddleName) {
		this.employeeMiddleName = employeeMiddleName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeEmail) {
		this.employeeEmail = employeEmail;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

}
