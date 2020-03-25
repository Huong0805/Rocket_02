/**
 * 
 */
package vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import vti.resources.DatabaseConnection;

import vti.entity.Manager;

/**
* This class is manager dao.
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class ManagerDAO implements IManagerDAO {

	/*
	* @see vti.backend.datalayer.IManagerDAO#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String passWord) {
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;

		myConn = DatabaseConnection.openConnection();

		int count = 0;
		try {
			String sql = "SELECT 1 FROM Manager WHERE Email=? and PassWord=?";
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
	* @see vti.backend.datalayer.IManagerDAO#getAllManager()
	*/
	@Override
	public List<Manager> getAllManager() {
		List<Manager> list = new ArrayList<>();
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement("select * from Manager");
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				Manager manager = new Manager();
				manager.setEmail(myRs.getString("Email"));
				manager.setFirstName(myRs.getString("FirstName"));
				manager.setLastName(myRs.getString("LastName"));
				manager.setPhone(myRs.getString("Phone"));
				manager.setExpInYear(myRs.getInt("Year"));
				list.add(manager);
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
	* @see vti.backend.datalayer.IManagerDAO#insertUser(vti.entity.Manager)
	*/
	@Override
	public boolean insertManager(Manager manager) {
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "insert into Manager (FirstName,LastName, Phone, Email, Year, Password) values (?,?,?,?,?,?)";

			myPs = myConn.prepareStatement(sql);
			myPs.setString(1, manager.getFirstName());
			myPs.setString(2, manager.getLastName());
			myPs.setString(3, manager.getPhone());
			myPs.setString(4, manager.getEmail());
			myPs.setInt(5, manager.getExpInYear());
			myPs.setString(6, manager.getPass());
			
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
	* @see vti.backend.datalayer.IManagerDAO#getUserByEmail(java.lang.String)
	*/
	@Override
	public boolean getUserByEmail(String email) {
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		int count = 0;
		try {
			myPs = myConn.prepareStatement("select 1 from Manager where Email=?");
			myPs.setString(1, email);		
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
