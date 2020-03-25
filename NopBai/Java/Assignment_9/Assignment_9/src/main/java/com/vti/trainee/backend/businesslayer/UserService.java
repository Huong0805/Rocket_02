/**
 * 
 */
package com.vti.trainee.backend.businesslayer;

import java.util.List;

import com.vti.trainee.backend.datalayer.IUserDAO;
import com.vti.trainee.backend.datalayer.UserDAO;
import com.vti.trainee.entity.User;

/**
* This class is .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class UserService implements IUserService {
	
	private IUserDAO dao;

	public UserService() {
		dao = new UserDAO();
	}

	/*
	* @see com.vti.trainee.backend.businesslayer.IUserService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String userName, String passWord) {
		return dao.login(userName, passWord);
	}

	/*
	* @see com.vti.trainee.backend.businesslayer.IUserService#getAllUser()
	*/
	@Override
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	/*
	* @see com.vti.trainee.backend.businesslayer.IUserService#insertUser(com.vti.trainee.entity.User)
	*/
	@Override
	public boolean insertUser(User user) {
		boolean bl = dao.getUserByUserName(user.getUserName());
		if(!bl) {
			return dao.insertUser(user);
		}else {
			System.out.println("UserName existed!");
			return false;
		}
	}

	/*
	* @see com.vti.trainee.backend.businesslayer.IUserService#updateUser(com.vti.trainee.entity.User)
	*/
	@Override
	public boolean updateUser(User user) {
		boolean bl = dao.getUserByUserName(user.getUserName());
		if (bl) {
			return dao.updateUser(user);
		}else {
			System.out.println("UserName is not existed!");
			return false;
		}
	}

	/*
	* @see com.vti.trainee.backend.businesslayer.IUserService#deleteUser(int)
	*/
	@Override
	public boolean deleteUser(int id) {
		
		boolean bl = dao.getUserById(id);
		if (bl) {
			return dao.deleteUser(id);
		}else {
			System.out.println("ID is not existed!");
			return false;
		}
	}

	
	
}
