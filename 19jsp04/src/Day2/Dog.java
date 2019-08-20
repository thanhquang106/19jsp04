package Day2;

public class Dog {

	public String name;
	public int age;
	public String color;

	public Dog(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public void packing(String a) {
		System.out.println("dog packing " + a);

	}

	public void walking(String a) {
		System.out.println("dog walking " + a);
	}

	public void eatting(String a) {
		System.out.println("dog eatting " + a);

	}

}
