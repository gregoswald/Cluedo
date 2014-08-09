package game;

/** Class to hold properties of the hidden cards, acts like the envelope would in the physical game
 * 
 * @author Jarred Hone
 *
 */
public class Envelope {
	private Card murderer;
	private Card murderWeapon;
	private Card murderRoom;
	
	public Envelope(Card inputMurderer, Card inputMurderWeapon, Card inputMurderRoom){ //TODO Possibly change these to a subtype of card so that it can check there is one of each better?
		this.murderer = inputMurderer;
		this.murderWeapon = inputMurderWeapon;
		this.murderRoom = inputMurderRoom;
	}
	
	
	/**
	 * Returns the Murderer Card, Just for checking at this point.
	 * @return Murderer Card
	 */
	public Card getMurderer(){
		return murderer;
	}
	
	/**
	 * Returns the Murder Weapon, Just for checking at this point.
	 * @return Murder Weapon Card
	 */
	public Card getMurderWeapon(){
		return murderWeapon;
	}
	
	/**
	 * Returns the Murder Room Card, Just for checking at this point
	 * @return Murderer Card
	 */
	public Card getMurderRoom(){
		return murderRoom;
	}
	
	
	
}
