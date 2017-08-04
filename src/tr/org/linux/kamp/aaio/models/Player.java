package tr.org.linux.kamp.aaio.models;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
/**
 * 
 * @author ahripol
 *
 */
public class Player extends Movable {


	public Player(int x, int y, int r, Color color, int speed) {
		super(x, y, r, color, speed);
		// TODO Auto-generated constructor stub
	}

	public Player(int x, int y, int r, Color color) {
		super(x, y, r, color);
		// TODO Auto-generated constructor stub
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private String nick;
	private int score;

	public void getRectangleArea() {

	}
	/**
	 * Sets player's name onto itself with font metrics. Puts it to the middle.
	 */
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		super.draw(g2d);
		FontMetrics fm = g2d.getFontMetrics(g2d.getFont());
		int width = fm.stringWidth(nick);
		int nameX = getX() + (getR() - width) / 2;
		int nameY = getY() - fm.getHeight();
		g2d.drawString(nick, nameX, nameY);
	}

}
