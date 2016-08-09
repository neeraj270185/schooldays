package threading;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool extends Thread {
	final int LIMIT = 3;
	public List<String> connections = new ArrayList<String>();

	public void getConnection() {
		synchronized (connections) {
			if (connections.size() >= LIMIT) {
				try {
					System.out.println("no connection available.. waiting for one "+currentThread().getName());
					connections.wait();
				} catch (InterruptedException e) {
					System.out.println("t1 InterruptedException");
				}
			} else {
				connections.add(currentThread().getName());
				System.out.println("connection aquired by "+currentThread().getName());
				getStatus();
				
				
			}
		}
	}
	public void close()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (connections) {
			System.out.println("connection released "+currentThread().getName());
			connections.remove(currentThread().getName());
			connections.notify();
			getStatus();
		}
	}
	
	public void getStatus()
	{
		System.out.println("Connections: "+connections.size());
	}

	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool();
		Thread t1 = new Thread("t1"){

			@Override
			public void run() {
				pool.getConnection();
				pool.close();
			}
			
		};
		Thread t2 = new Thread("t2"){

			@Override
			public void run() {
				pool.getConnection();
				pool.close();
			}
			
		};
		Thread t3 = new Thread("t3"){

			@Override
			public void run() {
				pool.getConnection();
				pool.close();
			}
			
		};
		Thread t4 = new Thread("t4"){

			@Override
			public void run() {
				pool.getConnection();
				pool.close();
			}
			
		};
		Thread t5 = new Thread("t5"){

			@Override
			public void run() {
				pool.getConnection();
				pool.close();
			}
			
		};
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
