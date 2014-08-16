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
		LOUNGE,STUDY,LIBRARY,CELLAR,HALL,BILLIARDROOM,BALLROOM,KITCHEN,CONSERVATORY,DININGROOM,FLOOR,PORTAL,DOOR,BORDER,ROOM, WALL, PIECE, 
		PLUM, SCARLETT, MUSTARD, PEACOCK, GREEN, WHITE
	}

	
}
