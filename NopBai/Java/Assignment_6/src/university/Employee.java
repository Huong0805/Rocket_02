package university;

import java.util.Scanner;

//Nhan vien

public abstract class Employee {
	
	
	protected String fullName;			//Ten
	protected int academicDegree;	//Bang cap
	protected int allowance;			//Phu cap
	protected float salaryMultiplier;	//He so luong
	
	
	 Scanner scanner = new Scanner(System.in);
	

	public  void input() {
        
        System.out.print("Nhap ho ten: ");
        fullName = scanner.nextLine();
      
        do {
        	System.out.print("Bang cap: 1- bachelor, 2-master, 3-Doctor");
        	academicDegree = scanner.nextInt();
        }while(academicDegree>3 || academicDegree<1);
        
        System.out.print("Nhap he so luong: ");
        salaryMultiplier = scanner.nextFloat();   
    }
	
	public void output() {
		 System.out.print(fullName+":  ");
	}

	
	public abstract float salary();
	
}
