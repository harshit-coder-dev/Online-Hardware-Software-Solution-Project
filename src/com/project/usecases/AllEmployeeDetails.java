package com.project.usecases;

import java.util.List;

import com.project.bean.Employee;
import com.project.DAO.EmployeeDao;
import com.project.DAO.EmployeeDaoImpl;
import com.project.exceptions.EmployeeException;

public class AllEmployeeDetails {

	public static void main(String[] args) {
		
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		
		try {
			
			List<Employee> employees=dao.getEmployeeDetails();
			employees.forEach(e -> {
				System.out.println("Employee id is : " + e.getEmpID());
				System.out.println("Employee name is : " + e.getEmpName());
				System.out.println("Employee category is : " + e.getEmpUserName());
				System.out.println("Employee status is : " + e.getEmpPassword());
				
				System.out.println("==============================================================");
			}
			
					);
			
		} catch (EmployeeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}