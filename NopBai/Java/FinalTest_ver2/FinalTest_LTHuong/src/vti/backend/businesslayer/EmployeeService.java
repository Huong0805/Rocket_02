/**
 * 
 */
package vti.backend.businesslayer;

import vti.entity.Employee;
import vti.backend.datalayer.EmployeeDAO;
import vti.backend.datalayer.IEmployeeDAO;

/**
 * This class is employee service .
 *
 * @Description: .
 * @author: HuongLT
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HuongLT
 * @modifer_date: Mar 25, 2020
 */
public class EmployeeService implements IEmployeeService {

	private IEmployeeDAO dao;

	/**
	 * 
	 * Constructor for class EmployeeService.
	 *
	 * @Description: .
	 * @author: HuongLT
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: HuongLT
	 * @modifer_date: Mar 27, 2020
	 */
	public EmployeeService() {
		dao = new EmployeeDAO();
	}

	/*
	 * @see vti.backend.businesslayer.IEmployeeService#insertEmployee(vti.entity.
	 * Employee)
	 */
	@Override
	public boolean insertEmployee(Employee emp) {
		return dao.insertEmployee(emp);

	}

}
