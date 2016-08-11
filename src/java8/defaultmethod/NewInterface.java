package java8.defaultmethod;

public interface NewInterface {
	
	public void doJob1();
	
	default public void doJob2() {
		System.out.println("I did the default job");
	}
	
}
