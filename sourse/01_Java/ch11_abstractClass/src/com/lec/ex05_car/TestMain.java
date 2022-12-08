package com.lec.ex05_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
		Car lowcar = new LowGradeCar(CarSpec.COLOR_GRAY, CarSpec.TIRE_NOMAL, CarSpec.DISPLACEMENT800, CarSpec.HANDLE_POWER);
		Car highcar = new HighGradeCar(CarSpec.COLOR_WHITE, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT2000, CarSpec.HANDLE_POWER);
		lowcar.getSpec();
		highcar.getSpec();
	}
}
