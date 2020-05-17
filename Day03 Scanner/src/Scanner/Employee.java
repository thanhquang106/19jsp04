package Scanner;



import java.util.Scanner;

public class Employee {
	int id;
	String name;
	double salary;
	int age;
	boolean married;
	Job job;
	public Employee(int id, String name, double salary, Job job) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.job = job;
	}
	public Employee() {
		
	}
	public void NhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" id :");
		id = sc.nextInt();
		Scanner sc1 = new Scanner(System.in);
		System.out.println(" name :");
		name = sc1.nextLine();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("salary :");
		salary = sc2.nextDouble();
		
	}
	public void HienThiTT() {
		System.out.println("id : " +id);
		System.out.println("ten nhan vien : " +name);
		System.out.println("luong : " +salary);

	}

	
}
