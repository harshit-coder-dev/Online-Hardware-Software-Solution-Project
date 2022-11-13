package com.project.bean;

public class Employee {

	private int empID;
	private String empName;
	private String empUserName;
	private String empPassword;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empID, String empName, String empUserName, String empPassword) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empUserName = empUserName;
		this.empPassword = empPassword;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empUserName=" + empUserName + ", empPassword="
				+ empPassword + "]";
	}
}
