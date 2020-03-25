/**
 * 
 */
package vti.backend.datalayer;

import java.util.List;


import vti.entity.Manager;

/**
* This class is interface of manager dao
* .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 25, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 25, 2020
*/
public interface IManagerDAO {
	
	boolean login(String email, String passWord);

	List<Manager> getAllManager();

	boolean insertManager(Manager manager);

	boolean getUserByEmail(String email);
}
