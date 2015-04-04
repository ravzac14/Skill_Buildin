/* Zack Raver, ravzac14
 * THIS IS A TEST CLASS
 * This belongs to Ch.7 #2 */

public class DocumentsTest {

 	public static boolean containsKeyword(Documents docObject, String keyword) {
 		
 		if (docObject.toString().indexOf(keyword,0) >= 0){
	   		return true;
		}
	   	return false;
	 }
	
	public static void main(String[] args) {
		Documents d1 = new Documents();
		d1.setText("This is the text");
		Documents d2 = new Documents("This is the text two");
		DocumentEmails d3 = new DocumentEmails();
		d3.setText("This is the text three");
		d3.setSender("Bob");
		d3.setRecipients("Tom Mary DICK");
		d3.setTitle("IHAVEDICKCANCER");
		DocumentEmails d4 = new DocumentEmails("This is the text four", "TIm", "JOB", "IGOTLEGS");
		DocumentFiles d5 = new DocumentFiles();
		d5.setText("This is the text five");
		d5.setPathname("~/Documents/");
		DocumentFiles d6 = new DocumentFiles("This is the text six", "~/Downloads");
		
		//These must all print true for the toString's to be valid for those classes
		System.out.println(DocumentsTest.containsKeyword(d1, "This"));
		System.out.println(DocumentsTest.containsKeyword(d2, "This"));
		System.out.println(DocumentsTest.containsKeyword(d3, "This"));
		System.out.println(DocumentsTest.containsKeyword(d4, "This"));
		System.out.println(DocumentsTest.containsKeyword(d5, "This"));
		System.out.println(DocumentsTest.containsKeyword(d6, "This"));
	}

}
