import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class MainProgram {
	
	static Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	static List<Bee> bee;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("----------MENU---------");
			System.out.println("1.	Create random Bee list.");
			System.out.println("2.	Attack Bee.");
			System.out.println("3.	Exit.");
			System.out.println("Please choose: ");
			int choose = ScannerUtil.readInt(scanner, "Please input data as INTEGER!: ");

			switch (choose) {
			case 1:
				 bee = new ArrayList<Bee>();
				createBeeList(bee);
				showStatus(bee);
				break;
			case 2:
				if (bee == null) {
					System.out.println("PLEASE CREATE LIST BEE FIRST!");
					break;
				} else {
					attackBee(bee);
					showStatus(bee);
					break;
				}
			case 3:
				System.exit(0);
			default:
				System.out.println("PLEASE CHOOSE FROM 1 --> 3!");
				break;
			}

		}
	}
	
	/**
	 * 
	* This method is used to create a list of bees.
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 24, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 24, 2020
	* @param bee
	 */
	
	public static void createBeeList(List<Bee> bee ) {
		bee.clear();
		int n=random.nextInt(10)+3;
		for(int i=0; i<n; i++) {
		int r=random.nextInt(3);
		if(r==0) {
			Drone dr = new Drone();
			bee.add(dr);
		}else if(r==1) {
			Queen q = new Queen();
			bee.add(q);
		}else {
			Worker w = new Worker();
			bee.add(w);
		}
		}
		
	}
	
	/**
	 * 
	* This method is used to attack bee .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 24, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 24, 2020
	* @param bee
	 */
	public static void attackBee(List<Bee> bee ) {
		
		for (Bee bee1 : bee) {
			if(bee1 instanceof Drone)
			{
				Drone dr = (Drone) bee1;
				if(dr.checkHealthStatus()==true)
					bee1.damge(new Random().nextInt(81));
			}
			
			if(bee1 instanceof Queen)
			{
				Queen q = (Queen) bee1;
				if(q.checkHealthStatus()==true)
					bee1.damge(new Random().nextInt(81));
			}
			
			
			if(bee1 instanceof Worker)
			{
				Worker w = (Worker) bee1;
				if(w.checkHealthStatus()==true)
					bee1.damge(new Random().nextInt(81));
			}

		}
		System.out.println("ATTACK SUCCESSFULLY!");
		System.out.println("-----------------------------------------");
		System.out.println();
	}
		


	/**
	* This method is show status of bees .
	*
	* @Description: .
	* @author: HuongLT
	* @create_date: Mar 24, 2020
	* @version: 1.0
	* @modifer: HuongLT
	* @modifer_date: Mar 24, 2020
	*/
	public static void showStatus(List<Bee> bee ) {

			int i = 1;
			for (Bee bee1 : bee) {
				if(bee1 instanceof Drone)
					System.out.println(i +":"+ "  Drone " );
				else if(bee1 instanceof Queen)
					System.out.println(i +":"+ "  Queen " );
				else
					System.out.println(i +":"+ "  Worker " );
				i++;
				System.out.println(bee1.getHealth());
				if(bee1.checkHealthStatus()==false)
					System.out.println("Da chet");
				System.out.println("-----------------------------------------");
			}
		}
		
}