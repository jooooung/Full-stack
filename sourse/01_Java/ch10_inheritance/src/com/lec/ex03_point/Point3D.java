//x, y /infoPrint(좌표 x=2, y=1을 콘솔에 출력)
package com.lec.ex03_point;

public class Point3D extends Point {
	private int z;  // 3차원이기에 z 추가
	public Point3D(int x, int y, int z) {
//		setX(x);
//		setY(y);
		super(x, y);
		System.out.println("매개변수 있는 Point3D 생성자 함수 - x, y, z 값 초기화");
		this.z = z;
	}
//	infoPrint를 override : 좌표 x:2, y:1, z:1 (super.infoPrint이용)
//	public void infoPrint3D() {
//		System.out.println("좌표 x=" + getX() + ", y=" + getY() + ", z=" + z);
//	}
	@Override
	public String infoPrint(){
		return super.infoPrint() + ", z= " + z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
