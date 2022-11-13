package com.project.usecases;

import java.util.Scanner;

import com.project.DAO.EmployeeDao;
import com.project.DAO.EmployeeDaoImpl;
import com.project.bean.Employee;
import com.project.exceptions.EmployeeException;

public class EmployeeLoginUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username:");
		String EmpUserName = sc.next();

		System.out.println("Enter Password:");
		String EmpPassword = sc.next();

		EmployeeDao dao = new EmployeeDaoImpl();

		try {
			Employee employee = dao.loginEmployee(EmpUserName, EmpPassword);

			System.out.println("Welcome Employee :" + employee.getEmpName());

		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
