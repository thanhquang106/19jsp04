package Scanner;

import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

	public static void main(String[] args) {
	
		Job job1 = new Job("HR");
		Job job2 = new Job("BA");
		Job job3 = new Job("Tester");
		Job job4 = new Job("Developer");
		Job job5 = new Job("CEO");
	
		Employee[] employs = new Employee[5];

		int id = 0;
	String name = null;
		double salary = 0;
	Employee employ1= new Employee(id, name, salary, job1);
	System.out.println(" Nhan vien 1 ");
	System.out.println("nhap id : ");
	Scanner scanner = new Scanner(System.in);
	employ1.id =scanner.nextInt();
	System.out.println("nhap name : ");
	Scanner scanner1 = new Scanner(System.in);
	employ1.name =scanner1.nextLine();
	System.out.println("nhap salary : ");
	Scanner scanner2 = new Scanner(System.in);
	employ1.salary =scanner2.nextDouble();
	
	employs[0] = employ1;
		
		
		Employee employ2= new Employee(id, name, salary, job2);
		
		System.out.println(" Nhan vien 2 ");
		System.out.println("nhap id : ");
		Scanner employ21 = new Scanner(System.in);
		employ2.id = employ21.nextInt();
		System.out.println("nhap name : ");
		Scanner employ22 = new Scanner(System.in);
		employ2.name = employ22.nextLine();
				System.out.println("nhap salary : ");
		Scanner employ23 = new Scanner(System.in);
		employ2.salary = employ23.nextDouble();
		employs[1] = employ2;
		
		Employee employ3= new Employee(id, name, salary, job3);
		System.out.println(" Nhan vien 3 ");
		System.out.println("nhap id : ");
		Scanner employ31 = new Scanner(System.in);
		employ3.id = employ31.nextInt();
		System.out.println("nhap name : ");
		Scanner employ32 = new Scanner(System.in);
		employ3.name = employ32.nextLine();
		System.out.println("nhap salary : ");
		Scanner employ33 = new Scanner(System.in);
		employ3.salary = employ33.nextDouble();
	employs[2] = employ3;
		
		Employee employ4= new Employee(id, name, salary, job4);
		System.out.println(" Nhan vien 4 ");
		System.out.println("nhap id : ");
		Scanner employ41 = new Scanner(System.in);
		employ4.id = employ41.nextInt();
		System.out.println("nhap name : ");
		Scanner employ42 = new Scanner(System.in);
		employ4.name = employ42.nextLine();
				System.out.println("nhap salary : ");
		Scanner employ43 = new Scanner(System.in);
		employ4.salary = employ43.nextDouble();
		employs[3] = employ4;
		
		Employee employ5= new Employee(id, name, salary, job5);
		System.out.println(" Nhan vien 5 ");
		System.out.println("nhap id : ");
	Scanner employ51 = new Scanner(System.in);
		employ2.id = employ51.nextInt();
		System.out.println("nhap name : ");
		Scanner employ52 = new Scanner(System.in);
		employ5.name = employ52.nextLine();
				System.out.println("nhap salary : ");
		Scanner employ53 = new Scanner(System.in);
		employ5.salary = employ53.nextDouble();
		employs[4] = employ5;		
		
		System.out.print(employs[0].id+" | ");
		System.out.print(employs[0].name+" | ");
		System.out.print(employs[0].salary+" | ");
		System.out.println(employs[0].job.Job);
		
		System.out.print(employs[1].id+" | ");
		System.out.print(employs[1].name+" | ");
		System.out.print(employs[1].salary+" | ");
		System.out.println(employs[1].job.Job);
		
		System.out.print(employs[2].id+" | ");
		System.out.print(employs[2].name+" | ");
		System.out.print(employs[2].salary+" | ");
		System.out.println(employs[2].job.Job);
		
		System.out.print(employs[3].id+" | ");
		System.out.print(employs[3].name+" | ");
		System.out.print(employs[3].salary+" | ");
	System.out.println(employs[3].job.Job);
		
		System.out.print(employs[4].id+" | ");
		System.out.print(employs[4].name+" | ");
		System.out.print(employs[4].salary+" | ");
		System.out.println(employs[4].job.Job);
		
		for (int i = 6; i < employs.length; i++) {
			System.out.println(employs[i].id+"  ");
		}
		
//		ArrayList<Employee> danhsach = new ArrayList();
//		int[] Array;
//		int n; // so luong khach hang
//		int luachon;
//		System.out.println("1. nhap vao n nhan vien");
//		System.out.println("2. hien thi thong tin danh sach nhan vien.");
//	
//		
//		Scanner sc = new Scanner(System.in);
//		do {
//			
//			System.out.println("moi ban nhap vao lua chon :");
//			
//			try {
//				luachon = Integer.parseInt(sc.nextLine());
//			}
//			catch(NumberFormatException e) {
//				luachon = 0;
//				System.out.println("ban can nhap vao mot so nguyen.");
//			}
//			switch(luachon) {
//			case 1:{
//				System.out.println("nhap vao so luong nhan vien");
//				n = Integer.parseInt(sc.nextLine());
//				Array = new int[n];
//				for(int i=0;i<Array.length;i++) {
//				Employee em = new Employee();
//				em.NhapTT();
//				danhsach.add(em);//
//				}
//				break;
//			}
//			case 2:{
//				System.out.println("thong tin nhan vien co trong danh sach :");
//				for(int i =0;i<danhsach.size();i++) {
//					danhsach.get(i).HienThiTT();
//				}
//				break;
//			}
//
//			case 3:{
//				break;
//			}
//			}
//		}while(luachon!=3);
	}
	
	}
