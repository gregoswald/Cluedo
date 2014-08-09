package game;

public class Room {
Type roomID;

	
public Room(Type Identifier){
	this.roomID = Identifier;
	
	
}

public enum Type{
	STUDY, HALL, LOUNGE, DININGROOM, KITCHEN, BALLROOM, CONSERVATORY, LIBRARY, BILLIARDROOM
}

}
