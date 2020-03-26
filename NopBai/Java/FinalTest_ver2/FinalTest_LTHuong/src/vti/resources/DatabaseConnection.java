/**
 * 
 */
package vti.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class is connect to database .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class DatabaseConnection {
	/**
	 * 
	 * This method is open connect to database .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 * @return
	 */
	public static Connection openConnection() {
		Connection myConn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/vti/resources/jdbc.properties"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		String url = prop.getProperty("connectionString");
		String user = prop.getProperty("username");
		String password = prop.getProperty("password");
		String driver = prop.getProperty("driverSQLName");
		try {
			myConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return myConn;
	}

	/**
	 * 
	 * This method is close database.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 * @param myConn
	 * @param myPs
	 * @param myRs
	 */
	public static void closeAll(Connection myConn, PreparedStatement myPs, ResultSet myRs) {
		if (myConn != null)
			try {
				myConn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (myRs != null)
			try {
				myRs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (myRs != null)
			try {
				myRs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

}
