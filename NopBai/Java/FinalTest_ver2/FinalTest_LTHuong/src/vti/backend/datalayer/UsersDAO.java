/**
 * 
 */
package vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vti.entity.Users;
import vti.resources.DatabaseConnection;

/**
 * This class is UserDAO .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 26, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 26, 2020
 */
public class UsersDAO implements IUsersDAO {

	/*
	 * @see vti.backend.datalayer.IUsersDAO#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String email, String passWord) {
		Connection myConn = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;

		myConn = DatabaseConnection.openConnection();

		int count = 0;
		try {
			String sql = "SELECT 1 FROM Users WHERE Email=? and PassWord=?";
			myPs = myConn.prepareStatement(sql);

			myPs.setString(1, email);
			myPs.setString(2, passWord);
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				count++;
			}
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
	}

	/*
	 * @see vti.backend.datalayer.IUsersDAO#getAllManager()
	 */
	@Override
	public List<Users> getAllUsers() {
		List<Users> list = new ArrayList<>();
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement("SELECT * FROM Users");
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				Users user = new Users();
				user.setEmail(myRs.getString("Email"));
				user.setFirstName(myRs.getString("FirstName"));
				user.setLastName(myRs.getString("LastName"));
				user.setPhone(myRs.getString("Phone"));
				user.setPass(myRs.getString("Password"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return null;
	}

	/*
	 * @see vti.backend.datalayer.IUsersDAO#insertManager(vti.entity.Users)
	 */
	@Override
	public boolean insertUsers(Users user) throws Exception {
		Connection myConn = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "INSERT INTO Users (FirstName, LastName, Phone, Email,  Password) VALUES (?,?,?,?,?)";

			myPs = myConn.prepareStatement(sql);
			myPs.setString(1, user.getFirstName());
			myPs.setString(2, user.getLastName());
			myPs.setString(3, user.getPhone());
			myPs.setString(4, user.getEmail());
			myPs.setString(5, user.getPassword());
			myPs.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new Exception("Email existed");
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
	}

	/*
	 * @see vti.backend.datalayer.IUsersDAO#getUserByEmail(java.lang.String)
	 */
	@Override
	public Users getUserByEmail(String email) {
		Connection myConn = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();
		Users user = new Users();
		boolean bl = false;
		try {
			myPs = myConn.prepareStatement("SELECT * FROM Users WHERE Email=?");
			myPs.setString(1, email);

			myRs = myPs.executeQuery();
			while (myRs.next()) {
				bl = true;
				user.setIdUser(myRs.getInt("Id"));
				user.setFirstName(myRs.getString("FirstName"));
				user.setLastName(myRs.getString("LastName"));
				user.setPhone(myRs.getString("Phone"));
				user.setEmail(myRs.getString("Email"));
				user.setPass("");
			}
			if (bl) {
				return user;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}

		return null;
	}

}
