package tr.org.linux.kamp.aaio.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * @author ahripol
 * 
 */
public abstract class GameObject {
	private int x;
	private int y;
	private int r;
	private Color color;
/**
 * to draw objects that will be needed in the game.
 */
	public void draw(Graphics2D g2d) {
		g2d.setColor(getColor());
		g2d.fillOval(getX(), getY(), getR(), getR());
		
		// TODO Auto-generated method stub

	}
	/**
	 * to check collisions that will happen between game objects, acts like all shapes are rectangle.
	 */

	public Rectangle getRect() {
		Rectangle rect = new Rectangle(getX(), getY(), getR(), getR());
		return rect;
	}

	public GameObject(int x, int y, int r, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
