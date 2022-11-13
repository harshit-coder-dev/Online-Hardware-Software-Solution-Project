package com.project.usecases;

import java.util.Scanner;

import com.project.DAO.EngineerDao;
import com.project.DAO.EngineerDaoImpl;
import com.project.bean.Engineer;

public class RegisterEngineerUseCase1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Engineer Name:");
		String EngName = sc.next();

		System.out.println("Enter Engineer User Name:");
		String EngUserName = sc.next();

		System.out.println("Enter Engineer password:");
		String EngPassword = sc.next();

		System.out.println("Enter Engineer Category :");
		String EngCategory = sc.next();

		EngineerDao dao = new EngineerDaoImpl();

		Engineer engineer = new Engineer();

		engineer.setEngName(EngName);
		engineer.setEngUserName(EngUserName);
		engineer.setEngPassword(EngPassword);
		engineer.setEngCategory(EngCategory);

		String result = dao.registerEngineer(engineer);
		System.out.println(result);
		sc.close();

	}

}
