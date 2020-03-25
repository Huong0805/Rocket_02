/**
 * 
 */
package com.vti.trainee.backend.datalayer;

import java.util.List;

import com.vti.trainee.entity.User;

/**
* This class is interface data layer .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public interface IUserDAO {
	
	boolean login(String userName, String passWord);

	List<User> getAllUser();

	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);
	
	boolean getUserByUserName(String userName);
	
	boolean getUserById(int id);
	

}
