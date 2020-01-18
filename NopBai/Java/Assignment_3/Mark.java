import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Mark {

	public static void main(String[] args) {

		Random rand = new Random();
		// Tao 10 sinh vien
				String[] ho = new String[7];
				ho[0] = "Le";
				ho[1] = "Nguyen";
				ho[2] = "Ho";
				ho[3] = "Tran";
				ho[4] = "Phan";
				ho[5] = "Ha";
				ho[6] = "Vu";

				String[] dem = new String[] { "Thi", "Thuy", "Tuan", "Thu", "Minh", "Van", "My" };

				String[] ten = new String[] { "Duc", "My", "Duc", "Hung", "Ngoc", "Lan", "Tien" };

				String[] hoten = new String[10];

				for (int i = 0; i < 10; i++) {
					int indexho=rand.nextInt(7);
					int indexdem=rand.nextInt(7);
					int indexten=rand.nextInt(7);
					hoten[i]=ho[indexho]+" "+dem[indexdem]+" "+ten[indexten];
				}

				
				
		//Tao 10 ID của sinh viên. ID bao gồm “SV” + 7 số 
				String[] masv = new String[10];
				for (int i = 0; i < 10; i++) {
					 masv[i] = "SV"+ (int)Math.floor(((Math.random() * 8999999) + 1000000));
				}
				
		//Tạo 10 ngày sinh của sinh viên nằm trong khoảng 01/02/1991 và 31/12/1991. 
				
				String[] ngaysinh = new String[10];
				for(int i=0; i<10; i++) {
				 long minDay = LocalDate.of(1991, 2,1).toEpochDay();
				  long maxDay = LocalDate.of(1991, 12, 31).toEpochDay();
				  long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
				  LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
				  ngaysinh[i]=randomDate.toString();
				}
				
		//Tao diem cho cac mon hoc thoa man cac yeu cau
				
				float[] RA = new float[10];
				float[] SD = new float[10];
				float[] CP = new float[10];
				float[] CUT = new float[10];
				float[] FMT = new float[10];
				float[] AVG = new float[10];
			
				for (int i = 0; i < 10; i++) {
					if(i==0) {
					int ind =rand.nextInt(2)+8;
					if(ind<10) {
						RA[i]=ind+1;
						SD[i]=ind;
						CP[i]=ind+1;
						CUT[i]=ind+1;
						FMT[i]=ind;
					}else {
						RA[i]=SD[i]=CP[i]=CUT[i]=FMT[i]=ind;
					}
				}
						
					else if(i<=3) {
						int ind =rand.nextInt(2)+5;
						if(ind<7) {
							RA[i]=ind+1;
							SD[i]=ind;
							CP[i]=ind+1;
							CUT[i]=ind+1;
							FMT[i]=ind;
						}else {
							RA[i]=SD[i]=CP[i]=CUT[i]=FMT[i]=ind;
						}
					
					}
					else if(i<=6) {
						int ind =rand.nextInt(1)+3;
						if(ind<4) {
							RA[i]=ind+1;
							SD[i]=ind;
							CP[i]=ind+1;
							CUT[i]=ind+1;
							FMT[i]=ind;
						}else {
							RA[i]=SD[i]=CP[i]=CUT[i]=FMT[i]=ind;
						}
					
					}
					else if(i<=8) {
						int ind =rand.nextInt(1)+1;
						if(ind<2) {
							RA[i]=ind+1;
							SD[i]=ind;
							CP[i]=ind+1;
							CUT[i]=ind+1;
							FMT[i]=ind;
						}else {
							RA[i]=SD[i]=CP[i]=CUT[i]=FMT[i]=ind;
						}	
					
					}
					else {
						RA[i]=0;
						SD[i]=0;
						CP[i]=0;
						CUT[i]=0;
						FMT[i]=0;
					}
					
					
			}
				// Sap xep lai mang cac diem
				
				for (int j = 0; j <10; j++) {
					int index1=rand.nextInt(10);
					int index2=rand.nextInt(10);
					int index3=rand.nextInt(10);
					int index4=rand.nextInt(10);
					int index5=rand.nextInt(10);
					float a=RA[j];
					RA[j]=RA[index1];
					RA[index1]=a;
					
					float b=SD[j];
					SD[j]=SD[index2];
					SD[index2]=b;
					
					float c=CP[j];
					CP[j]=CP[index3];
					CP[index3]=c;
					
					float d=CUT[j];
					CUT[j]=CUT[index4];
					CUT[index4]=d;
					
					float e=FMT[j];
					FMT[j]=FMT[index5];
					FMT[index5]=e;
					AVG[j]=(RA[j]+SD[j]+CP[j]+CUT[j]+FMT[j])/5;
				}
				
				// Sx diem trung binh theo thu tu giam dan
				
				 float temp = AVG[0];
			        for (int i = 0 ; i < 9; i++) {
			            for (int j = i + 1; j < 10; j++) {
			                if (AVG[i] < AVG[j]) {
			                    temp = AVG[j];
			                    AVG[j] = AVG[i];
			                    AVG[i] = temp;
			                }
			            }
			        }
				// In ra man hinh
			        
				System.out.println("Full Name"+"		 "+"ID  "+"	   	       "+"Ngay sinh"+"	 "+"RA"+"	"+"SD"+"	"+"CP"+"	"+"CUT"+"	"+"FMT"+"	"+"TB");
				System.out.println("=====================================================================================================================");	
				for(int i=0; i<10; i++) {
					System.out.println(hoten[i]+"		"+ masv[i]  +"		"+  ngaysinh[i]+"	"+RA[i]+"	"+SD[i]+"	"+CP[i]+"	"+CUT[i]+"	"+FMT[i]+"	"+AVG[i]);
				
			}
	}

	}



