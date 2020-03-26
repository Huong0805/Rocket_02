/**
 * 
 */
package vti.frontend;

import java.util.Scanner;
import vti.backend.presentationlayer.UsersController;
import vti.frontend.Function;
import vti.utils.ScannerUtil;
import vti.utils.Validate;

/**
 * This class is main program.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class MainProgram {
	public static void main(String[] args) {

		Function f = new Function();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("----------MENU---------");
			System.out.println("1.	Register ");
			System.out.println("2.	Login");
			System.out.println("3.	View");
			System.out.println("4.	Exit.");
			System.out.println("Please choose: ");
			int choose = ScannerUtil.readInt(scanner, "Please input data as INTEGER!: ");

			switch (choose) {
			case 1:
				int choose1;
				do {
					System.out.println("1-Manager    2-Employee");
					choose1 = ScannerUtil.readInt(scanner, "Please input data as INTEGER!: ");
				} while (choose1 > 2 || choose1 < 1);
				if (choose1 == 1)
					f.insertManager();
				else
					f.insertEmployee();
				break;
			case 2:
				String email = "";
				String passWord = "";
				System.out.println("Email: ");
				email = Validate.readEmail(scanner, "Error: ");
				System.out.println("PassWord: ");
				passWord = Validate.readPassword(scanner, "Error: ");
				boolean bl = new UsersController().login(email, passWord);
				if (!bl) {
					System.out.println("Please login again!");
				} else {
					System.out.println("Login successfully!");
				}
				break;
			case 3:
				f.getAllUseers();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("PLEASE CHOOSE FROM 1 --> 4!");
				break;
			}

		}

	}
}
