package threading;

import java.util.ArrayList;
import java.util.List;

public class PrinterResource extends Thread {

	// resource
	public static List<String> arrayList = new ArrayList<String>();

	public void addElement(String a) {
		 System.out.println("Add element method "+this.getName());
		synchronized (arrayList) {
			arrayList.add(a);
			arrayList.notifyAll();
		}
	}

	public void removeElement() {
		 System.out.println("Remove element method "+this.getName());
		synchronized (arrayList) {
			if (arrayList.size() == 0) {
				try {
					arrayList.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				arrayList.remove(0);
			}
		}
	}

	public void run() {
		System.out.println("Thread name -- " + this.getName());
		if (!this.getName().equalsIgnoreCase("p4")) {
			this.removeElement();
		}
		this.addElement("threads");

	}

	public static void main(String[] args) {
		PrinterResource p1 = new PrinterResource();
		p1.setName("p1");
		p1.start();

		PrinterResource p2 = new PrinterResource();
		p2.setName("p2");
		p2.start();

		PrinterResource p3 = new PrinterResource();
		p3.setName("p3");
		p3.start();

		PrinterResource p4 = new PrinterResource();
		p4.setName("p4");
		p4.start();

		try {
			p1.join();
			p2.join();
			p3.join();
			p4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final size of arraylist  " + arrayList.size());
	}
}