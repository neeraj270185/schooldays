package concurrency;

import java.util.concurrent.Semaphore;

public class MutexTest {
	static Semaphore mutex = new Semaphore(5);

	public static void main(String[] args) {
		new Runner().start();
		new Runner2().start();
	}

	static class Runner extends Thread {
		public void run() {
			int counter = 0;
			while (true) {
				
				try{
				mutex.acquire();
				System.out.println("running thread " + ++counter);
				Thread.sleep(500);
				mutex.release();
				System.out.println("finished thread " + counter);
				}catch(Exception e){}
			}
		}
	}
	static class Runner2 extends Thread {
		public void run() {
			int counter = 0;
			while (true) {
				
				try{
				mutex.acquire();
				System.out.println("@running thread " + ++counter);
				Thread.sleep(500);
				mutex.release();
				System.out.println("@finished thread " + counter);
				}catch(Exception e){}
			}
		}
	}
}
