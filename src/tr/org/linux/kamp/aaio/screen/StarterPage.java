package tr.org.linux.kamp.aaio.screen;

import tr.org.linux.kamp.aaio.logic.GameLogic;
import tr.org.linux.kamp.windowbuilder.Diffuculty;
/**
 * @author ahripol
 * Starts the game
 */
public class StarterPage {
	
	public static void main(String[] args) {

		GameLogic gameLogic = new GameLogic(Diffuculty.EASYPEASY);

		gameLogic.startApplication();

	}

}
