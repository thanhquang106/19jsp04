package exception;

public class demo {
	public static void main(String[] args) {
		try {

			int a[] = new int[2];
			System.out.println(a[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error is: "+ e);
			
		}
	}
}
