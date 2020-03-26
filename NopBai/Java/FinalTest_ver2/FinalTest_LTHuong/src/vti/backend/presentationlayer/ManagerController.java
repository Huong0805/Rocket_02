/**
 * 
 */
package vti.backend.presentationlayer;

import vti.backend.businesslayer.IManagerService;
import vti.backend.businesslayer.ManagerService;
import vti.entity.Manager;

/**
 * This class is ManagerController.
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
	 * This method is create manager .
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

}
