/**
 * 
 */
package vti.backend.datalayer;

import java.util.List;

import vti.entity.Users;

/**
* This class is interface of UserDAO .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 26, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 26, 2020
*/
public interface IUsersDAO {
	//Login
	boolean login(String email, String passWord);
	// get al users
	List<Users> getAllUsers();
	//insert users
	boolean insertUsers(Users user) throws Exception ;
	// get users by email
	Users getUserByEmail(String email);
	



}
