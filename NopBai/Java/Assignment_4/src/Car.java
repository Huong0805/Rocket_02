
public class Car {
	int speed; 
	double regularPrice; 
	String color; 
	double getSalePrice() {
		return regularPrice;
	}; 
	
	Car(int speed, double regularPrice, String color){
		this.speed=speed;
		this.regularPrice=regularPrice;
		this.color=color;
	}
		
}