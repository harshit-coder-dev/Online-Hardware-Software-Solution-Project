package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Connector.DButil;
import com.project.exceptions.HodException;

public class HodDaoImple implements HodDao {

	@Override
	public String loginHod(String username, String password) throws HodException {

		String message = "no ligin";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from hod where username = ? AND password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet x = ps.executeQuery();

			if (x.next()) {

				message = "done";
			} else {

				throw new HodException("Invalid Username or password.. ");

			}

		} catch (SQLException e) {
			throw new HodException(e.getMessage());
		}

		return message;
	}

}
