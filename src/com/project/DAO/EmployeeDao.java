package com.project.DAO;

import java.util.List;

import com.project.bean.Employee;
import com.project.bean.ProblemPro;
import com.project.exceptions.EmployeeException;



public interface EmployeeDao {

	
	// register a employee:
	public String registerEmployee(Employee employee);
	
	
	// login a employee
	public Employee loginEmployee(String EmpUserName, String EmpPassword)throws EmployeeException;

	
	// list of employee;
	public List<Employee> getEmployeeDetails()throws EmployeeException;

	public String changePassword(String username, String password, String newpassword) throws EmployeeException;
	
	public List<ProblemPro> getAllDetailsProble(String pname) throws EmployeeException;
	
}