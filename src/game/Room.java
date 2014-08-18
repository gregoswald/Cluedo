package game;

import java.util.ArrayList;

public class Room {
	private ArrayList<Square> squares;//i forgot were i was going with this
	//private Weapon weapon;
	Type roomID;

	public Room(){
		//this.roomID = Identifier;
	}
	public enum Type{
		STUDY, HALL, LOUNGE, DININGROOM, KITCHEN, BALLROOM, CONSERVATORY, LIBRARY, BILLIARDROOM
	}
	public ArrayList<Square> getSquare(int index) {
		return squares;
	}
	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}
	//public Weapon getWeapon() {
	//	return weapon;
	//}
	//public void setWeapon(Weapon weapon) {
	//	this.weapon = weapon;
	//}

}
