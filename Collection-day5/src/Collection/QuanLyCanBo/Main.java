package Collection.QuanLyCanBo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList arrayList = new ArrayList();
	public static Scanner scanner = new Scanner(System.in);
	public static int inputNumber = 0;
	public static void main(String[] args) {
		showMenu();
	}
	public static void showMenu() {
		do {
			System.out.println("-----MENU----- ");
			System.out.println("1: Nhap danh sach can bo");
			System.out.println("2: Tim kiem ");
			System.out.println("3: Hien thi ");
			System.out.println("-------------------------------");
			inputNumber = scanner.nextInt();
			switch (inputNumber) {
			case 1:
				Nhap();
				break;
			case 2:
				//Search();
				break;
			case 3:
				//Show();
				break;
			}

		}while( inputNumber != 3);
	}
	private static void Nhap() {
		// TODO Auto-generated method stub
		do {
			System.out.println("Nhap nghe nghiep(Cong Nhan, Ky su, Nhan Vien)");
			Scanner sc = new Scanner(System.in);
			String NgheNgiep = sc.nextLine();
			
			if(NgheNgiep.equals("Cong Nhan")) {
				System.out.println("Nhap so Cong Nhan: ");
				int num;
				Scanner key = new Scanner(System.in);
				num = key.nextInt();
				for(int i=1; i<=num; i++) {
					System.out.println("Nhap thong tin Cong Nhan thu: "+i);
					Canbo.nhap();
					
				
				}
			}
			
		} while (true);
		
	}
}