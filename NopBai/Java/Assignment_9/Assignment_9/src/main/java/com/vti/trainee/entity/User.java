/**
 * 
 */
package com.vti.trainee.entity;

/**
 * This class is user entity .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 24, 2020
 */
public class User {

	private int id;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;

	public User(int id, String userName, String passWord, String firstName, String lastName, String email) {

		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	* Constructor for class User.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	*/
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
