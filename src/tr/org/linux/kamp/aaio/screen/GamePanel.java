package tr.org.linux.kamp.aaio.screen;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;


import tr.org.linux.kamp.aaio.models.GameObject;
/**
 * @author ahripol
 * Sets up game panel .
 */


public class GamePanel extends JPanel {
	private ArrayList<GameObject> gameObject;

	public GamePanel(ArrayList<GameObject> gameObject) {//CHECK YOUR LETTERCASES!
		this.gameObject = gameObject;

	}
	/**
	 * Draws objects 
	 * 
	 */
	@Override
	protected synchronized void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		for (GameObject gameObject : gameObject) {
			gameObject.draw(g2d);
		}

	}

}
