/**
 * 
 */
package vti.entity;

import java.util.Scanner;

import vti.utils.*;

/**
 * This class is employee user .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class Employee {
	private Users user;

	private int idEmployee;
	private String projectName;
	private String proSkill;

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;

	}

	/**
	 * 
	 * This method is used to input data .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param user
	 */
	public void input(Users user) {
		Scanner scanner = new Scanner(System.in);
		this.user = user;
		System.out.println("ProjectName:");
		projectName = Validate.readProjectName(scanner, "Please input data as String! \nPlease input again: ");
		System.out.println("ProSkill:");
		proSkill = ScannerUtil.readString(scanner, "Please input data as String! \nPlease input again: ");
	}
}
