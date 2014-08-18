package game;

import java.util.ArrayList;
import java.util.List;

public class Peacock implements Player {
	private String playerName;
	List<Card> hand = new ArrayList<Card>();
	@Override
	public List<Card> gethand() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPlayerName(String name) {
		playerName = name;
		
	}
}
