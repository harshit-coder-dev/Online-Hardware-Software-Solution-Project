package com.project.DAO;

import java.util.List;

import com.project.bean.Problem;
import com.project.exceptions.ProblemException;

public interface ProblemDao {

	public String CreateProblem(Problem problem);

	public List<Problem> getAllProblemList() throws ProblemException;

	public String updateStatus(String sts, int id) throws ProblemException;

}
