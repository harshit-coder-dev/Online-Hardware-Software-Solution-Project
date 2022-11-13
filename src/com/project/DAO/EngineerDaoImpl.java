package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Connector.DButil;
import com.project.bean.Engineer;
import com.project.bean.EngineerDTO;
import com.project.exceptions.EngineerException;
import com.project.exceptions.ProblemException;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String registerEngineer(Engineer engineer) {
		String message = "Not Inserted";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into Engineer(EngName,EngUserName,EngPassword,EngCategory) values(?,?,?,?)");

			ps.setString(1, engineer.getEngName());
			ps.setString(2, engineer.getEngUserName());
			ps.setString(3, engineer.getEngPassword());
			ps.setString(4, engineer.getEngCategory());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Engineer Registration succesfully";

		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Engineer loginEngineer(String EngUserName, String EngPassword) throws EngineerException {
		Engineer engineer = null;

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("select * from Engineer where engUserName=? AND engPassword=?");

			ps.setString(1, EngUserName);
			ps.setString(2, EngPassword);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				int id = rs.getInt("EngId");
				String n = rs.getString("EngName");
				String e = rs.getString("EngUserName");
				String p = rs.getString("EngPassword");
				String c = rs.getString("EngCategory");

				engineer = new Engineer(id, n, e, p, c);

			} else
				throw new EngineerException("Invalid Username or password.. ");

		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}

		return engineer;
	}

	@Override
	public List<Engineer> getEngineersDetail() throws EngineerException {
		List<Engineer> engineers = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from engineer");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.next()) {

					int id = rs.getInt("EngId");
					String n = rs.getString("EngName");
					String e = rs.getString("EngUserName");
					String p = rs.getString("EngPassword");
					String c = rs.getString("EngCategory");

					Engineer engineer = new Engineer(id, n, e, p, c);
					engineers.add(engineer);
				}

			}
		} catch (SQLException e) {
			// TODO: handle exception

			throw new EngineerException(e.getMessage());

		}

		if (engineers.size() == 0) {
			throw new EngineerException("No Engineer Found");
		}

		return engineers;
	}

	@Override
	public String assigningProblemToEngineer(int pid, int engId) throws EngineerException, ProblemException {
		String message = "Not Assign";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from engineer where engid=?");

			ps.setInt(1, engId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("select * from problems where pid=?");
				ps2.setInt(1, pid);
				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {

					PreparedStatement ps3 = conn.prepareStatement("insert into employee_engineer values(?,?) ");

					ps3.setInt(1, pid);
					ps3.setInt(2, engId);

					int x = ps3.executeUpdate();

					if (x > 0)
						message = "Problem Assign to Engineer Successfuly...";

					else
						throw new EngineerException("some things is wrong.....");

				} else {
					throw new ProblemException("Problem is not there");
				}

			} else {
				throw new EngineerException("Employee is not there...");

			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}

		return message;
	}

	@Override
	public List<EngineerDTO> getAlEnginnerAssignProblem(String pname) throws ProblemException {
		List<EngineerDTO> dtos = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select e.engid, e.engname,e.engcategory,p.pname from engineer e INNER JOIN problems p INNER JOIN employee_engineer ee ON e.engid=ee.reid AND p.pid=ee.rpid AND p.pname=?");

			ps.setString(1, pname);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("engid");
				String n = rs.getString("engname");
				String c = rs.getString("engcategory");
				String pn = rs.getString("pname");

				EngineerDTO dto = new EngineerDTO(id, n, c, pn);

				dtos.add(dto);
			}

		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
			// TODO: handle exception
		}

		if (dtos.isEmpty()) {
			throw new ProblemException("No engineer asign to any problem");
		}

		return dtos;
	}

	@Override
	public String deleteEngineer(String name) throws EngineerException {
		String message = "Engineer is not found";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("delete from Engineer where engname = ?");

			ps.setString(1, name);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = (name + " engineer is terminated from system");
			}

		} catch (Exception e) {

		}

		return message;
	}

	@Override
	public String changePassword(String username, String password, String newpassword) throws EngineerException {
		String message = "Not Change";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("update Engineer set Engpassword= ? where EngUserName= ? AND EngPassword= ? ");

			ps.setString(1, newpassword);
			ps.setString(2, username);
			ps.setString(3, password);

			int x = ps.executeUpdate();

			if (x > 0) {

				message = "Your password change successfully !";
			} else {

				throw new EngineerException("Invalid Username or password.. ");

			}

		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}

		return message;
	}

}
