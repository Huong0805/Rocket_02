/**
 * 
 */
package vti.backend.presentationlayer;

import java.util.List;
import vti.backend.businesslayer.IManagerService;
import vti.backend.businesslayer.ManagerService;
import vti.entity.Manager;


/**
* This class is manager controller.
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class ManagerController {
	
	private IManagerService service;
	
	public ManagerController() {
		service = new ManagerService();
	}
	/**
	 * 
	* This method is get all manager .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @return
	 */
	public List<Manager> getAllManager() {
		return service.getAllManager();
	}
	
	/**
	 * 
	* This method is register manager .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @param manager
	* @return
	 */
	public boolean insertManager(Manager manager) {
		return service.insertManager(manager);
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
	* @param email
	* @param passWord
	* @return
	 */
	public boolean login(String email, String passWord) {
		return service.login(email, passWord);
	}
	
	
	

}
