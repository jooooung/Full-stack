// 폴더에서 Shift + 우클릭 - PowerShell - java Hello 진 정국 ->Hello, 진, 정국 이라고 출력
public class Hello {
	public static void main(String[] args) {
		System.out.print("Hello");
		for(int i=0 ; i<args.length ; i++) {
			System.out.print("," + args[i]);
			
		}
	}
}
