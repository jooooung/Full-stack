package strategy1_step5.modularization;

import strategy1_step4.interfaces.FlyNo;
import strategy1_step4.interfaces.KnifeWood;
import strategy1_step4.interfaces.MissileYes;

public class StandardRobot extends Robot {

	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
}
