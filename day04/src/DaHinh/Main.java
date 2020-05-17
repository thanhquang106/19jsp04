package DaHinh;

public class Main {
	public static void main(String[] args) {
		Shape shape;

		shape = new Rectangle("Pink", 2, 4);
		System.out.println("Triangle : " + shape.getArea() + " || Color : " + shape.toString());
		shape = new Triangle("Black", 8, 4);
		System.out.println("Rectangle : " + shape.getArea() + " || Color : " + shape.toString());
	}
}
