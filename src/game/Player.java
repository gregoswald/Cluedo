package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a human player in the Cluedo game. Holds information about the hand, and the player piece.
 * @author Jarred Hone
 *
 */

public class Player {
List<Card> hand = new ArrayList<Card>();
//TODO Will need to do something about the game piece that currently represents the player on the board. Maybe a seperate class for piece?

public Player(Card...cards){ //Could change to arraylist input - will have to see.
	for(Card c:cards){ //for each card input into constructor arguments, add it to hand.
		hand.add(c);
	}
}

//TODO Will need something that reads through the hand ArrayList and displays each card on the GUI where the players hand would go.












}
