package anno;

import java.lang.annotation.Annotation;

@Tester()
public class Test {
	
	public void method(){
		System.out.println();
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.method();
		
		if(Test.class.isAnnotationPresent(Tester.class)){
			System.out.println("this is annotated with Tester");
			Annotation anno = Test.class.getAnnotation(Tester.class);
			Tester a_o = (Tester) anno;
			System.out.println(a_o.value());
		}
	}
	
	
}
