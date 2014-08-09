package game;

public class Room {
Type roomID;
int x;
int y;
	
public Room(Type Identifier, int x , int y){
	this.roomID = Identifier;
	this.x = x;
	this.y = y;
	
}

public enum Type{
	STUDY, HALL, LOUNGE, DININGROOM, KITCHEN, BALLROOM, CONSERVATORY, LIBRARY, BILLIARDROOM
}

}
