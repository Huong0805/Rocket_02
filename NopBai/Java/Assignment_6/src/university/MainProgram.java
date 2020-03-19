package university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
	       
			System.out.print("Nhap so nhan vien: ");
	        int n = scanner.nextInt();
	        //Tao danh sach nhan vien
	        ArrayList<Employee> emp = new ArrayList();
	    
	         //Nhap thong tin cac nhan vien
	        
	        System.out.println("Nhap thong tin cac nhan vien  ");
	        for (int i = 0; i < n; i++) {
	            System.out.print("Nhap thong tin nhan vien thu " + (i + 1) + ":  ");
	            System.out.print("1-Giao su,  2-Can bo  ");
	            
	            //Chon giao su/ can bo
	            int choose = scanner.nextInt();
	           
	            if (choose == 1) {
	                Professor p = new Professor();
	                p.input();
	                p.salary();
	                emp.add(p);
	            } else{

	                Staffs s = new Staffs();
	                s.input();
	                s.salary();
	                emp.add(s);
	            }
	             
	        }
	        
	        
		int choose1;
		do {
			System.out.println("Lua chon: 1-Tim kiem    2-In thong tin giao su");
			
	        choose1 = scanner.nextInt();
	        scanner.nextLine();
	        
	        //1-Tim kiem thong tin can bo theo ten va phong ban
	        //2-In ra danh sach giao su sx theo ho ten
	        
			if (choose1==1) {
				String name;
				String department;
				System.out.println("Nhap ho ten nhan vien ");
				name = scanner.nextLine();
				
				System.out.println("Nhap phong ban ");
				department = scanner.nextLine();
				for (int i = 0; i < n; i++) {
					if (emp.get(i) instanceof Staffs) {
						
						
						Staffs st = (Staffs) emp.get(i);
					
						
						if(name.equalsIgnoreCase(st.fullName) && department.equalsIgnoreCase(st.department)) { 
								System.out.println("Nhan vien can tim: \n");
								st.output();
						}else {
								System.out.println("Not found");
						}
						
								
					}
				}
				
			}else if(choose1==2) {
				 Collections.sort(emp, new Comparator<Employee>() {
			            @Override
			            public int compare(Employee emp1, Employee emp2) {
			                return (emp1.fullName.compareTo(emp2.fullName));
			            }
				 });
				 
				 
				 System.out.println("Thong tin cac giao su ");
			        for (int i = 0; i < n; i++) {
			        	
			        	if (emp.get(i) instanceof Professor) {
			        		Professor pf = (Professor) emp.get(i);
							pf.output();
				
			        	}
			     }
			}
			
		} while (choose1<=2 && choose1>=1);
				
	}
}
