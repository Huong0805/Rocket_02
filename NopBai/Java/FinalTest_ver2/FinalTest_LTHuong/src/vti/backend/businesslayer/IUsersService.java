/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;

import vti.entity.Users;;

/**
 * This class is interface of UsersService.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 26, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 26, 2020
 */
public interface IUsersService {
	/**
	 * 
	 * This method is get all user .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 26, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 26, 2020
	 * @return
	 */
	List<Users> getAllUsers();

	/**
	 * 
	 * This method is create user .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 26, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 26, 2020
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean insertUsers(Users user) throws Exception;

	/**
	 * 
	 * This method is login .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 26, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 26, 2020
	 * @param email
	 * @param passWord
	 * @return
	 */
	boolean login(String email, String passWord);

	/**
	 * This method is get an user by email .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 26, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 26, 2020
	 * @param email
	 * @return
	 */
	Users getUserByEmail(String email);

}
