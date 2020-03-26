/**
 * 
 */
package vti.backend.datalayer;

import vti.entity.Employee;

/**
 * This class is interface of EmployeeDAO.
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public interface IEmployeeDAO {

	/**
	 * 
	 * This method is create emplyee .
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 * @param emp
	 * @return
	 */
	boolean insertEmployee(Employee emp);

}
