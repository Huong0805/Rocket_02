package university;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Employee pr=new Professor();
//		pr.input();
//		pr.salary();
//		pr.output();
//
//		Employee st=new Staffs();
//		st.input();
//		st.salary();
//		st.output();

		
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Nhap so nhan vien: ");
        int n = scanner.nextInt();
        Employee[] ee = new Employee[n];
         
        System.out.println("Nhap thong tin cac nhan vien  ");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap thong tin nhan vien thu " + (i + 1) + ":  ");
            System.out.print("1-Giao su,  2-Can bo  ");
            
            int choose = scanner.nextInt();
            
            if (choose == 1) {
                ee[i] = new Professor();
            } else if (choose == 2) {
                ee[i] = new Staffs();
            }
             
            ee[i].input();
            ee[i].salary();
        }
         
        System.out.println("Thong tin nhan vien: ");
        for (int i = 0; i < n; i++) {
           ee[i].output();
        }
         
	}

}
