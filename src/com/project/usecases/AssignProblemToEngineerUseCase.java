package com.project.usecases;

import java.util.Scanner;

import com.project.DAO.EngineerDao;
import com.project.DAO.EngineerDaoImpl;

public class AssignProblemToEngineerUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the problemid");
		int pid = sc.nextInt();

		System.out.println("Enter the engid");
		int engid = sc.nextInt();

		EngineerDao dao = new EngineerDaoImpl();

		try {
			String result = dao.assigningProblemToEngineer(pid, engid);

			System.out.println(result);
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

}
