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

			engineer.forEach(s -> System.out.println(s));

		} catch (EngineerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}

}
