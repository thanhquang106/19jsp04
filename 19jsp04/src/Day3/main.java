package Day3;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Job job1 = new Job("HR");
		Job job2 = new Job("BA");
		Job job3 = new Job("Tester");
		Job job4 = new Job("Developer");
		Job job5 = new Job("CEO");

		int id = 0;
		String Name = null;
		double Salary = 0;
		Job jod;
		Employee[] employeeArray = new Employee[5];
		Employee employee1 = new Employee(1, "Nguyễn Văn A", 4000, job1);
		/*
		 * System.out.println("nhap ID: "); Scanner sc1 = new Scanner(System.in);
		 * employee1.id = sc1.nextInt(); System.out.println("nhap ten: "); Scanner sc2 =
		 * new Scanner(System.in); employee1.name = sc2.nextLine();
		 * System.out.println("nhap luong: "); Scanner sc3 = new Scanner(System.in);
		 * employee1.Salary = sc3.nextDouble();
		 */

		employeeArray[0] = employee1;

		Employee employee2 = new Employee(2, "Nguyễn Văn B", 5000, job2);
		/*
		 * System.out.println("nhap ID: "); Scanner sc4 = new Scanner(System.in);
		 * employee2.id = sc4.nextInt(); System.out.println("nhap ten: "); Scanner sc5 =
		 * new Scanner(System.in); employee2.name = sc5.nextLine();
		 * System.out.println("nhap luong: "); Scanner sc6 = new Scanner(System.in);
		 * employee2.Salary = sc6.nextDouble();
		 */

		employeeArray[1] = employee2;

		Employee employee3 = new Employee(3, "Nguyễn Văn C", 6000, job3);
		/*
		 * System.out.println("nhap ID: "); Scanner sc7 = new Scanner(System.in);
		 * employee3.id = sc7.nextInt(); System.out.println("nhap ten: "); Scanner sc8 =
		 * new Scanner(System.in); employee3.name = sc8.nextLine();
		 * System.out.println("nhap luong: "); Scanner sc9 = new Scanner(System.in);
		 * employee3.Salary = sc9.nextDouble();
		 */

		employeeArray[2] = employee3;

		Employee employee4 = new Employee(4, "Nguyễn Văn D", 7000, job4);

		employeeArray[3] = employee4;
		Employee employee5 = new Employee(5, "Nguyễn Văn E", 8000, job5);

		employeeArray[4] = employee5;

		// System.out.println(("employee1 id: ") + employee1.id + (" employee name: ") +
		// employee1.name + ("employee salary: ")
		// + employee1.Salary + ("employee job: ") + employee1.job.name);

		// System.out.println(("employee1 id: ") + employeeArray[4].id + ("employee
		// name: ") + employeeArray[4].name
		// + ("employee salary: ") + employeeArray[4].Salary + ("employee job: ") +
		// employeeArray[4].job.name);
		/*
		 * System.out.print(employeeArray[0].id+" | ");
		 * System.out.print(employeeArray[0].name+" | ");
		 * System.out.print(employeeArray[0].Salary+" | ");
		 * System.out.println(employeeArray[0].job.name+" | ");
		 * 
		 * System.out.print(employeeArray[1].id+" | ");
		 * System.out.print(employeeArray[1].name+" | ");
		 * System.out.print(employeeArray[1].Salary+" | ");
		 * System.out.println(employeeArray[1].job.name+" | ");
		 * 
		 * System.out.print(employeeArray[2].id+" | ");
		 * System.out.print(employeeArray[2].name+" | ");
		 * System.out.print(employeeArray[2].Salary+" | ");
		 * System.out.println(employeeArray[2].job.name+" | ");
		 */
		for (int i = 0; i < employeeArray.length; i++) {
			System.out.println("ID: " + employeeArray[i].id + " Name: " + employeeArray[i].name + " Salary: "
					+ employeeArray[i].Salary + " Job: " + employeeArray[i].job.name);
		}

	}
}
