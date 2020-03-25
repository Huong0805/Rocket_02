/**
 * 
 */
package com.vti.trainee.backend.businesslayer;

import java.util.List;

import com.vti.trainee.entity.User;

/**
* This class is interfer user service .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public interface IUserService {
	
	boolean login(String userName, String passWord);

	List<User> getAllUser();

	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);

	
}
