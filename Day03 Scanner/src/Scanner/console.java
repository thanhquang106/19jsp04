package Scanner;

import java.util.Scanner;

public class console {
	public static void main(String[] args) {
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("nhap A");
		int A = sc.nextInt();
		System.out.println("nhap B");
		Scanner sc1 = new Scanner(System.in);
		int B = sc1.nextInt();
		int c;
	

		System.out.println("A+B: " + (A + B));
		System.out.println("A-B: " + (A - B));
		System.out.println("A%B: " + (A % B));
		System.out.println("A/B: " + (A / B));
		System.out.println("A++: " + (A++));
		System.out.println("B--: " + (B--));
		c=(A<B)? 0:1;
		System.out.println("A<B"+c);
		c=(A<B)? 0:1;
		System.out.println("A<=B"+c);*/
		char grade ='C';
		switch (grade) {
		case 'A':
			System.out.println("Excellent");
			break;
		case'B':
		case'C':
			System.out.println("well done");
			break;
		case'D':
			System.out.println("you passed");
			break;
		case'E':
			System.out.println("better try again");
			break;
			default:
				System.out.println("....");
		}
		System.out.println("your grade is"+grade);
		
		

	}

}
