/*Zack Raver, ravzac14
 * 5/8/14
 * This holds the instance for the wall pieces (those that cannot be passed or eaten)
 * Maybe in the future they can be broken
 */

public class PPWall extends PPOrganism{

	public PPWall(){
		this.moveCount = 0;
		this.image = '|';
		this.xPos = 0;
		this.yPos = 0;
	}
	
	public PPWall(int newX, int newY){
		this.moveCount = 0;
		this.image = '|';
		this.xPos = newX;
		this.yPos = newY;
	}
	
	public void move(int[] coord){
		System.out.println("THIS SHOULDN\'T HAPPEN!");
	}
	
	public PPOrganism breed(){
		return new PPWall();
	}
	
	public void checkBreed(){
		System.out.println("THIS SHOULDN\'T HAPPEN!");
	}
}
