/* Zack Raver, ravzac14
 * Type of alien, seperated for further differences to be made
 * This belongs to ch.7 #3; creates an object for a group of the other alien classes
 * Made when a pack gets 100(some large number) of marshmallows
 */

public class AlienGodmellow implements Alien{
	
	private int health;		//0=dead, 100=full strength
	private String name;
	private int damage;

	//No-arg (Initializes a standard AlienSnake and convenience constructors (for initializing a non-standard) for AlienSnake
	public AlienGodmellow(){
		this.health = 500;
		this.name = "GODMALLOW";
		this.damage = 50;
	}
	
	public AlienGodmellow(int health, String name, int damage){
		this.health = health;
		this.name = name;
		this.damage = damage;
	}
	
	//Returns the damage that alien does, so that the damage of a pack of aliens can be determined
	public int getDamage(){
		return damage;
	}
	
	//Returns current health of the alien
	public int getHealth(){
		return health;
	}
	
	//Returns the name of the alien
	public String getName(){
		return name;
	}
	
	//Changes the health of the alien
	public void setHealth(int newHealth){
		health = newHealth;
	}
	
	//Changes the name of the alien
	public void setName(String newName){
		name = newName;
	}
	
	//Checks if the alien is alive, used by the AlienPack class to change the pack size
	public boolean isDead(){
		if (health == 0){
			return true;
		}
		return false;
	}
}
