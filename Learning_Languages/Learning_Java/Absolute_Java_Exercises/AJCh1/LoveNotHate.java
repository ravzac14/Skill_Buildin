/*Zack Raver; ravzac14
 * 4/5/14
 * 
 * Ch.1 #5 from "Absolute Java" by Walter Savitch
 * Parse several lines of text, repeat any lines with the word "hate"
 * Replace each instance of "hate with "love " and output the new lines
 * ie("I saw you wrote the line:
 * 	   I replaced it with the line: "
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class LoveNotHate {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean end = true; 
		String tempLine;
		
		System.out.println("Go ahead and write me a poem about love and hate! I will critique it...Write \"end\" when you\'re ready to see my critique");
		while (end){
			tempLine = s.nextLine();
			StringTokenizer punch = new StringTokenizer(tempLine);
			while (punch.hasMoreTokens()){
				if (punch.nextToken().equalsIgnoreCase("hate")){
					System.out.println("I saw that you wrote the line: " + tempLine);
					System.out.println("I've changed that to: ");
					while  (punch.hasMoreTokens()){
						if (punch.nextToken().equalsIgnoreCase("hate")){
							System.out.print("love ");
						} else { 
							System.out.print(punch.nextToken() + " ");
						} 
						continue;
					}
				} else if (punch.nextToken().equalsIgnoreCase("end")) {
					end = false;
				} else {
					continue;
				}
			}
		}
		s.close();
	}

}
