//필요한 데이터 width(가로), height(새로), depth(깊이)
//사각형 : BoxOrRect box = new BoxOrRect(2, 3)
//박스 : BoxOrRect box = new BoxOrRect(2, 3, 4)
//메소드 : calVolume(), infoPrint(), infoString()
package com.lec.ex4_boxorrect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;

	public BoxOrRect() {
	} // 디폴트 생성자

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		// volume 셋팅
		calVolume();
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		calVolume();
	}

	private void calVolume() {
		if (depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		}
	}

	public void infoPrint() {
		if (depth == 0) {
			System.out.printf("사각형 가로 : %d, 세로 : %d, 넓이 : %d\n", width, height, volume);
		} else {
			System.out.printf("박스 가로 : %d, 세로 : %d, 깊이 : %d, 부피 : %d\n", width, height, depth, volume);
		}
	}
	public String infoString() {
		if(depth==0) {
			return String.format("사각형 가로 : %d, 세로 : %d, 넓이 : %d", width, height, volume);
		}else {
			return String.format("박스 가로 : %d, 세로 : %d, 깊이 : %d, 부피 : %d", width, height, depth, volume);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		calVolume();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		calVolume();
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		calVolume();
	}

	public int getVolume() {
		return volume;
	}
}
