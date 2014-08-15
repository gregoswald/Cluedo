package game;
/**
 * Can hold one of several different types - Player Piece, Room, Portal
 *TODO add enum types for each different possible type
 * @author syaz
 *
 */
public class Square {

Type identifier;
	public Square(Type Identifier){
		this.identifier = Identifier;
	}

public Type getID(){
	return identifier;
}
	
	public enum Type{
		ROOM, PORTAL, FLOOR, WALL, PIECE, STUDY, HALL, DOOR, LOUNGE, LIBRARY, CELLAR, DININGROOM,
		BILLIARDROOM, BALLROOM, KITCHEN, CONSERVATORY, PLUM, SCARLETT, MUSTARD, PEACOCK, GREEN, WHITE
	}

	
}
