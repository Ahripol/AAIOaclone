package tr.org.linux.kamp.aaio.screen;

import java.awt.Color;


import javax.swing.JFrame;
/**
 * @author ahripol
 * Sets up game frame.
 */

public class GameFrame extends JFrame {
	public GameFrame() {
		setTitle("AAIO");
		setBackground(Color.DARK_GRAY);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
