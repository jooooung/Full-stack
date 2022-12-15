package com.lec.ex4_object;

public class Quiz_point3D_Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D point = new Point3D();
		point.getX();
		point.getY();
		point.getZ();
		System.out.println(point);
		System.out.println();
		Point3D point2 = new Point3D(1.1, 1.1, 1.1);
		System.out.println(point2);
		System.out.println();
		Point3D point3 = (Point3D) point.clone();
		if (point.equals(point3)) {
			System.out.println("복제 성공 : point를 복제한 point3");
		} else {
			System.out.println("복제 실패");
		}
	}
}
