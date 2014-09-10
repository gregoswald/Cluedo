package game;

import java.util.ArrayList;
import java.util.List;

public class White implements Player {
	String playerName;
	List<Card> hand = new ArrayList<Card>();
	public String ID = "White";
	private Square playerPos;
	@Override
	public List<Card> gethand() {
		// TODO Auto-generated method stub
		return null;
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
