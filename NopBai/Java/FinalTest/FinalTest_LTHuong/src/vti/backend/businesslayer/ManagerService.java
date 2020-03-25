/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;



import vti.backend.businesslayer.IManagerService;
import vti.backend.datalayer.IManagerDAO;
import vti.backend.datalayer.ManagerDAO;
import vti.entity.Manager;
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
public class ManagerService implements IManagerService {
	
	private IManagerDAO dao;

	public ManagerService() {
		dao = new ManagerDAO();
	}

	/*
	* @see vti.backend.businesslayer.IManagerService#getAllManager()
	*/
	@Override
	public List<Manager> getAllManager() {
		return dao.getAllManager();
	}

	/*
	* @see vti.backend.businesslayer.IManagerService#insertManager(vti.entity.Manager)
	*/
	@Override
	public boolean insertManager(Manager manager) {
		boolean bl = dao.getUserByEmail(manager.getEmail());
		if(!bl) {
			return dao.insertManager(manager);
		}else {
			System.out.println("Email existed!");
			return false;
		}
	}

	/*
	* @see vti.backend.businesslayer.IManagerService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String passWord) {
		return dao.login(email, passWord);
	}

}
