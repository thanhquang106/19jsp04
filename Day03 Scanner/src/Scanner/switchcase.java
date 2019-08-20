package Scanner;

public class switchcase {
	public static void main(String[] args) {
		int a='1';
		switch (a) {
		case '1':
			System.out.println("create employee");
			break;
		case'2':
			System.out.println("show the existing employee");
			break;
		case'3':
			System.out.println(" exit");
			break;
		
			default:
				System.out.println("");
		}
		//////////////////////////////////////
		
		int i=1;
		int sum=0;
		do {
			if(i%2==0) {
			sum=sum+i;}
			i++;
		}
		while(i<=10);
		System.out.println(sum);

		
	}
	
	
}
