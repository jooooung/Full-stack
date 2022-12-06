package com.lec.quiz;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90);
		Student[] students = {s1, s2, s3, s4, s5};
		int[] total = new int[5];
		line();
		System.out.println("\t\t\t\t성적표");
		line('-');
		System.out.println();
		System.out.println("\t번호 \t이름 \t국어 \t영어 \t수학 \t총점 \t평균 ");
		for(Student student :students) {
			student.infoPrint();
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
			System.out.printf("\t%d", t/students.length);
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
