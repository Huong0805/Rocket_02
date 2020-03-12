import java.util.ArrayList;
import java.util.List;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Sedan(100, 1000d, "red", 26));
		
		cars.add(new Ford(200, 1000d, "blue", 2019, 100));
			
		cars.add(new Car(150, 1000d, "pink"));
		
		for (int i = 0; i < cars.size(); i++) {
	
			System.out.println(cars.get(i).getSalePrice());
	}
	}
}
