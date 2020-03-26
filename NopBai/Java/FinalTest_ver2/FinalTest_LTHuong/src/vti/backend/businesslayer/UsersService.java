/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;

import vti.backend.datalayer.IUsersDAO;
import vti.backend.datalayer.UsersDAO;
import vti.entity.Users;

/**
 * This class is UsersService.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 26, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 26, 2020
 */
public class UsersService implements IUsersService {

	private IUsersDAO dao;

	public UsersService() {
		dao = new UsersDAO();
	}

	/*
	 * @see vti.backend.businesslayer.IUsersService#getAllUsers()
	 */
	@Override
	public List<Users> getAllUsers() {

		return dao.getAllUsers();
	}

	/*
	 * @see vti.backend.businesslayer.IUsersService#insertUsers(vti.entity.Users)
	 */
	@Override
	public boolean insertUsers(Users user) throws Exception {

		return dao.insertUsers(user);

	}

	/*
	 * @see vti.backend.businesslayer.IUsersService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String email, String passWord) {
		return dao.login(email, passWord);
	}

	/*
	 * @see vti.backend.businesslayer.IUsersService#getUserByEmail(java.lang.String)
	 */
	@Override
	public Users getUserByEmail(String email) {
		return dao.getUserByEmail(email);
	}

}
