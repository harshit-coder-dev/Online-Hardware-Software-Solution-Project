package com.project.DAO;

import java.util.List;

import com.project.bean.Engineer;
import com.project.bean.EngineerDTO;
import com.project.exceptions.EngineerException;
import com.project.exceptions.ProblemException;

public interface EngineerDao {

public String registerEngineer(Engineer engineer);
	
	public Engineer loginEngineer(String EngUserName, String EngPassword)throws EngineerException;
	
	public List<Engineer> getEngineersDetail()throws EngineerException;

	public String assigningProblemToEngineer(int pid, int engId) throws EngineerException, ProblemException;

	
	
	public List<EngineerDTO> getAlEnginnerAssignProblem(String pname)throws ProblemException;

	public String deleteEngineer(String name) throws EngineerException;

	public String changePassword(String username, String password, String newpassword) throws EngineerException;

}
