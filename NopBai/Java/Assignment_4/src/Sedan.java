
public class Sedan extends Car {
	
	int length;  
	
	Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length=length;
	}

	public double getSalePrice() {
		if(length>20)
			return regularPrice*0.95;
		else 
			return regularPrice*0.9;
	}; 

}
