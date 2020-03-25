/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;

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
public interface IManagerService {

	/**
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
	List<Manager> getAllManager();

	/**
	* This method is register manager  .
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
	boolean insertManager(Manager manager);

	/**
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
	boolean login(String email, String passWord);

}
