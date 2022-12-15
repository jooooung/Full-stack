import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int u, com;
		final int SCISSOR = 0;
		final int 바위 = Integer.parseInt("1");
		final int 보 = Integer.parseInt("2");
		
		do {
			System.out.println("가위, 바위, 보 중 하나를 입력하세요");
			String uStr = sc.next().trim();
			if(uStr.equals("가위")) {
				u = 가위;
			}
			com = random.nextInt(3);
			if(u<-1 || u>2) {
				System.out.println();
			}
			
			
			
			
			
		} while ((u+2)%3 != com || u == com);
	}
}

//trim() space 없애는 메소드