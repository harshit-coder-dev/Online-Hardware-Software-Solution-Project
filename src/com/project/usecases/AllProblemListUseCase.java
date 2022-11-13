package com.project.usecases;

import java.util.List;

import com.project.DAO.ProblemDao;
import com.project.DAO.ProblemDaoImpl;
import com.project.bean.Problem;
import com.project.exceptions.ProblemException;

public class AllProblemListUseCase {

	public static void main(String[] args) {
		ProblemDao dao = new ProblemDaoImpl();

		try {

			List<Problem> problems = dao.getAllProblemList();
			problems.forEach(e -> {

				System.out.println("Problem id is : " + e.getPid());
				System.out.println("Problem name is : " + e.getPname());
				System.out.println("Problem category is : " + e.getPcategory());
				System.out.println("Problem status is : " + e.getPstatus());

				System.out.println("=================================");

			});

		} catch (ProblemException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
