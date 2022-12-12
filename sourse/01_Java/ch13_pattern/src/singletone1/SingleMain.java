package singletone1;

public class SingleMain {

	public static void main(String[] args) {
		Single obj1 = new Single();
		Single obj2 = new Single();
		obj1.setI(99);
		System.out.println(obj1.getI());
		System.out.println(obj2.getI());
	}
}
