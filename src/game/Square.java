package game;
/**
 * Can hold one of several different types - Player Piece, Room, Portal
 *TODO add enum types for each different possible type
 * @author syaz
 *
 */
public class Square {
private Player occupied;
Type identifier;
	public Square(Type Identifier){
		this.identifier = Identifier;
	}

public Type getID(){
	return identifier;
}
	
	public enum Type{
		LOUNGE,STUDY,LIBRARY,CELLAR,HALL,BILLIARDROOM,BALLROOM,KITCHEN,CONSERVATORY,DININGROOM,FLOOR,PORTAL,DOOR,BORDER, WALL, 
		PLUM, SCARLETT, MUSTARD, PEACOCK, GREEN, WHITE
	}

	public Player getOccupied() {
		return occupied;
	}

	public void setOccupied(Player occupied) {
		this.occupied = occupied;
	}

	
}
