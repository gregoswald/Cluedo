package game;

public class playerCard implements Card {
	String playerID;
	public playerCard(String playerIDInput){
	this.playerID = playerIDInput;
	}
	
	
	/**
	 * 
	 * @return returns String containing Player ID
	 */
	
	public String getPlayerID(){
	return this.playerID;
	}
	
	

}
