package DaHinh;

public class Rectangle extends Shape {
	public Rectangle(String color,int length,int width) {
		super(color);
		this.length = length;
		this.width = width;

	}

	int length;
	int width;

	double getArea() {
		return 0;
	}

	public String toString() {
		return color;

	}

}