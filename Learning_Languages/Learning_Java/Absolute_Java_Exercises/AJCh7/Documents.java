/* Zack Raver, ravzac14
 * 4/17/14
 * 
 * Ch.7 #2 from "Absolute Java" by Walter Savitch
 * Create a class Documents that has instance variable text, include toString and setters
 * 	create a class DocumentEmails that adds recipients, sender, title; Set the text to the body of the email. Redefine the toString
 * 	create a class DocumentFiles adds pathname. Text contents should be stored in text. Redefine toString
 * 		test by calling several objects and passing them through
 * 
 * 	public static boolean ContainsKeyword(Document docObject, String keyword)
 *  {
 *  	if (docObject.toString().indexOf(keyword,0) >= 0)_
 *  		return true;
 *  	}
 *  	return false;
 *  }
 */

public class Documents {

	/*text stores the test of the document */
	private String text;
	
	/*These are the no-arg and convenience constructors for Documents */
	public Documents(){
		this.text = "";
	}
	
	public Documents(String text){
		this.text = text;
	}
	
	/*Accessor and mutator methods for text from Documents*/
	public String getText(){
		return text;
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	/*The toString for Documents*/
	public String toString(){
		return text;
	}
}
