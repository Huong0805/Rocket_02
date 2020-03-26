/**
 * 
 */
package vti.backend.presentationlayer;

import java.util.List;

import vti.backend.businesslayer.IUsersService;
import vti.backend.businesslayer.UsersService;

import vti.entity.Users;

/**
 * This class is UsersController.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 26, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 26, 2020
 */
public class UsersController {
	private IUsersService service;

	public UsersController() {
		service = new UsersService();
	}

	/**
	 * 
	 * This method is get all users .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @return
	 */
	public List<Users> getAllUsers() {
		return service.getAllUsers();
	}

	/**
	 * 
	 * This method is create users.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean insertUsers(Users user) throws Exception {
		return service.insertUsers(user);
	}

	/**
	 * 
	 * This method is login.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param email
	 * @param passWord
	 * @return
	 */
	public boolean login(String email, String passWord) {
		return service.login(email, passWord);

	}

	/**
	 * 
	 * This method is get users by email.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param email
	 * @return
	 */
	public Users getUserByEmail(String email) {
		return service.getUserByEmail(email);
	}

}
