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

import vti.entity.Employee;
import vti.entity.Employee;
import vti.resources.DatabaseConnection;

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
public class EmployeeDAO implements IEmployeeDAO{

	
	/*
	* @see vti.backend.datalayer.IEmployeeDAO#login(java.lang.String, java.lang.String)
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
			String sql = "SELECT 1 FROM Employee WHERE Email=? and PassWord=?";
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
	* @see vti.backend.datalayer.IEmployeeDAO#getAllEmployee()
	*/
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		try {
			myPs = myConn.prepareStatement("select * from Employee");
			myRs = myPs.executeQuery();
			while (myRs.next()) {
				Employee emp = new Employee();
				emp.setEmail(myRs.getString("Email"));
				emp.setFirstName(myRs.getString("FirstName"));
				emp.setLastName(myRs.getString("LastName"));
				emp.setPhone(myRs.getString("Phone"));
				emp.setProjectName(myRs.getString("ProjectName"));
				emp.setProSkill(myRs.getString("Skill"));
				list.add(emp);
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
	* @see vti.backend.datalayer.IEmployeeDAO#insertManager(vti.entity.Employee)
	*/
	@Override
	public boolean insertEmployee(Employee emp) {
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		PreparedStatement myPs = null;
		myConn = DatabaseConnection.openConnection();

		try {
			String sql = "insert into Employee (FirstName,LastName, Phone, Email, Password, ProjectName, Skill) values (?,?,?,?,?,?,?)";

			myPs = myConn.prepareStatement(sql);
			myPs.setString(1, emp.getFirstName());
			myPs.setString(2, emp.getLastName());
			myPs.setString(3, emp.getPhone());
			myPs.setString(4, emp.getEmail());
			myPs.setString(5, emp.getPass());
			myPs.setString(6, emp.getProjectName());
			myPs.setString(7, emp.getProSkill());
			
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
	* @see vti.backend.datalayer.IEmployeeDAO#getEmployeeByEmail(java.lang.String)
	*/
	@Override
	public boolean getEmployeeByEmail(String email) {
		Connection myConn;
		PreparedStatement myPs = null;
		ResultSet myRs = null;
		myConn = DatabaseConnection.openConnection();
		int count = 0;
		try {
			myPs = myConn.prepareStatement("select 1 from Employee where Email=?");
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
