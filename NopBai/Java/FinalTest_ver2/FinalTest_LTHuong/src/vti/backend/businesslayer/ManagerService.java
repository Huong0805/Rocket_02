/**
 * 
 */
package vti.backend.businesslayer;


import vti.backend.businesslayer.IManagerService;
import vti.backend.datalayer.IManagerDAO;
import vti.backend.datalayer.ManagerDAO;
import vti.entity.Manager;
/**
* This class is manager service.
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
	* @see vti.backend.businesslayer.IManagerService#insertManager(vti.entity.Manager)
	*/
	@Override
	public boolean insertManager(Manager manager) {
			return dao.insertManager(manager);
	}


}
