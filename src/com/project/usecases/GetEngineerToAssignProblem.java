package com.project.usecases;

import java.util.List;
import java.util.Scanner;

import com.project.DAO.EngineerDao;
import com.project.DAO.EngineerDaoImpl;
import com.project.bean.EngineerDTO;

public class GetEngineerToAssignProblem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the problem name");
		String pname = sc.nextLine();

		EngineerDao dao = new EngineerDaoImpl();

		try {

			List<EngineerDTO> dtos = dao.getAlEnginnerAssignProblem(pname);

			dtos.forEach(e -> {
				System.out.println("Engineer id is : " + e.getEngid());
				System.out.println("Engineer name is : " + e.getEngName());
				System.out.println("Engineer category is : " + e.getCategory());
				System.out.println("Problem name is : " + e.getPname());
				
				System.out.println("============================================");
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();

	}

}
