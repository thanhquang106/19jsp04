package Day2;

public class MainDog {
	public static void main(String[] args) {
		Dog dog = new Dog("kiki", 1, "black");
		System.out.println("Dog :");
		System.out.println("name: " + dog.name);
		System.out.println("age: " + dog.age);
		System.out.println("color: " + dog.color);
		dog.eatting("a");
		dog.walking("b");
		dog.packing("c");
		float c = 3.9f;
		int b = (int) c + 1;
		System.out.println(b);
		
		

	}
}
