/* Zack Raver, ravzac14
 * create a class DocumentEmails that adds recipients, sender, title; Set the text to the body of the email. Redefine the toString
 * This belongs to Ch.7 #2 */

public class DocumentEmails extends Documents{
	
	/* Added recipients, sender and title */
	private String recipients;
	private String sender;
	private String title;
	
	/* No-arg and convenience constructors for DocumentEmails */
	public DocumentEmails(){
		super();
		this.recipients = "";
		this.sender = "";
		this.title = "";
	}
	
	public DocumentEmails(String text, String recipients, String sender, String title){
		super(text);
		this.recipients = recipients;
		this.sender = sender;
		this.title = title;
	}
	
	/*Accessor and mutator methods for recipients, sender and title from DocumentEmails (text is in Documents)*/
	public String getRecipients(){
		return recipients;
	}
	
	public void setRecipients(String newRecipients){
		recipients = newRecipients;
	}
	public String getSender(){
		return sender;
	}
	
	public void setSender(String newSender){
		sender = newSender;
	}
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	/* Overriding the toString from Documents */
	public String toString(Documents d1){
		return title + " " + sender + " " + recipients + " " + d1.getText();
	}
}
