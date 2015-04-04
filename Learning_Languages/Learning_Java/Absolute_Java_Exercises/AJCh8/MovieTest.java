/* Zack Raver,ravzac14
 * THE TEST CLASS FOR MOVIE
 * belongs to the ch.8 #2 project in "Absolute Java"
 */
public class MovieTest {

	public static void main(String[] args) {
		
		Movie[] m = new Movie[12];
		int daysLate = 5;
		
		//Creating some Movie, MovieAction, MovieDrama, and MovieComedy objects in the Movies Array, some from copy constructors
		m[0] = new Movie();
		m[1] = new Movie("PG", 12, "SATANS LEG");
		m[2] = new Movie(m[0]);
		
		m[3] = new MovieAction();
		m[4] = new MovieAction("R", 14, "Dance with death");
		m[5] = new MovieAction((MovieAction)m[3]);
		
		m[6] = new MovieDrama();
		m[7] = new MovieDrama("NR-17", 22, "Kiss me or Ill cry");
		m[8] = new MovieDrama((MovieDrama)m[6]);
		
		m[9] = new MovieComedy();
		m[10] = new MovieComedy("PG-13", 17, "LAUGHRIGHTNOW");
		m[11] = new MovieComedy((MovieComedy)m[9]);
		
		//Testing calcLateFees for each Movie
		for (Movie mov : m){
			System.out.println("The late fees for that movie is " + mov.calcLateFees(daysLate));
		}
		
		//Testing the equals for each type of Movie...should print out 4 true's
		System.out.println("Works if each of the following 4 lines say \"true\"");
		System.out.println(m[0].equals(m[2]));
		System.out.println(m[3].equals(m[5]));
		System.out.println(m[6].equals(m[8]));
		System.out.println(m[9].equals(m[11]));
	}
}
