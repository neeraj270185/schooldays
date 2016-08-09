package gc;

public class Finalize_ {
	
	    public static void main(String[] args) throws InterruptedException {
	    	Finalize_ lion = new Finalize_();
	        System.out.println("Main is completed.");
	        System.gc();
	        Thread.sleep(10000);
	    }

	    protected void finalize() {
	        System.out.println("Rest in Peace!");
	    }
	
}
