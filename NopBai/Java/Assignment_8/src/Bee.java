/**
 * 
* This class is used to define Bee.
*
* @Description: Bee has health=100
* @author: HuongLT
* @create_date: Mar 24, 2020
* @version: 1.0
* @modifer: HuongLT
* @modifer_date: Mar 24, 2020
 */
public class Bee {
	
	private float health=100;
	
	
	public float getHealth() {
		if(health<=0)
			return 0;
		else
			return health;
	}
	
	
	/**
	 * 
	* This method is attack bee.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 24, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 24, 2020
	* @param damge
	 */
	public void damge(int damge) {
		if(damge>=0 && damge<=100) {
			health-=damge;
		}else if(health<0)  {
			health=0;
		}
		
	}
	/**
	 * 
	* This method is  used to check status of bee .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 24, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 24, 2020
	* @return
	 */
	public boolean checkHealthStatus() {
		return true;
	}
	

}
