package strategy3_quiz.modularization;

import strategy3_quiz.interfaces.GetSalary;
import strategy3_quiz.interfaces.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		setGet(new GetSalary());
		setJob(new JobMng());
		this.part = part;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[ºÎ¼­]" + part);
	}
}
