package com.project.DAO;

import com.project.exceptions.HodException;

public interface HodDao {
	
	public String loginHod(String username, String password)throws HodException;


}
