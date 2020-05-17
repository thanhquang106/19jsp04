package DaHinh;

public class Triangle extends Shape {
	int base;
	 int height;
	 public Triangle(String color,int base,int height) {
		super(color);
		this.base =  base;
		this.height =  height;
	}
	
	 
	
	double getArea() {
		return 0;
		
	}
	public String toString() {
		return color;
		
	}
}