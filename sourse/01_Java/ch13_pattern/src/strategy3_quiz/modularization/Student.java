package strategy3_quiz.modularization;

import strategy3_quiz.interfaces.GetStudentPay;
import strategy3_quiz.interfaces.JobStudy;

public class Student extends Person {
	
	public Student(String id, String name, String setJob) {
		setGet(new GetStudentPay());
		setJob(new JobStudy());
	}
}
