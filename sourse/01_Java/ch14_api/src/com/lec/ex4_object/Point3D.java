package com.lec.ex4_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;

	public Point3D() {}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (getClass() == obj.getClass()) {
			Point3D other = (Point3D) obj;
			boolean xChk = x == other.x;
			boolean yChk = y == other.y;
			boolean zChk = z == other.z;
			return xChk && yChk && zChk;
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(x == y && y == z) {
			System.out.println("x, y, z의 값은 같다");
		} else {
			System.out.println("x, y, z의 값은 같지 않다");
		}
		return "x값 : " + x + "\ty값 : " + y + "\tz값 : " + z;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}
