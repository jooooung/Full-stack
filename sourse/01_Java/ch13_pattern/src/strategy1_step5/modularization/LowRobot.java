package strategy1_step5.modularization;

import strategy1_step4.interfaces.FlyNo;
import strategy1_step4.interfaces.KnifeNo;
import strategy1_step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
}
