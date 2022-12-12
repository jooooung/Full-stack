package strategy1_step5.modularization;

import strategy1_step4.interfaces.FlyYes;
import strategy1_step4.interfaces.KnifeLazer;
import strategy1_step4.interfaces.MissileYes;

public class SuperRobot extends Robot {
	
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
}
