package game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

/**
 * interface that represents a human player in the Cluedo game. Holds information about the hand.2.1 Miss Scarlett
Colonel Mustard
Mrs. White
Reverend/Mr. Green
Mrs. Peacock
Professor Plum
 * @author Jarred Hone & Greg Oswald
 *
 */

public interface Player {

List<Card> hand = new ArrayList<Card>();

public List<Card> gethand();
public void setPos(Square sq);
public void getPos(Square sq);

















}
