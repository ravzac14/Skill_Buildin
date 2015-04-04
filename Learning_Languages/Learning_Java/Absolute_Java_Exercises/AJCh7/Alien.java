/*Zack Raver, ravzac14
 * 4/17/14
 * 
 * Ch.7 #3 from "Absolute Java" by Walter Savitch
 * Rewrite the following program to be more object-oriented and lose the "type" parameter; hide the instance variables and add a getDamage method to return them.
 * Rewrite the calculateDamage method to use getDamage and write a main method that tests the code
 */ 

public interface Alien {
	
	/* Just a template class for the actual Aliens 
	 * private int health;		//0=dead, 100=full strength
	 * private String name;
	 * private int damage;
	 */
	
	//Returns the damage that alien does, so that the damage of a pack of aliens can be determined
	public int getDamage();
	
	//Returns current health of the alien
	public int getHealth();
	
	//Returns the name of the alien
	public String getName();
	
	//Changes the health of the alien
	public void setHealth(int newHealth);
	
	//Changes the name of the alien
	public void setName(String newName);
	
	//Checks if the alien is alive, used by the AlienPack class to change the pack size
	public boolean isDead();
}
