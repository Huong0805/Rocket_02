package university;


//Giao su
public class Professor extends Employee  {
	
	
	protected String faculty;			//Nang luc
	protected float  teachingTime;		

	@Override
	public void input() {

		super.input();
        System.out.print("Nhap nang luc: ");
        faculty = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Nhap so gio day: ");
        teachingTime = scanner.nextFloat();   
    }
	
	
	@Override
	public void output() {
		super.output();
		System.out.println(salary());
		
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
		return salaryMultiplier*730+allowance+teachingTime*45;
	}
	
	

}
