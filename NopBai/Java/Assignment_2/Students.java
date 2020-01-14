import java.util.Random;

public class Students {

	public static void main(String[] args) {
		
//Cau 1: Tao 10 sinh vien
		String[] ho = new String[7];
		ho[0] = "Le";
		ho[1] = "Nguyen";
		ho[2] = "Ho";
		ho[3] = "Tran";
		ho[4] = "Phan";
		ho[5] = "Phung";
		ho[6] = "Vu";

		String[] dem = new String[] { "Thi", "Thuy", "Tuan", "Thu", "Minh", "Van", "Phong" };

		String[] ten = new String[] { "Thanh", "My", "Duc", "Hung", "Ngoc", "Lan", "Tien" };

		String[] hoten = new String[10];

		for (int i = 0; i < 7; i++) {
			hoten[i] = ho[i] + " " + dem[i] + " " + ten[i];
		}
		for (int j = 7; j < 10; j++) {
			hoten[j] = ho[j - 5] + " " + dem[j - 4] + " " + ten[j - 3];
		}

		
		
//Cau 2: Tao 10 ID của sinh viên. ID bao gồm “SV” + 7 số 
		String[] masv = new String[10];
		for (int i = 0; i < 10; i++) {
			 masv[i] = "SV"+ (int)Math.floor(((Math.random() * 8999999) + 1000000));
		}
		
//Cau 3: Tạo 10 ngày sinh của sinh viên nằm trong khoảng 01/02/1991 và 31/12/1991. 
		String[] ngaysinh = new String[10];
		Random rand = new Random();
		for(int i=0; i<10; i++) {
			int ngay = rand.nextInt((31 - 1) + 1) + 1;
			int thang = rand.nextInt((12 - 2) + 1) + 2;
			ngaysinh[i]=ngay+"/"+thang+"/"+1991;
		}
//Cau 4: In thông tin trên ra màn hình: 	
		System.out.println("Full Name"+"				 "+"ID"+"			"+"Ngay sinh"+"		");
		System.out.println("=========================================================================");
		for(int i=0; i<10; i++) {
			System.out.println(hoten[i]+"				"+ masv[i]   +"		"+  ngaysinh[i]);
		}
	}
	

}
