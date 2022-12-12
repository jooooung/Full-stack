package strategy3_quiz.interfaces;

public class GetStudentPay implements GetImpl {

	@Override
	public void get() {
		System.out.println("교육급여를 받습니다");
	}
}
