package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest extends Thread {
	static int i = 1;
	CyclicBarrier barrier;

	public BarrierTest(CyclicBarrier barrier, String name) {
		super.setName(name);
		this.barrier = barrier;
	}

	public void run() {
		System.out.println("running " + this.getName());
		try {
			Thread.sleep(i++ * 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName() + " finished");
	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		BarrierTest b1 = new BarrierTest(barrier, "b1");
		BarrierTest b2 = new BarrierTest(barrier, "b2");
		BarrierTest b3 = new BarrierTest(barrier, "b3");
		BarrierTest b4 = new BarrierTest(barrier, "b4");
		BarrierTest b5 = new BarrierTest(barrier, "b5");

		b1.start();
		b2.start();
		
		b3.start();
		Thread.sleep(5000);
		barrier.reset();
		b4.start();
		b5.start();
		barrier.await();

		System.out.println("all are up");

	}

}
