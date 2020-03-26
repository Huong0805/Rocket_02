/**
 * 
 */
package vti.backend.datalayer;

import vti.entity.Manager;

/**
 * This class is interface of ManagerDAO .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public interface IManagerDAO {
	/**
	 * 
	 * This method is create manager .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param manager
	 * @return
	 */

	boolean insertManager(Manager manager);

}
