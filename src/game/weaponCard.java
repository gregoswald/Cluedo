package game;

/**
 * This class represents a Weapon Card. 
 * It contains an ID pertaining to the Weapon type.
 * @author Jarred Hone
 *
 */
public class weaponCard implements Card{
	private String weaponID;
	public weaponCard(String id){
		this.weaponID = id;

	}
	/**
	 * Method to return which weapon type this is.
	 * @return Returns string containing weapon type id
	 */
	public String getWeaponType(){
		return weaponID;
	}
}
