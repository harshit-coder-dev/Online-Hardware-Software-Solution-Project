package com.project.usecases;

import java.util.List;
import java.util.Scanner;

import com.project.DAO.EmployeeDao;
import com.project.DAO.EmployeeDaoImpl;
import com.project.bean.ProblemPro;
import com.project.exceptions.EmployeeException;

public class GetListOfEmployeeAssignProblemUseCase {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter here problem name to see the status... ");
		String pname = sc.nextLine();
		
         EmployeeDao dao10=new EmployeeDaoImpl();	
   
			try {
				 List<ProblemPro>	problems = dao10.getAllDetailsProble(pname);
			    	problems.forEach(e -> {
					
					System.out.println("Problem id is : "+e.getPid());
					System.out.println("Engineer id is:"+e.getEid());
					System.out.println("Engineer name is:"+e.getEngname());
					System.out.println("Problem name is : "+e.getPname());
					System.out.println("Problem category is : "+e.getPcategory());
					System.out.println("Problem status is:"+e.getPstatus());
					
					
					
					System.out.println("=================================");
					
				});
				
				
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

}
