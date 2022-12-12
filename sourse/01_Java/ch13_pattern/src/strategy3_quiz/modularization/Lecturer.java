package strategy3_quiz.modularization;

import strategy3_quiz.interfaces.GetSalary;
import strategy3_quiz.interfaces.JobLec;

public class Lecturer extends Person {

	private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		setGet(new GetSalary());
		setJob(new JobLec());
		this.subject = subject;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[강의과목]" + subject);
	}
}
