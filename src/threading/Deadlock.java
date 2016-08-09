package threading;

public class Deadlock {
	public void m1(){
		synchronized(Integer.class){
			System.out.println("Int");
		
		synchronized(String.class){
			System.out.println("str");
		}}
	}
	public void m2(){
		
		synchronized(String.class){
			System.out.println("str");
		
		synchronized(Integer.class){
			System.out.println("Int");
		
		}}
	}
	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		Thread t1 = new Thread(){
			public void run(){
				d.m1();
				d.m2();
				System.out.println("t1 finished");
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d.m2();
				d.m1();
				System.out.println("t2 finished");
			}
		};
		t1.start();t2.start();
	}
}
