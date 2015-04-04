/* Zack Raver,ravzac14
 * belongs to the ch.8 #2 project in "Absolute Java"
 */
 
 public class MovieAction extends Movie{
	 
	 //Default, copy, and convenience constructors for MovieAction
	 public MovieAction(){
		 super();
	 }
	 
	 public MovieAction(MovieAction anActionMovie){
		 super(anActionMovie);
	 }
	 
	 public MovieAction(String rating, int id, String title){
		 super(rating, id, title);
	 }
	 
	//calcLateFees takes how long in days a movie has been rented, returns the late fees...default value is $3.00/day
	public float calcLateFees(int daysOut){
		return (float)(daysOut * 3.00F);
	}
}
