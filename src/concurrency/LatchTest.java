package concurrency;

import java.util.concurrent.CountDownLatch;

public class LatchTest extends Thread{
	static int i = 1;
	CountDownLatch latch;
	
	public LatchTest(CountDownLatch latch, String name){
		super.setName(name);
		this.latch = latch;
		
	}
	
	public void run()
	{
		System.out.println("running "+this.getName());
		try {
			Thread.sleep(500*i++);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName()+" finished");
		this.latch.countDown();
	}
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		LatchTest l1 = new LatchTest(latch, "service1");
		LatchTest l2 = new LatchTest(latch, "service2");
		LatchTest l3 = new LatchTest(latch, "service3");
		LatchTest l4 = new LatchTest(latch, "service4");
		LatchTest l5 = new LatchTest(latch, "service5");
		
		l1.start();l2.start();l3.start();l4.start();l5.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All services are up now");
	}

}
