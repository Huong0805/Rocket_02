/**
 * 
 */
package vti.utils;

import java.util.Scanner;

/**
 * This class is validate input data.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 26, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 26, 2020
 */
public class Validate {

	public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PATTERN_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,12}$";
	public static final String PATTERN_STRING = "[A-z0-9]{1,}";
	public static final String PATTERN_PHONE = "^[0-9]{9,12}$";
	public static final String PATTERN_PROJECTNAME_1 = "TestingSystem";
	public static final String PATTERN_PROJECTNAME_2 = "CRM";
	public static final String PATTERN_PROJECTNAME_3 = "TimeSheet";

	/**
	 * 
	 * This method is validate email .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static String readEmail(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (result != null & !result.isEmpty()) {
					if (result.matches(PATTERN_EMAIL)) {
						return result;
					} else {
						System.out.println("Email not true pattern, try again");
					}
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}

	/**
	 * 
	 * This method is validate projectName.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static String readProjectName(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (result != null & !result.isEmpty()) {
					if (result.matches(PATTERN_PROJECTNAME_1) || result.matches(PATTERN_PROJECTNAME_2)
							|| result.matches(PATTERN_PROJECTNAME_3)) {
						return result;
					} else {
						System.out.println("Project name must be TestingSystem or CRM or TimeSheet");
					}
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}

	/**
	 * 
	 * This method is validate phone.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static String readPhone(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (result != null & !result.isEmpty()) {
					if (result.matches(PATTERN_PHONE)) {
						return result;
					} else {
						System.out.println("Phone not true of pattern ,try again");
					}

				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}

	/**
	 * 
	 * This method is validate password.
	 *
	 * @Description: 6-12 letter, at least one lowercase letter and one uppercase
	 *               letter.
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static String readPassword(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (result != null & !result.isEmpty()) {
					if (result.matches(PATTERN_PASSWORD)) {
						return result;
					} else {
						System.out.println("Password not true of pattern, try again");
					}
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}

}
