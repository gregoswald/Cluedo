package game;

import java.util.ArrayList;
import java.util.List;

public class Peacock implements Player {
	private String playerName;
	private Square playerPos;
	public String ID = "Peacock";
	List<Card> hand = new ArrayList<Card>();
	@Override
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

	@Override
	public String getID() {
		return ID;
	}
}
