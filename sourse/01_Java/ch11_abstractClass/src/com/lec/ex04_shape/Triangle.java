package com.lec.ex04_shape;

public class Triangle extends Shape {
	private int h; // ����
	private int w; // �غ�

	public Triangle() {
		super();
	}

	public Triangle(int h, int w) {
		super();
		this.h = h;
		this.w = w;
	}

	@Override
	public double area() {
		return h * w * 0.5;
	}

	@Override
	public void draw() {
		System.out.print("�ﰢ��");
		super.draw();
	}
}
