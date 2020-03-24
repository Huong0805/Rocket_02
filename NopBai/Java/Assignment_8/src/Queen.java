
/**
* This class is Queen Bee .
*
* @Description: Queen
* @author: HuongLT
* @create_date: Mar 24, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 24, 2020
*/
public class Queen extends Bee {
	
	/*
	 * 
	* @see Bee#checkHealthStatus()
	 */
	public boolean checkHealthStatus() {
		super.checkHealthStatus();
		if(getHealth()<20) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
}
