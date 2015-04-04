
public class SpiderSong {
	
	static void firstLine(String animal){
		String temp = "There was an old woman who swallowed a " + animal + ",";
		System.out.println(temp);
	}
	
	static void finalLines(){
		String temp = "I don't why she swallowed the fly,\nPerhaps she'll die.\n";
		System.out.println(temp);
	}
	
	static void swallowLine(String swAnim, String caAnim){
		String temp = "She swallowed the " + swAnim + " to catch the " + caAnim + ",";
		System.out.println(temp);
	}
	
	public static void main (String[] args){
		
		String[] animalList = new String[7]; 
		animalList[0] = "fly"; 
		animalList[1] = "spider"; 
		animalList[2] = "bird";
		animalList[3] = "cat"; 
		animalList[4] = "dog";
		animalList[5] = "dragon"; 
		animalList[6] = "dragon-eating horse";
		
		String[] verseList = new String[7];
		verseList[0] = null;
		verseList[1] = "That wriggled and iggled and jiggled inside her,";
		verseList[2] = "How absurd to swallow a bird,";
		verseList[3] = "Imagine that to swallow a cat,";
		verseList[4] = "What a hog to swallow a dog,";
		verseList[5] = "She ditched the wagon to swallow a dragon,";
		verseList[6] = "She died of course.";
		
		for(int i = 0; i < 7; i++){
			if(animalList[i] == "fly"){
				SpiderSong.firstLine(animalList[i]);
				SpiderSong.finalLines();	
			}
			else if(animalList[i] == "dragon-eating horse"){
				SpiderSong.firstLine(animalList[i]);
				System.out.println(verseList[i]);
			}
			else{
				SpiderSong.firstLine(animalList[i]);
				System.out.println(verseList[i]);
				for(int j = i; j > 0; j--){
					SpiderSong.swallowLine(animalList[j], animalList[j-1]);
				}
				SpiderSong.finalLines();
			}
		}
	}
	
}
