/**
 * 
 */
package com.vti.trainee.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.trainee.backend.presentationlayer.UserController;
import com.vti.trainee.entity.User;
import com.vti.trainee.utils.ScannerUtil;

/**
* This class is used to define some function used in main program .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class Function {

	
	static List<User> list;
	Scanner scanner = new Scanner(System.in);
/**
 * 
* This method is get user.
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
 */
	public void getAllUser() {
		list = new UserController().getAllUser();
		for (User us : list) {
			System.out.println(us.getId());
			System.out.println(us.getUserName());
			System.out.println(us.getFirstName());
			System.out.println(us.getLastName());
			System.out.println(us.getEmail());
			System.out.println("--------------------------------");
		}
	}
	
	
	/**
	 * 
	* This method is insert user.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public void insertUser() {
		
		User user = new User();
		System.out.println("UserName: ");
		user.setUserName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		user.setPassWord(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		user.setFirstName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("LastName: ");
		user.setLastName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("Email: ");
		user.setEmail(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		
		boolean bl = new UserController().insertUser(user);
		if (bl) {
			System.out.println("Insert Successfully!");
		}else {
			System.out.println("Insert Failed!");
		}
	}
	
	/**
	 * 
	* This method is update user .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public void updateUser() {
		User user = new User();
		System.out.println("UserName: ");
		user.setUserName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		user.setFirstName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("LastName: ");
		user.setLastName(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("Email: ");
		user.setEmail(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		user.setPassWord(ScannerUtil.readString(scanner, "Not null! \nTry again"));
		boolean bl = new UserController().updateUser(user);
		if (bl) {
			System.out.println("Update Successfully!");
		}else {
			System.out.println("Update Failed!");
		}
	}
	
		
		public void deleteUser() {
			User user = new User();
			System.out.println("ID: ");
			int id=ScannerUtil.readInt(scanner, "Not null! \nTry again");
			boolean bl = new UserController().deleteUser(id);
			if (bl) {
				System.out.println("Delete Successfully!");
			}else {
				System.out.println("Delete Failed!");
			}
	}
}
