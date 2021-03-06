package university;


//Giao su
public class Professor extends Employee  {
	
	
	protected String faculty;			//Nang luc
	protected float  teachingTime;		

	
	/**
	 * Nhap thong tin giao su
	 */
	@Override
	public void input() {

		super.input();
        System.out.print("Nhap nang luc: ");
        faculty = scanner.next();
        System.out.print("Nhap so gio day: ");
        teachingTime = scanner.nextFloat();   
    }
	
	/**
	 * In ra cac thong tin cua giao su
	 */
	@Override
	public void output() {
		super.output();
		System.out.println(faculty+"\t"+teachingTime+"\t"+salary()+"\n");
		
	}
	
	/**
	 * Tinh luong cua giao su
	 */
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
