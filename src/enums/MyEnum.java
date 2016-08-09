package enums;

public enum MyEnum implements Runnable{
	PENNY(1), QUARTER(25), HALF(50);
	int val;
	private MyEnum(int v)
	{
		this.val = v;
	}
	@Override
	public void run() {
		System.out.println("running enum..."+this);
	}
}
