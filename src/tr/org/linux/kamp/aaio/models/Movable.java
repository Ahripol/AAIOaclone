package tr.org.linux.kamp.aaio.models;

import java.awt.Color;

/**
 * 
 * @author ahripol
 * A class to set speed easily to Player and Enemy.
 */

public class Movable extends GameObject {
	public Movable(int x, int y, int r, Color color) {
		super(x, y, r, color);

		// TODO Auto-generated constructor stub
	}

	public Movable(int x, int y, int r, Color color, int speed) {
		super(x, y, r, color);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
