/**
 * 
 */
package com.vti.trainee.backend.datalayer;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.vti.trainee.entity.User;
import com.vti.trainee.DatabaseConnection;

/**
 * This class is .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class UserDAO implements IUserDAO {

	/**
	 * 
	 * This method is login.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean login(String userName, String passWord) {
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;

		myConn = DatabaseConnection.openConnection();

		int count = 0;
		try {
			String sql = "SELECT 1 FROM Trainee WHERE UserName=? and PassWord=?";
			myPs = myConn.prepareStatement(sql);

			myPs.setString(1, userName);
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

	/**
	 * 
	 * This method is insert .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "insert into Trainee (userName,passWord,firstName,lastName,email) values (?,?,?,?,?)";

			myPs = myConn.prepareStatement(sql);
			myPs.setString(1, user.getUserName());
			myPs.setString(2, user.getPassWord());
			myPs.setString(3, user.getFirstName());
			myPs.setString(4, user.getLastName());
			myPs.setString(5, user.getEmail());
			myPs.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
	}

	/*
	 * @see com.vti.trainee.backend.datalayer.IUserDAO#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<>();
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet mRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement("select * from Trainee");
			mRs = myPs.executeQuery();
			while (mRs.next()) {
				User user = new User();
				user.setId(mRs.getInt("id"));
				user.setUserName(mRs.getString("userName"));
				user.setFirstName(mRs.getString("firstName"));
				user.setLastName(mRs.getString("lastName"));
				user.setEmail(mRs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, mRs);
		}
		return null;
	}

	/*
	 * @see
	 * com.vti.trainee.backend.datalayer.IUserDAO#updateUser(com.vti.trainee.entity.
	 * User)
	 */
	@Override
	public boolean updateUser(User user) {
		
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement(
					"update Trainee set firstName=?,lastName=?,email=?,passWord=? where userName=?");
			myPs.setString(1, user.getFirstName());
			myPs.setString(2, user.getLastName());
			myPs.setString(3, user.getEmail());
			myPs.setString(5, user.getUserName());
			myPs.setString(4, user.getPassWord());
			
			myPs.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
	}

	/*
	 * @see com.vti.trainee.backend.datalayer.IUserDAO#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int id) {
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement("delete from Trainee where id=" + id);
			myPs.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;

	}

	/*
	* @see com.vti.trainee.backend.datalayer.IUserDAO#getUserByUserName(java.lang.String)
	*/
	@Override
	public boolean getUserByUserName(String userName) {
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		int count = 0;
		try {
			myPs = myConn.prepareStatement("select 1 from Trainee where userName=?");
			myPs.setString(1, userName);		
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				count++;
			}
			if (count == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
	}

	/*
	* @see com.vti.trainee.backend.datalayer.IUserDAO#getUserById(int)
	*/
	@Override
	public boolean getUserById(int id) {
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		int count = 0;
		try {
			myPs = myConn.prepareStatement("select 1 from Trainee where Id=?");
			myPs.setInt(1, id);		
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				count++;
			}
			if (count == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
		
	}

}
