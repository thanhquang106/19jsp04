package threadDemo;

public class Demo implements Runable{
	private Thread t;
	private String nameThread;
	Demo(String name){
		nameThread= name;
		System.out.println("Creating"+nameThread);
	}
	public void run() {
		System.out.println("Running"+ nameThread);
		for(int i=2;i>0;i++) {
			System.out.println("thread: "+nameThread+","+i);
			
		}
		
	}
	public static void main(String[] args) {
		
	}

}
