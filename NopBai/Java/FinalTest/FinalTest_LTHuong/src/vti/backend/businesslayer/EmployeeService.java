/**
 * 
 */
package vti.backend.businesslayer;

import java.util.List;


import vti.entity.Employee;
import vti.backend.datalayer.EmployeeDAO;
import vti.backend.datalayer.IEmployeeDAO;
/**
* This class is ep service .
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

	public EmployeeService() {
		dao = new EmployeeDAO();
	}

	/*
	* @see vti.backend.businesslayer.IEmployeeService#getAllEmployee()
	*/
	@Override
	public List<Employee> getAllEmployee() {
		
		return dao.getAllEmployee();
	}
		

	/*
	* @see vti.backend.businesslayer.IEmployeeService#insertEmployee(vti.entity.Employee)
	*/
	@Override
	public boolean insertEmployee(Employee emp) {
		boolean bl = dao.getEmployeeByEmail(emp.getEmail());
		if(!bl) {
			return dao.insertEmployee(emp);
		}else {
			System.out.println("Email existed!");
			return false;
		}
	}

	/*
	* @see vti.backend.businesslayer.IEmployeeService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String passWord) {
		return dao.login(email, passWord);
	}

}
