/* Zack Raver, ravzac14
 * create a class DocumentFiles adds pathname. Text contents should be stored in text. Redefine toString
 * This belongs to Ch.7 #2 */

public class DocumentFiles extends Documents{
	
	/*Added pathname for DocumentFiles */
	private String pathname;
	
	/* No-arg and convenience constructors for DocumentEmails */
	public DocumentFiles(){
		super();
		this.pathname = "";
	}
	
	public DocumentFiles(String text, String pathname){
		super(text);
		this.pathname = pathname;
	}
	
	/*Accessor and mutator methods for recipients, sender and title from DocumentEmails (text is in Documents)*/
	public String getPathname(){
		return pathname;
	}
	
	public void setPathname(String newPathname){
		pathname = newPathname;
	}
	
	/* Overriding the toString from Documents */
	public String toString(Documents d1){
		return pathname + " " + d1.getText();
	}
}
