package game;

import ui.BoardFrame;

public class Game {

	/**
	 * Main Method for the Cluedo game -
	 * Shouldn't be too complicated,
	 * will probably pass off most of the functionality to other classes.
	 * @param args
	 */
	String filename;
	public static void main(String[] args) {

		BoardFrame cluedo = new BoardFrame();
		String filename = args[0];
		cluedo.getCanvas().getGameBoard().setFileName(filename);

		
	}

}
