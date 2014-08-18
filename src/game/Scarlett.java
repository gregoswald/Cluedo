package game;

import java.util.ArrayList;
import java.util.List;

public class Scarlett implements Player {
	String playerName;
	private Square playerPos;
	List<Card> hand = new ArrayList<Card>();

	
	public List<Card> gethand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPlayerName(String name) {
		playerName = name;

	}
	public void setPos(Square sq){
		playerPos = sq;
	}
	public void getPos(Square sq){
		playerPos = sq;
	}
}
