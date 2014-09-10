package tests;

import static org.junit.Assert.*;
import game.Mustard;

import org.junit.Test;

import ui.Board;

public class cluedoTests {


	/**
	 * Tests for successfully adding a player
	 */
	@Test
	public void testValidAddPlayer(){
		Board board = new Board();
		board.addPlayer(1, new Mustard());
		assertEquals((board.getPlayer(1).getID().equals("Mustard")), true);
	}


	/**
	 * Tests for adding a 0th Player - Should be Invalid
	 */
	@Test
	public void testInValidAddPlayer(){ //Should fail 
		Board board = new Board();
		board.addPlayer(0, new Mustard());
		assertEquals((board.getPlayer(0).getID().equals("Mustard")), false);
	}


	@Test
	public void testFillDeck(){
		Board board = new Board();
		board.makeDeck();
		assertTrue(board.getDeck().size() >=1);

	}
}
