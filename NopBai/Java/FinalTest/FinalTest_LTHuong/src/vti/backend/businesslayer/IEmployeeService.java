/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;

import vti.entity.Employee;;

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
public interface IEmployeeService {

	/**
	* This method is get all employee .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 25, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 25, 2020
	* @return
	*/
	List<Employee> getAllEmployee();

	/**
	* This method is register emp  .
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
	boolean insertEmployee(Employee emp);

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
