/**
 * 
 */
package vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vti.resources.DatabaseConnection;

import vti.entity.Manager;

/**
 * This class is ManagerDAO.
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
	 * @see vti.backend.datalayer.IManagerDAO#insertUser(vti.entity.Manager)
	 */
	@Override
	public boolean insertManager(Manager manager) {
		Connection myConn = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "INSERT INTO Manager (IdUser, ExpInYear) VALUES (?,?)";
			myPs = myConn.prepareStatement(sql);
			myPs.setInt(1, manager.getUser().getIdUser());
			myPs.setInt(2, manager.getExpInYear());

			myPs.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(myConn, myPs, myRs);
		}
		return false;
	}

}
