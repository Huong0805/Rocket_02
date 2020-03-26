/**
 * 
 */
package vti.entity;

import java.util.Scanner;

import vti.utils.ScannerUtil;

/**
 * This class is manager user .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class Manager {

	private Users user;
	private int idManager;
	private int expInYear;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;

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
	 * @param user
	 */
	public void input(Users user) {
		Scanner scanner = new Scanner(System.in);
		this.user = user;
		do {
			System.out.println("ExpInt:  ");
			expInYear = ScannerUtil.readInt(scanner, "Please input data as INTEGER! \nPlease input again: ");
		} while (expInYear > 20 || expInYear < 0);

	}
}
