package com.project.usecases;

import java.util.List;

import com.project.DAO.EngineerDao;
import com.project.DAO.EngineerDaoImpl;
import com.project.bean.Engineer;
import com.project.exceptions.EngineerException;

public class AllEngineerDetails {

	public static void main(String[] args) {
		EngineerDao dao = new EngineerDaoImpl();
		try {

			List<Engineer> engineer = dao.getEngineersDetail();

			engineer.forEach(e -> {
				System.out.println("Engineer id is : " + e.getEngId());
				System.out.println("Engineer name is : " + e.getEngName());
				System.out.println("Engineer Username is : " + e.getEngUserName());
				System.out.println("Engineer Password is : " + e.getEngPassword());
				System.out.println("Engineer Category is : " + e.getEngCategory());
				
				System.out.println("======================================================");
			});

		} catch (EngineerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}

}
