package threading;

public class TLocal extends Thread{

	ThreadLocal<String> local = new ThreadLocal<>();
	
	public static void main(String[] args) {
		TLocal t = new TLocal();
		Thread t1 = new Thread(t, "t1");
		Thread t2 = new Thread(t, "t2");
		Thread t3 = new Thread(t, "t3");
		Thread t4 = new Thread(t, "t4");
		Thread t5 = new Thread(t, "t5");
		
		t1.start();t2.start();t3.start();t4.start();t5.start();
		Thread tmp = t1;
		System.out.println(t1==tmp);
		t1.setName("x");
		System.out.println(t1==tmp);
	}

	@Override
	public void run() {
		local.set(currentThread().getName());
		System.out.println(local.get());
		
	}

}
