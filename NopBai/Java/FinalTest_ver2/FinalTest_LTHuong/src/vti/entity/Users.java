/**
 * 
 */
package vti.entity;

import java.util.Scanner;

import vti.utils.*;

/**
 * This class is base user .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class Users {

	private int idUser;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String passWord;

	public Users() {
		super();
	}

	public Users(int idUser, String firstName, String lastName, String phone, String email, String pass) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.passWord = pass;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int id) {
		this.idUser = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPass(String pass) {
		this.passWord = pass;
	}

	/**
	 * 
	 * This method is used to input data.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 */
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("FirstName:");
		firstName = ScannerUtil.readString(scanner, "Please input data as String! \nPlease input again: ");
		System.out.println("LastName:");
		lastName = ScannerUtil.readString(scanner, "Please input data as String! \nPlease input again: ");
		System.out.println("Phone:");
		phone = Validate.readPhone(scanner, "Please input data as String! \nPlease input again: ");
		System.out.println("Email:");
		email = Validate.readEmail(scanner, "Please input data as String! \nPlease input again: ");
		System.out.println("Password:");
		passWord = Validate.readPassword(scanner, "Please input data as String! \nPlease input again: ");
	}
}
