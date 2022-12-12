package strategy2.interfaces;

public class FuelGosoline implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("휘발유로 움직입니다");
	}
}
