/* Zack Raver,ravzac14
 * belongs to the ch.8 #2 project in "Absolute Java"
 */
 
 public class MovieDrama extends Movie{
	 
	 //Default, copy, and convenience constructors for MovieAction
	 public MovieDrama(){
		 super();
	 }
	 
	 public MovieDrama(MovieDrama aDramaMovie){
		 super(aDramaMovie);
	 }
	 
	 public MovieDrama(String rating, int id, String title){
		 super(rating, id, title);
	 }
	 
	//calcLateFees takes how long in days a movie has been rented, returns the late fees...default value is $2.00/day
	public float calcLateFees(int daysOut){
		return (float)(daysOut * 2.00F);
	}
}