package enums;

public class TestEnums {

	public static void main(String[] args) {
		MyEnum e = MyEnum.PENNY;
		Thread t = new Thread(e);
		t.start();
		System.out.println(e.val);
	}

}
