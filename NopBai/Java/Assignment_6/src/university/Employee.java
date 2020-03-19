package university;

import java.util.Scanner;

//Nhan vien

public abstract class Employee {
	
	
	protected String fullName;			//Ten
	protected int academicDegree;	//Bang cap
	protected int allowance;			//Phu cap
	protected float salaryMultiplier;	//He so luong
	
	
	 Scanner scanner = new Scanner(System.in);
	
	/**
	 * Nhap thong tin nhan vien
	 */
	public  void input() {
        
        System.out.print("Nhap ho ten: ");
        fullName = scanner.nextLine();
      
        do {
        	System.out.print("Bang cap: 1- bachelor, 2-master, 3-Doctor");
        	academicDegree = scanner.nextInt();
        }while(academicDegree>3 || academicDegree<1);
        
        System.out.print("Nhap he so luong: ");
        salaryMultiplier = scanner.nextFloat();   
        scanner.nextLine();
    }
	
	/**
	 * In cac thong tin ra man hinh
	 */
	public void output() {
		 System.out.print(fullName+":  "+getDegree(academicDegree)+"\t"+allowance+"\t"+salaryMultiplier+"\t");
	}
	
	/**
	 * Lay thong tin ve bang cap
	 * @param: so nguoi dung nhap vao 1-3
	 * @return: ten bang cap
	 */
	public String getDegree(int x) {
		switch (x) {
		case 1: {
			return "Bachelor" ;
		
		}
		case 2:{
			return "Master" ;
			
		}
		default:
			return "Doctor";
		}
	}
	/**
	 * Ham tinh luong
	 * @return: luong nhan vien
	 */
	public abstract float salary();
	
}
