/**
 * 
 */
package vti.backend.datalayer;

import java.util.List;

import vti.entity.Employee;


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
public interface IEmployeeDAO {
	boolean login(String email, String passWord);

	List<Employee> getAllEmployee();

	boolean insertEmployee(Employee emp);

	boolean getEmployeeByEmail(String email);

}
