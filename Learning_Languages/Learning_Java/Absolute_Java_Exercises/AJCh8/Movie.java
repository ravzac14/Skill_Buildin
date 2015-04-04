/* Zack Raver, ravzac14
 * 4/26/14
 * from Ch.8 #2 "Absolute Java" by Walter Savitch
 * Create a class named Movie (MPAA rating[G,PG,PG-13,R],ID #, title) with accessor/mutator methods. Make equals() (that overrides Object's equals()) two movies == if their ID # is equal
 * 	make 3 more classes Action,Comedy,Drama with calcLateFees takes in # of days late and returns a late fee
 * 		movie=$2/day, action $3/day, dramas $2/day, comedy $2.5/day
 */
public class Movie {

	//MPAA Rating system in an array	   0     1      2       3      4
	public final String[] MPAA_RATINGS = {"G", "PG", "PG-13", "R", "NR-17"};
	
	//Instance variables for all movies
	private String MPAARating;
	private int IDNumber;
	private String title;
	
	//Default, copy, and convenience constructors for Movie
	public Movie(){
		this.MPAARating = null;
		this.IDNumber = 0;
		this.title = "";
	}
	
	public Movie(Movie aMovie){
		this.MPAARating = aMovie.getMPAARating();
		this.IDNumber = aMovie.getIDNumber();
		this.title = aMovie.getTitle();
	}
	
	public Movie(String rating, int id, String title){
		this.MPAARating = rating;
		this.IDNumber = id;
		this.title = title;
	}
	
	//Accessor and mutator methods for Movie
	public void setMPAARRating(String newRating){
		MPAARating = newRating;
	}
	
	public String getMPAARating(){
		return MPAARating;
	}
	
	public void setIDNumber(int newId){
		IDNumber = newId;
	}
	
	public int getIDNumber(){
		return IDNumber;
	}
	
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	public String getTitle(){
		return title;
	}
	
	//equals() to check if two movies have the same IDNumber
	public boolean equals(Movie otherMovie){
		if(this.IDNumber == otherMovie.IDNumber){
			return true;
		}
		return false;
	}
	
	//calcLateFees takes how long in days a movie has been rented, returns the late fees...default value is $2.00/day
	public float calcLateFees(int daysOut){
		return (float)(daysOut * 2.00F);
	}
}
