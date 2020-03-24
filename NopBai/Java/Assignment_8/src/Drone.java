/**
 * 
* This class is Drone Bee .
*
* @Description: .
* @author: HuongLT
* @create_date: Mar 24, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 24, 2020
 */
public class Drone extends Bee {
	
	/*
	 * 
	* @see Bee#checkHealthStatus()
	 */
	public boolean checkHealthStatus() {
		super.checkHealthStatus();
		if(getHealth()<50) {
			return false;
		}else {
			return true;
		}
		
	}
	

}
