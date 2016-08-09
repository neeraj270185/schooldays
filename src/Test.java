
public class Test {

	public static void main(String[] args) {
		double q = Double.parseDouble("5.89");
		mydao o = new mydao();
		o.setQ(q);
		
		System.out.println(o.toString());
		
	}

}
class mydao{
	double q;

	public double getQ() {
		return q;
	}

	public void setQ(double q) {
		this.q = q;
	}

	@Override
	public String toString() {
		return "mydao [q=" + q + "]";
	}
	
}
