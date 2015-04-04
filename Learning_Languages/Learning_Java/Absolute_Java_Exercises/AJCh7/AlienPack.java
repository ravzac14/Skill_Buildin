/* Zack Raver, ravzac14
 * This belongs to ch.7 #3; creates an object for a group of the other alien classes
 * Manages mobs of aliens; 
 * 	Includes killing them or merging them
 * 
 * POSSIBLY HAVE THE MOBS FIGHT TO THE DEATH, SURRENDER IS AN OPTION TO MERGE PACKS
 * MAYBE HAVE THEM AUTOMATED
 * 
 * Maybe add a convert units method (100 marshmallows -> godunit)?
 */
public class AlienPack {
	
	/*Adds instance variable for the pack calls aliens */ 
	private Alien[] aliens;
	
	/*Convenience constructor for AlienPack TAKES IN THE NUMBER OF ALIENS*/
	//There is no no-arg constructor because cannot make a default pack size
	public AlienPack(int numAliens){
		aliens = new Alien[numAliens];
	}
	
	/*Adds an alien to the pack (CANNOT GROW THE PACK, JUST FILLS IN THE SPECIFICS) */
	public void addAlien(Alien newAlien, int index) {
		aliens[index] = newAlien;
	}
	
	/*Returns the aliens array */
	public Alien[] getAliens(){
		return aliens;
	}
	
	/*Returns a new, merged array from a surrendered encounter */
	public static AlienPack mergePacks(AlienPack p1, AlienPack p2){
		AlienPack p3 = p1.checkForDead().checkForGod();
		AlienPack p4 = p2.checkForDead().checkForGod();			//Culls the dead aliens from the pack before the merge
		AlienPack newPack = new AlienPack(p3.getAliens().length + p4.getAliens().length);	//Creates a new pack of the same length as the two packs combined
		System.out.println("Created a new pack of " + (p3.getAliens().length + p4.getAliens().length) + " blood-thirsty aliens!");
		int temp = 0;		//Holds the place in the new array after the first pack is appended
		
		for (int l=0; l<p3.getAliens().length; l++){
			newPack.addAlien(p3.getAliens()[l], l);
			temp++;
		}
		for (int m=0; m<p4.getAliens().length; m++){
			newPack.addAlien(p4.getAliens()[m], temp);
			temp++;
		}
		return newPack;
	}
	
	/*Returns a new array minus the dead aliens */
	public AlienPack checkForDead(){
		int count = aliens.length;		//To set the size of the new AlienPack
		int temp = 0; 					//Holds the place of the new array as we rotate the old array
		
		for (int j=0; j<aliens.length; j++){
			if (aliens[j].isDead()){
				System.out.println("An alien has died...");
				aliens[j] = null;
				count --;
			}
		}
		
		AlienPack newAliens = new AlienPack(count);	//Initializing the new AlienPack
		for (int k=0; k<aliens.length; k++){
			if (aliens[k] != null){
				newAliens.addAlien(aliens[k], temp);
				temp++;
			}
		}
		return newAliens;
	}
	
	/*Returns a new array after converting 40 (placeholder for real #) marshmallows into a Godmallow */
	public AlienPack checkForGod(){
		int marshCount = 0;
		int godCount = 0;
		int newSize = aliens.length;
		int temp = 0;
		
		//Finds the # of marshmallows in the pack
		for (int t = 0; t < aliens.length; t++){
			if (aliens[t].getName().equalsIgnoreCase("Marshmallow")){
				marshCount++;
			}
			if (marshCount == 40){									//THIS IS WHERE TO CHANGE THE CONVERSION RATE FROM MARSHMALLOWS TO GODS!!!!******************************
				godCount++;
				marshCount = 0;
			}
		}
		
		//Replaces 100 marshmallows with 99 nulls and 1 godmallow
		godCount = godCount * 40;
		for (int g = 0; g < aliens.length; g++){
			if ((aliens[g].getName().equalsIgnoreCase("Marshmallow")) && (godCount != 0) && (godCount % 40 == 0)){
				aliens[g] = new AlienGodmellow();
				System.out.println("40 Marshmallows have grouped to form a GODMALLOW! FEAR THE GODMALLOW!");
				godCount--;
			} else if ((aliens[g].getName().equalsIgnoreCase("Marshmallow")) && (godCount != 0) && (godCount % 40 != 0)){
				aliens[g] = null;
				godCount--;
				newSize--;
			} 
		}
		
		//Makes new array of new size and old aliens
		AlienPack newAliens = new AlienPack(newSize);	//Initializing the new AlienPack
		for (int a=0; a<aliens.length; a++){
			if (aliens[a] != null){
				newAliens.addAlien(aliens[a], temp);
				temp++;
			}
		}
		return newAliens;
	}
	
	/*Returns the total damage of that pack */
	public int calculateDamage() {
		int damage = 0;
		for (int i=0; i<aliens.length; i++) {
			damage += aliens[i].getDamage();		
		}
		return damage;
	}
}