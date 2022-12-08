//color, tire, displacement, handle, getSpec()
package com.lec.ex05_car;

public abstract class Car { // 추상메소드 getSpec() 있으므로 추상 클래스로 만듬
	private String color;
	private String tire;
	private int displacement;
	private String handle;

	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}

	public abstract void getSpec(); // 추상메소드

	// getter&setter
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

}
