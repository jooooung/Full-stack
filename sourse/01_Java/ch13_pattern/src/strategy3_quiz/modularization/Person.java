package strategy3_quiz.modularization;

import strategy3_quiz.interfaces.GetImpl;
import strategy3_quiz.interfaces.JobImpl;

public abstract class Person {
	private String id;
	private String name;
	private GetImpl get;
	private JobImpl job;
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void get() {
		get.get();
	}
	public void job() {
		job.job();
	}
	public void print() {
		System.out.print("[id]" + id + "[name]" + name);
	}
	
	public void setGet(GetImpl get) {
		this.get = get;
	}
	public void setJob(JobImpl job) {
		this.job = job;
	}
}
