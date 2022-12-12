package strategy3_quiz.modularization;

import strategy3_quiz.interfaces.GetStudentPay;
import strategy3_quiz.interfaces.JobStudy;

public class Student extends Person {
	
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		setGet(new GetStudentPay());
		setJob(new JobStudy());
		this.ban = ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[¹Ý]" + ban);
	}
}
