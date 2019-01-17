import java.util.Arrays;
import java.util.Scanner;

public class PigLatinTranslator 
{
	public static void main(String[] args) {
	
		//Welcome user to PigLatin Translator program
		System.out.println("Welcome to PigLatin traslator!");	
		System.out.println("Please type something into the console.");
		
		//Take a string from the user
		Scanner reader = new Scanner(System.in);
		String inputstring = reader.nextLine().toLowerCase();
		String[] vowels = { "a", "e", "i", "o", "u" };
		
		//Check if the string starts with vowel
		CheckstringStartwithVowel(inputstring,vowels);
		//Check if the string starts with consonants and has vowel
		CheckstringStartswithConsonentContainsVowel(inputstring,vowels);
		//Check if the string starts with vowel
		CheckstringDontHaveVowel(inputstring,vowels);
		reader.close();
		
	}
	
	/*
	 * Takes the string and list of vowels and identifies if the string starts with vowel
	 */
	
	private static void CheckstringStartwithVowel(String inputstring, String[] vowels)
	{
		String appendstring="yay";
		for(String vowel : vowels)
		{			
			if(inputstring.startsWith(vowel))
			{
				String outputString=inputstring+appendstring;
				System.out.println("Output String which started with vowel is :"+ outputString);	
				break;
			}
		}		
	}
	
	/*
	 * Takes the string that starts with consonant and contains Vowel
	 */
	private static void CheckstringStartswithConsonentContainsVowel(String inputstring, String[] vowels)
	{
		String appendstring="ay";
		char[] inputcharacters=inputstring.toCharArray();
		if(!Arrays.asList(vowels).contains(inputstring.substring(0,1)))
		{
			for(char letter : inputcharacters)
			{
				String inputletter=Character.toString(letter);
				if(Arrays.asList(vowels).contains(inputletter))
				{		
					int indexoffirstvowel=inputstring.indexOf(inputletter);
					String prefix=inputstring.substring(0,indexoffirstvowel);
					String suffix=inputletter;
					if(indexoffirstvowel<inputstring.length()-1)
						suffix=suffix+inputstring.substring(indexoffirstvowel+1,inputstring.length());
					String outputString=suffix + prefix+ appendstring;
					System.out.println("Output String which started with consonent and has vowel is :"+ outputString);	
					break;
				}
			}	
		}
	}
	
	/*
	 * Takes the string that starts don't have vowel
	 */
	private static void CheckstringDontHaveVowel(String inputstring, String[] vowels)
	{
		String appendstring="ay";
		boolean vowelfound=false;
		String outputString=inputstring;
		char[] inputcharacters=inputstring.toCharArray();
		for(char letter : inputcharacters)
		{
			String inputletter=Character.toString(letter);
			if(Arrays.asList(vowels).contains(inputletter))
			{				
				vowelfound=true;	
				break;
			}
		}	
		if(!vowelfound)
		{
		outputString=inputstring+ appendstring;
		System.out.println("Output String if it contains an Vowel is :"+ outputString);		
		}					
			
	}

}
