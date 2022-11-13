package com.project.usecases;

import java.util.Scanner;

import com.project.DAO.EmployeeDaoImpl;
import com.project.bean.Employee;

public class RegisterEmployeeUseCase1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Name:");
		String EmpName = sc.next();

		System.out.println("Enter Employee User Name:");
		String EmpUserName = sc.next();

		System.out.println("Enter Employee password:");
		String EmpPassword = sc.next();

		EmployeeDaoImpl dao = new EmployeeDaoImpl();

		Employee employee = new Employee();

		employee.setEmpName(EmpName);
		employee.setEmpUserName(EmpUserName);
		employee.setEmpPassword(EmpPassword);

		String result = dao.registerEmployee(employee);
		System.out.println(result);

	}

}
