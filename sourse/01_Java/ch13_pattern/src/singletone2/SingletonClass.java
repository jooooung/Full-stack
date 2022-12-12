package singletone2;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass();

	private SingletonClass() {
		i = 10;
	}
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
