/**
 * 
 */
package vti.frontend;

import java.util.List;
import java.util.Scanner;

import vti.backend.presentationlayer.EmployeeController;
import vti.backend.presentationlayer.ManagerController;
import vti.entity.Employee;
import vti.entity.Manager;
import vti.utils.ScannerUtil;

/**
 * This class is function.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class Function {

	static List<Manager> list;
	static List<Employee> list1;
	Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * This method is get all manager.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 25, 2020
	 */

	public void getAllManager() {
		list = new ManagerController().getAllManager();
		for (Manager us : list) {
			System.out.println(us.getFirstName());
			System.out.println(us.getLastName());
			System.out.println(us.getEmail());
			System.out.println("--------------------------------");
		}
	}
	
	/**
	 * 
	* This method is get all employee .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public void getAllEmployee() {
		list1 = new EmployeeController().getAllEmployee();
		for (Employee emp : list1) {
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmail());
			System.out.println("--------------------------------");
		}
	}
	/**
	 * 
	* This method is register manager .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public void insertManager() {

		Manager manager = new Manager();
		System.out.println("Email: ");
		manager.setEmail(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		manager.setPass(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		manager.setFirstName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("LastName: ");
		manager.setLastName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("Phone: ");
		manager.setPhone(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		do {
			System.out.println("Experience year: ");
			manager.setExpInYear(ScannerUtil.readInt(scanner, "Not null! \nTry again"));
		} while (manager.getExpInYear()>20 ||manager.getExpInYear()<0);
		
		
		boolean bl = new ManagerController().insertManager(manager);
		if (bl) {
			System.out.println("Insert Successfully!");
		} else {
			System.out.println("Insert Failed!");
		}
	}
	/**
	 * 
	* This method is register employee.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public void insertEmployee() {

		Employee emp = new Employee();
		System.out.println("Email: ");
		emp.setEmail(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		emp.setPass(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		emp.setFirstName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("LastName: ");
		emp.setLastName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("Phone: ");
		emp.setPhone(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("ProjectName: ");
		emp.setProjectName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("Skill: ");
		emp.setProSkill(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		
		
		boolean bl = new EmployeeController().insertEmployee(emp);
		if (bl) {
			System.out.println("Insert Successfully!");
		} else {
			System.out.println("Insert Failed!");
		}
	}

}
