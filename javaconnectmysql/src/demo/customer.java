package demo;

public class customer {
	private int ID;
	private String Name;
	private String address;
	private String age;
	private String city;
	@Override
	public String toString() {
		return "customer [ID=" + ID + ", Name=" + Name + ", address=" + address + ", age=" + age + ", city=" + city
				+ "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
