
public class Truck extends Car{
	
	
	int weight; 
	
	Truck(int speed, double regularPrice, String color) {
		super(speed, regularPrice, color);
	}
 
	public double getSalePrice() {
		if(weight>2000)
			return regularPrice*0.9;
		else 
			return regularPrice*0.8;
	}; 
	

}
