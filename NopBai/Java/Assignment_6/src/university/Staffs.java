package university;

//Can bo

public class Staffs extends Employee {
	
	protected String department;
	protected int position;
	protected float  workingTime;		
	
	@Override
	public void input() {
		super.input();
        System.out.print("Nhap phong ban: ");
        department = scanner.nextLine();
        scanner.nextLine();
        
        do {
        	 System.out.print("Nhap vi tri: 1- Department head , 2-Vice head, 3-Staff ");
             position = scanner.nextInt();
        }while(position>3 || position<1);
        
        
        System.out.print("Nhap so gio lam viec: ");
        workingTime = scanner.nextFloat();   
    }
	
	@Override
	public void output() {
		super.output();
		System.out.print(salary());
	}
	
	
	@Override
	public float salary() {
		if(academicDegree==1) {
			allowance=300;
		}else if(academicDegree==2) {
			allowance=500;
		}else {
			allowance=1000;
		}
		
		
		if(position==1) {
			allowance+=2000;
		}else if(position==2){
			allowance+=1000;
		}else {
			allowance+=500;
		}
		
		return salaryMultiplier*730+allowance+workingTime*30;
	}
	
	
	
}
