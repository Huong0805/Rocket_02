
package com.vti.trainee.frontend;

import java.util.Scanner;

import com.vti.trainee.backend.presentationlayer.UserController;
import com.vti.trainee.utils.ScannerUtil;

/**
 * This class is main program .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 24, 2020
 */
public class Program {
	public static void main(String[] args) {
		
		Function f = new Function();
		int choose;
		Scanner scanner = new Scanner(System.in);
		
			while (true) {
			
			String userName = "";
			String passWord = "";
			System.out.println("UserName: ");
			userName = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			System.out.println("PassWord: ");
			passWord = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			boolean bl = new UserController().login(userName, passWord);
			if (!bl) {
				System.out.println("Please login again!");
			} else {
				System.out.println("Login successfully!");
				boolean login = true;
				while (login) {
					System.out.println("----------Welcome " + userName + "---------");
					System.out.println("1.	Get all User.");
					System.out.println("2.	Insert User.");
					System.out.println("3.	Update User.");
					System.out.println("4.	Delete User.");
					System.out.println("5.	Logout.");
					System.out.println("6.	Exit.");
					System.out.println("Please choose: ");
					choose = ScannerUtil.readInt(scanner, "Please input data as INTEGER! \nPlease input again: ");
					switch (choose) {
					case 1:
						// get all Trainee
						f.getAllUser();
						break;
					case 2:
						// insert Trainee
						f.insertUser();
						break;
					case 3:
						// update Trainee
						f.updateUser();
						break;
					case 4:
						//delete trainee
						f.deleteUser();
						break;
					case 5:
						// logout
						login = false;
						System.out.println("Logout succesfully!");
						break;
					case 6: 
						System.exit(0);
					default:
						System.out.println("Please choose from 1-->4");
						break;
					}
				}
			}
		}
	}
}