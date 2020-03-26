/**
 * 
 */
package vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vti.entity.Employee;
import vti.resources.DatabaseConnection;

/**
 * This class is EmoloyeeDAO .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class EmployeeDAO implements IEmployeeDAO {

	/*
	 * @see vti.backend.datalayer.IEmployeeDAO#insertManager(vti.entity.Employee)
	 */
	@Override
	public boolean insertEmployee(Employee emp) {
		Connection myConn = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "INSERT INTO Employee (IdUser, ProjectName, Skill) VALUES (?,?,?)";

			myPs = myConn.prepareStatement(sql);

			myPs.setInt(1, emp.getUser().getIdUser());
			myPs.setString(2, emp.getProjectName());
			myPs.setString(3, emp.getProSkill());

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
