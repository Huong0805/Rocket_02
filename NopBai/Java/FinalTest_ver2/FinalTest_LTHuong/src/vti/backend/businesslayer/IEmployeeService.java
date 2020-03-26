/**
 * 
 */
package vti.backend.businesslayer;

import vti.entity.Employee;;

/**
 * This class is interface of EmployeeService .
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
	 * This method is create employee .
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

}
