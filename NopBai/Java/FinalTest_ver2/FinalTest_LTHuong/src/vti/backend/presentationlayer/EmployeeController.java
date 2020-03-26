/**
 * 
 */
package vti.backend.presentationlayer;

import vti.backend.businesslayer.EmployeeService;
import vti.backend.businesslayer.IEmployeeService;
import vti.entity.Employee;

/**
 * This class is EmployeeController .
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
	public boolean insertEmployee(Employee emp) {
		return service.insertEmployee(emp);
	}

}
