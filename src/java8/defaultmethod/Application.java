package java8.defaultmethod;

import java.util.List;

public class Application implements NewInterface{

	public static void main(String[] args) {
		Application app = new Application();
		app.doJob1();
		app.doJob2();
		
	}

	@Override
	public void doJob1() {
		System.out.println("job 1");
	}
	
	@Override
	public void doJob2() {
		System.out.println("job 2");
	}

}
