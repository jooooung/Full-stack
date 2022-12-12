package strategy2.modularization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGosoline;
import strategy2.interfaces.Km15;

public class Sonata extends Car {
	
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGosoline());
	}
	@Override
	public void shape() {
		System.out.println("★소나타 차량은 문, 시트, 핸들로 이루어져 있습니다");
	}
}
