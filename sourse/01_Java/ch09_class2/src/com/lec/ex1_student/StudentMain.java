package com.lec.ex1_student;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("유아인", 70, 70, 70);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"이름", "국어", "영어","수학", "총점", "평균"};
		int [] total = new int[5]; 	//0번 idx:국어, 1번 idx:영어 ...
		line();
		System.out.println("\t\t\t성적표");
		line('-');
		for(String t : title) {
			System.out.print("\t"+t); 
		}
		System.out.println();
		line('-');
		for(Student student : students) { 
			System.out.print(student.infoString());
			//총점 변수 (국 영 수 총 평)누적
			total[0] += student.getKor();
			total[1] += student.getEng();
			total[2] += student.getMat();
			total[3] += student.getTot();
			total[4] += student.getAvg();		
		}
		line('-');
		System.out.print("\t총점");
		for(int t : total) {
			System.out.print("\t"+t);
		}
		System.out.print("\n\t평균");
		for(int t : total) {
			System.out.printf("\t%.1f", (double)t/students.length);
		}
		System.out.println();
		line();
	}

	private static void line(char c) {
		System.out.print("\t");
		for(int i=0 ; i<50 ; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private static void line() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print("■");
		}
		System.out.println();
	}
}
