package java8;

import java.util.Arrays;
import java.util.List;

public class LambdaPractice {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("a new thread is running..")).start();
		
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);
		
		List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
		int factor = 2;
		primes.forEach(element -> { System.out.println(factor*element); buildStr("xx");});
		
		
		//"peter"->buildStr();
		
	}
	
	public static String buildStr(String param)
	{
		return "***"+param+"***";
	}

}
