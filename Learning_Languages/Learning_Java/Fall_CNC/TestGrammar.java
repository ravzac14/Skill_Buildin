//Zack Raver; ravzac14
//10/16/14

//This language is described by 1(01)*11

public class TestGrammar{
	
	public static boolean checkLang(String word){
		String myWord = word + 'A';
		if (myWord.charAt(0) == 49){
			String newWord = myWord.substring(1); 
			return (TestGrammar.checkABLoop(newWord));
		} else {
			return false;
		}
	}

	public static boolean checkABLoop(String smWord){
		
		if ((smWord.charAt(0) == 48) && (smWord.charAt(1) == 49)) {
			String newWord = smWord.substring(2);
			return (TestGrammar.checkABLoop(newWord));
		} else if ((smWord.charAt(0) == 49) && (smWord.charAt(1) == 49) && (smWord.charAt(2) == 65)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String word1 = "10111";
		String word2 = "10110";
		String word3 = "1010111";
		String word4 = "1010101";

		String[] words = {word1, word2, word3, word4};
		for (String i : words){
			System.out.println(TestGrammar.checkLang(i));
		}
		
	}

}
