package strategy2.interfaces;

public class FuelDiesel implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("경유로 움직입니다");
	}
}
