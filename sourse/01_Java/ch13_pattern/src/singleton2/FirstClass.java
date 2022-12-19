package singleton2;

public class FirstClass {
	public FirstClass() {
//		System.out.println("FirstClass»ý¼ºÀÚ ½ÇÇàÁß");
//		SingletonClass singletonObject = SingletonClass.getInstance();
//		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ i°ª : " + singletonObject.getI());
//		singletonObject.setI(999);
//		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ i°ª ¼öÁ¤ÈÄ : " + singletonObject.getI());

		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ i°ª : " + singletonObject.getI());
		singletonObject.setI(10);
		System.out.println("½Ì±ÛÅæ °´Ã¼ i ¼öÁ¤ ÈÄ" + singletonObject.getI());
	}
}

	