package com.project.usecases;

import java.util.List;
import java.util.Scanner;

import com.project.DAO.EmployeeDao;
import com.project.DAO.EmployeeDaoImpl;
import com.project.DAO.EngineerDao;
import com.project.DAO.EngineerDaoImpl;
import com.project.DAO.HodDao;
import com.project.DAO.HodDaoImple;
import com.project.DAO.ProblemDao;
import com.project.DAO.ProblemDaoImpl;
import com.project.bean.Employee;
import com.project.bean.Engineer;
import com.project.bean.EngineerDTO;
import com.project.bean.Problem;
import com.project.exceptions.EmployeeException;
import com.project.exceptions.EngineerException;
import com.project.exceptions.HodException;
import com.project.exceptions.ProblemException;

public class MainUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Welcome to  Software and Hardware Online System Designed by Harshit Awasthi ");
			System.out.println("Enter Your Choice");
			System.out.println("1.HOD services... ");
			System.out.println("2.Engineer services...");
			System.out.println("3.Employee services....");
			System.out.println("4: Exit");
			int choice = sc.nextInt();

			if (choice == 4) {
				System.out.println("Thank You for using our service.....");
				break;
			}

			switch (choice) {

			// implementation of HOD functionalities......

			case 1: {

				while (true) {
					System.out.println("Welcome to HOD Admistration");
					System.err.println("please login for using services...");

					System.out.println("Enter admin Username:");
					String username = sc.next();

					System.out.println("Enter admin Password:");
					String password = sc.next();

					HodDao dao = new HodDaoImple();

					try {
						String hod = dao.loginHod(username, password);

						EngineerDao deo = new EngineerDaoImpl();

						if (hod.equalsIgnoreCase("done")) {

							System.out.println("Login succesfully done...");
							System.out.println("please Enter your choice");
							System.out.println("1.Appoint a new Enginner... ");
							System.out.println("2.See All enginners working in department.... ");
							System.out.println("3.Terminate enginner from work.... ");
							System.out.println("4.See all problems raised by employee.... ");
							System.out.println("5.Assign problem to Engineer.... ");
							int number = sc.nextInt();

							switch (number) {

							case 1: {
								while (true) {

									System.out.println("Enter Engineer Name:");
									String EngName = sc.next();

									System.out.println("Enter Engineer User Name (should be unique):");
									String EngUserName = sc.next();

									System.out.println("Enter Engineer password:");
									String EngPassword = sc.next();

									System.out.println("Enter Engineer Category :");
									String EngCategory = sc.next();

									EngineerDao dao2 = new EngineerDaoImpl();

									Engineer engineer = new Engineer();

									engineer.setEngName(EngName);
									engineer.setEngUserName(EngUserName);
									engineer.setEngPassword(EngPassword);
									engineer.setEngCategory(EngCategory);

									String result = dao2.registerEngineer(engineer);
									System.out.println(result);

									System.out.println("Appoint another Engineer please press 'yes' or 'no'");
									String choice2 = sc.next();

									if (choice2.equalsIgnoreCase("no")) {
										break;
									}

								}
							}
								break;
							case 2: {

								while (true) {
									System.out.println("All engineers List as follow: ");
									try {
										List<Engineer> engineers = deo.getEngineersDetail();

										engineers.forEach(e -> {
											System.out.println("Engineer id is:" + e.getEngId());
											System.out.println("Engineer name is :" + e.getEngName());
											System.out.println("Engineer username is :" + e.getEngUserName());
											System.out.println("Engineer password is:" + e.getEngPassword());
											System.out.println("Engineer category is:" + e.getEngCategory());

											System.out.println("============================================");
										});
									} catch (EngineerException e) {
										e.printStackTrace();
									}

									System.out.println("Enter 'y' to again see the list or enter 'n' to back");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}

							}
								break;
							case 3: {

								while (true) {
									System.out.println("Enter name of engineer to terminate from work... ");
									String name = sc.next();

									EngineerDao deo2 = new EngineerDaoImpl();

									try {

										String result = deo2.deleteEngineer(name);
										System.out.println(result);

									} catch (EngineerException e) {

										e.printStackTrace();
									}

									System.out.println("Enter 'y' to terminate another engineer or enter 'n' to back ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}
							}
								break;

							case 4: {

								while (true) {
									System.out.println("List of Problems Assigned to engineer");
									ProblemDao dao4 = new ProblemDaoImpl();

									try {

										List<Problem> problems = dao4.getAllProblemList();
										problems.forEach(e -> {
											System.out.println("Problem id is : " + e.getPid());
											System.out.println("Problem name is : " + e.getPname());
											System.out.println("Problem category is : " + e.getPcategory());
											System.out.println("Problem status is : " + e.getPstatus());
											
											System.out.println("==========================================");
										});

									} catch (ProblemException e) {
										// TODO: handle exception
										System.out.println(e.getMessage());
									}

									System.out.println("Enter 'y' to again see the list or 'n' to back ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}

							}

								break;
							case 5: {

								while (true) {
									System.out.println("Enter the problem id");
									int pid = sc.nextInt();

									System.out.println("Enter the engineer id");
									int engid = sc.nextInt();

									EngineerDao dao5 = new EngineerDaoImpl();

									try {
										String result = dao5.assigningProblemToEngineer(pid, engid);

										System.out.println(result);
									} catch (Exception e) {

										System.out.println(e.getMessage());

									}

									System.out.println(
											"Enter 'y' for assign another problem to engineer or 'n' to back ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}

							}
								break;
							// Default case statement
							default:
								System.out.println("choice");
							}
						}

					} catch (HodException e) {
						System.out.println(e.getMessage());
					}

					System.out.println("Enter 'y' continue services of HOD or 'n' to back ");
					String opt = sc.next();
					if (opt.equalsIgnoreCase("n")) {
						break;
					}
				}
			}
				break;

			// implementation of Engineer Functionalities......

			case 2: {
				while (true) {
					System.out.println("Welcome To Engineer administration....");
					System.out.println("Please login to use services...");
					System.out.println("Enter Username:");
					String EngUserName = sc.next();

					System.out.println("Enter Password:");
					String EngPassword = sc.next();

					EngineerDao dao = new EngineerDaoImpl();

					try {
						Engineer engineer = dao.loginEngineer(EngUserName, EngPassword);

						System.out.println(
								"Welcome to Engineer page :" + engineer.getEngName() + " You can use below services");

						System.out.println("please enter a choice");
						System.out.println("1.See the assign problem to " + engineer.getEngName());
						System.out.println("2.Update problem status is pending or resolved.");
						System.out.println("3.See the Problem List");
						System.out.println("4.You Can change password Here");

						int engchoice = sc.nextInt();

						switch (engchoice) {
						// Case statements
						case 1: {
							while (true) {
								System.out.println("Enter the problem name");
								String pname = sc.nextLine();

								EngineerDao dao6 = new EngineerDaoImpl();

								try {

									List<EngineerDTO> dtos = dao6.getAlEnginnerAssignProblem(pname);

									dtos.forEach(e -> {

										System.out.println("Problem id is : " + e.getEngid());
										System.out.println("Problem name is : " + e.getPname());
										System.out.println("Problem category is : " + e.getCategory());
//											System.out.println("Problem status is : "+e.getPstatus());

										System.out.println("=================================");

									});

								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								System.out.println(
										"Enter 'y' again see the list of assign problem or 'n' to other services ");
								String opt = sc.next();
								if (opt.equalsIgnoreCase("n")) {
									break;
								}
							}

						}
							break;
						case 2: {

							while (true) {
								System.out.println("Please enter your engid to update status");
								int prid = sc.nextInt();
								System.out.println("Please enter problem status (resolved/pending) ");
								String statusname = sc.next();

								ProblemDao deo = new ProblemDaoImpl();

								try {
									String updateresult = deo.updateStatus(statusname, prid);

									System.out.println(updateresult);

								} catch (ProblemException e) {

									e.printStackTrace();
								}

								System.out.println(
										"Enter 'y' for update anothor status problem or 'n' to other services ");
								String opt = sc.next();
								if (opt.equalsIgnoreCase("n")) {
									break;
								}
							}

						}
							break;
						case 3: {

							while (true) {

								ProblemDao dao7 = new ProblemDaoImpl();
								try {

									List<Problem> problems = dao7.getAllProblemList();
//										problems.forEach(s -> System.out.println(s));

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
								System.out.println("Enter 'y' for again print the list or 'n' to other services ");
								String opt = sc.next();
								if (opt.equalsIgnoreCase("n")) {
									break;
								}
							}
						}
							break;
						case 4: {
							while (true) {
								System.out.println("Please enter correct crediential for changing password");
								System.out.println("Enter a username");
								String username = sc.next();

								System.out.println("Enter a password");
								String password = sc.next();

								System.out.println("Enter a new new password");
								String newpassword = sc.next();

								EngineerDao deo8 = new EngineerDaoImpl();

								try {
									String changepass = deo8.changePassword(username, password, newpassword);
									System.out.println(changepass);

								} catch (EngineerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println(
										"Enter 'y' for change password of another engineer or 'n' to other services ");
								String opt = sc.next();
								if (opt.equalsIgnoreCase("n")) {
									break;
								}
							}
						}
							break;
						// Default case statement
						default:
							System.out.println("Invalid Service of Engineer");
						}

					} catch (EngineerException e) {
						System.out.println(e.getMessage());
					}

					System.out.println("Enter 'y' continue services of engineer or 'n' to back home ");
					String opt = sc.next();
					if (opt.equalsIgnoreCase("n")) {
						break;
					}
				}
			}
				break;

			// Employee Servicess start from here.....

			case 3: {

				while (true) {
					System.out.println("Welcome to Employee Services");
					System.out.println("Exixting Employee for login press 1:");
					System.out.println("For new employee Registration press 2:");

					int empchoice = sc.nextInt();

					switch (empchoice) {
					// Case statements
					case 1: {

						System.out.println("Enter Username:");
						String EmpUserName = sc.next();

						System.out.println("Enter Password:");
						String EmpPassword = sc.next();

						EmployeeDao dao9 = new EmployeeDaoImpl();

						try {
							Employee employee = dao9.loginEmployee(EmpUserName, EmpPassword);

							System.out
									.println("Welcome Employee :" + employee.getEmpName() + "your services as follows");
							System.out.println("1.See the status of Your Problem");
							System.out.println("2.List of Your All Complents");
							System.out.println("3.You Can Change your password ");

							int empchoice2 = sc.nextInt();

							switch (empchoice2) {
							// Case statements
							case 1: {
								while (true) {

									System.out.println("Enter Username:");
									String username = sc.next();

									System.out.println("Enter Password:");
									String password = sc.next();

									HodDao dao = new HodDaoImple();

									try {
										String hod = dao.loginHod(username, password);

										System.out.println("Login succesfull.... :");

									} catch (HodException e) {
										System.out.println(e.getMessage());
									}

									System.out.println("Enter 'y' continue see the status or 'n' to other services ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}
							}
								break;
							case 2: {
								while (true) {
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
									System.out.println(
											"Enter 'y' continue see the list of employee or 'n' to other services ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}

							}
								break;
							case 3: {
								while (true) {
									System.out.println("Enter a username");
									String username = sc.next();

									System.out.println("Enter a password");
									String password = sc.next();

									System.out.println("Enter a new password");
									String newpassword = sc.next();

									EmployeeDao dao11 = new EmployeeDaoImpl();

									try {
										String changepass = dao11.changePassword(username, password, newpassword);
										System.out.println(changepass);

									} catch (EmployeeException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.out.println(
											"Enter 'y' continue change a password of anothor employee or 'n' to other services ");
									String opt = sc.next();
									if (opt.equalsIgnoreCase("n")) {
										break;
									}
								}

							}
								break;
							// Default case statement
							default:
								System.out.println("Service Not Found");
							}

						} catch (EmployeeException e) {
							System.out.println(e.getMessage());
						}

					}
						break;
					case 2: {
						while (true) {
							System.out.println("Enter Employee Name:");
							String EmpName = sc.next();

							System.out.println("Enter Employee User Name (should be unique):");
							String EmpUserName = sc.next();

							System.out.println("Enter Employee password:");
							String EmpPassword = sc.next();

							EmployeeDaoImpl dao = new EmployeeDaoImpl();

							Employee employee = new Employee();

							employee.setEmpName(EmpName);
							employee.setEmpUserName(EmpUserName);
							employee.setEmpPassword(EmpPassword);

							String result = dao.registerEmployee(employee);
							System.out.println(result);

							System.out.println("Enter 'y' continue register a new employess or 'n' to other services ");
							String opt = sc.next();
							if (opt.equalsIgnoreCase("n")) {
								break;
							}
						}
					}
						break;

					default:
						System.out.println("Invalid Choice.....");
					}
					System.out.println("Enter 'y' continue the employee services or 'n' to other services ");
					String opt = sc.next();
					if (opt.equalsIgnoreCase("n")) {
						break;
					}
				}
			}
				break;
			default:
				System.out.println("choice");

			}

		}

	}

}
