/**
 * 
 */
package com.vti.trainee.backend.presentationlayer;

import java.util.List;

import com.vti.trainee.backend.businesslayer.IUserService;
import com.vti.trainee.backend.businesslayer.UserService;
import com.vti.trainee.entity.User;

/**
* This class is presentation layer .
*
* @Description:.
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class UserController {
	private IUserService service;
	/**
	 * 
	* Constructor for class UserController.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	 */
	public UserController() {
		service = new UserService();
	}
	/**
	 * 
	* This method is get all user.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @return
	 */
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	
	/**
	 * 
	* This method is used to insert user .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @param user
	* @return
	 */
	public boolean insertUser(User user) {
		return service.insertUser(user);
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
	* @param user
	* @return
	 */
	public boolean updateUser(User user) {
		return service.updateUser(user);
	}
	
	/**
	 * 
	* This method is delete user .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @param user
	* @return
	 */
	
	public boolean deleteUser(int id) {
		return service.deleteUser(id);
	}
	
	/**
	 * 
	* This method is login.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @param user
	* @return
	 */
	
	public boolean login(String userName, String passWord) {
		return service.login(userName, passWord);
	}
	
}
