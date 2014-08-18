package game;

public class roomCard implements Card{
private String roomID;
	public roomCard(String type){
	this.roomID = type;
	}
	
	
	
	/**
	 * @return String - returns string containing what type the room is
	 */
	public String getRoomID(){
		return roomID;
	}
}
