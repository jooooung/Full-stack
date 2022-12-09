package com.lec.ex03_speakertv;

public class Speaker implements IVolume {
	private int volumeLevel;
	private final int MAX_VOLUME = 50;
	private final int MIN_VOLUME = 0;

	public Speaker() {
		volumeLevel = 10;
	}

	@Override
	public void volumeUp() { // 볼륨을 1씩 증가
		// TODO Auto-generated method stub
		if (volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("스피커 볼륨을 1만큼 올려 현재 볼륨은 " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최대입니다");
		}
	}

	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub
		if (volumeLevel + level < MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("스피커 볼륨을 " + level + "만큼 올려 현재 볼륨은 " + volumeLevel);
		} else {
			int tempLevel = MAX_VOLUME - volumeLevel;
			volumeLevel = MAX_VOLUME;
			System.out.println("스피커 볼륨을 " + tempLevel + "만큼 올려 최대치입니다");
		}
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		if (volumeLevel > MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨 1 내려 현재 " + volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최소입니다");
		}
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		if (volumeLevel - level > MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨 " + level + " 내려 현재 " + volumeLevel);
		} else {
			int tempLevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("스피커 볼륨이 최소입니다");
		}
	}
}
