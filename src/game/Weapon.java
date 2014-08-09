package game;

/**
 * This class represents a physical Weapon object. 
 * It contains an ID pertaining to the Weapon type.
 * @author Jarred Hone
 *
 */
public class Weapon {
	private String weaponID;
	public Weapon(String id){
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
