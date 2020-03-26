/**
 * 
 */
package vti.frontend;

import java.util.List;
import java.util.Scanner;

import vti.backend.presentationlayer.EmployeeController;
import vti.backend.presentationlayer.ManagerController;
import vti.backend.presentationlayer.UsersController;
import vti.entity.Employee;
import vti.entity.Manager;
import vti.entity.Users;
import vti.utils.*;

/**
 * This class is function used in main program.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class Function {

	static List<Users> list;
	Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * This method is get all users.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 */

	public void getAllUseers() {
		list = new UsersController().getAllUsers();
		for (Users us : list) {
			System.out.println("First Name:\t" + us.getFirstName());
			System.out.println("Last Name:\t" + us.getLastName());
			System.out.println("Email:\t\t" + us.getEmail());
			System.out.println("Password:\t" + us.getPassword());
			System.out.println("--------------------------------");
		}
	}

	/**
	 * 
	 * This method is used to login.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 */
	public void Login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String email = Validate.readEmail(scanner, "error");
		System.out.println("Password:");
		String password = Validate.readPassword(scanner, "error");
		boolean bl = new UsersController().login(email, password);
		if (bl) {
			System.out.println("Login successfully!");
		} else {
			System.out.println("Login failed!");
		}
	}

	/**
	 * 
	 * This method is create manager.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 */
	public void insertManager() {

		Users user = new Users();
		Manager manager = new Manager();

		user.input();
		manager.input(user);

		boolean bl = false;
		try {
			bl = new UsersController().insertUsers(user);
		} catch (Exception e) {
			System.out.println("Create User failed! Email existed");
		}

		if (bl == true) {
			manager.setUser(new UsersController().getUserByEmail(user.getEmail()));
			boolean bl1 = new ManagerController().insertManager(manager);
			if (bl1 == true) {
				System.out.println("Create Successfully!");
			} else {
				System.out.println("Create Manager failed!");
			}
		}
	}

	/**
	 * 
	 * This method is create employee.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 */
	public void insertEmployee() {

		Users user = new Users();
		Employee emp = new Employee();

		user.input();
		emp.input(user);

		boolean bl = false;
		try {
			bl = new UsersController().insertUsers(user);
		} catch (Exception e) {
			System.out.println("Create User failed! Email existed");
		}
		if (bl == true) {
			emp.setUser(new UsersController().getUserByEmail(user.getEmail()));
			boolean bl1 = new EmployeeController().insertEmployee(emp);
			if (bl1 == true) {
				System.out.println("Create Successfully!");
			} else {
				System.out.println("Create Employee failed!");
			}
		}
	}
}