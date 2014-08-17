package game;

import java.util.ArrayList;

public class Room {
	private ArrayList<Square> squares;
	private Weapon weapon;
	Type roomID;

	public Room(){
		//this.roomID = Identifier;
	}
	public enum Type{
		STUDY, HALL, LOUNGE, DININGROOM, KITCHEN, BALLROOM, CONSERVATORY, LIBRARY, BILLIARDROOM
	}

}
