/**
 * 
 */
package vti.backend.presentationlayer;

import java.util.List;

import vti.backend.businesslayer.EmployeeService;
import vti.backend.businesslayer.IEmployeeService;
import vti.entity.Employee;


/**
* This class is emp controller .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public class EmployeeController {
	
	private IEmployeeService service;
	
	public EmployeeController() {
		service = new EmployeeService();
	}
	/**
	 * 
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
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
	
	/**
	 * 
	* This method is register employee .
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
	public boolean insertEmployee(Employee emp) {
		return service.insertEmployee(emp);
	}
	
	public boolean login(String email, String passWord) {
		return service.login(email, passWord);
	}
	

}
