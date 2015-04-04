/* Zack Raver, ravzac14
 * THIS IS A TEST CLASS
 * This belongs to ch.7 #3; creates an object for a group of the other alien classes
 */
public class AlienTest {

	public static void main(String[] args) {
		//Creating some Aliens to add to AlienPack1
		AlienSnake as1 = new AlienSnake();
		System.out.printf("The damage on %s is %d!\n", as1.getName(), as1.getDamage());
		AlienOgre ao1 = new AlienOgre();
		System.out.printf("The damage on %s is %d!\n", ao1.getName(), ao1.getDamage());
		AlienMarshmallow am1 = new AlienMarshmallow();
		System.out.printf("The damage on %s is %d!\n", am1.getName(), am1.getDamage());
		
		//Creating some Aliens for AlienPack2
		AlienOgre ao2 = new AlienOgre();
		System.out.printf("The damage on %s is %d!\n", ao2.getName(), ao2.getDamage());
		AlienMarshmallow am3 = new AlienMarshmallow();
		System.out.printf("The damage on %s is %d!\n", am3.getName(), am3.getDamage());
		AlienMarshmallow am4 = new AlienMarshmallow();
		System.out.printf("The damage on %s is %d!\n", am4.getName(), am4.getDamage());
		AlienMarshmallow am5 = new AlienMarshmallow();
		System.out.printf("The damage on %s is %d!\n", am5.getName(), am5.getDamage());
		
		//Creating a new AlienPack from Aliensp1
		AlienPack ap1 = new AlienPack(3);
		ap1.addAlien(as1, 0);
		ap1.addAlien(ao1, 1);
		ap1.addAlien(am1, 2);
		System.out.printf("%s, %s, and %s joined up to make a new Alien Pack!\n", as1.getName(), ao1.getName(), am1.getName());
		
		//Creating a new AlienPack from Aliensp2
		AlienPack ap2 = new AlienPack(4);
		ap2.addAlien(ao2, 0);
		ap2.addAlien(am5, 1);
		ap2.addAlien(am3, 2);
		ap2.addAlien(am4, 3);
		System.out.printf("%s, %s, %s, and %s joined up to make a new Alien Pack!\n", ao2.getName(), am3.getName(), am4.getName(), am5.getName());
		
		//Testing the calculateDamage method 
		System.out.println("Pack 1 does " + ap1.calculateDamage() + " damage!");
		System.out.println("Pack 2 does " + ap2.calculateDamage() + " damage!");
		
		//Testing out killing some Aliens
		ap1.getAliens()[1].setHealth(0);
		ap2.getAliens()[2].setHealth(0);
		ap2.getAliens()[3].setHealth(5);
		
		//Testing out merging Pack 1(ap1) and Pack2(ap2)
		AlienPack ap5 = AlienPack.mergePacks(ap1, ap2);
		for (int i = 0; i < ap5.getAliens().length; i++){
			System.out.printf("The damage on %s is %d!\n", ap5.getAliens()[i].getName(), ap5.getAliens()[i].getDamage());
		}
		
		//Testing out the checkForGod method
		AlienPack ap6 = new AlienPack(120);
		for (int y = 0; y < ap6.getAliens().length; y++){
			ap6.addAlien(new AlienMarshmallow(), y);
		}
		AlienPack ap7 = AlienPack.mergePacks(ap5, ap6);
		System.out.println("Alien pack 7 does " + ap7.calculateDamage() + " damages!");
	}

}
