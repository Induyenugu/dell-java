import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {

	static String fileName = "WordsList.txt";
	private static List<String> filewords = new ArrayList<String>();
	private static Scanner reader = new Scanner(System.in);
	static boolean guessedrightletterFlag, wordguessed = false;
	private static char[] hiddencharArray;
	private static StringBuilder wrongletterbuilder;
	static String wordtobeGuessed, hiddenword = "";
	static int maxattempts, userattempts, wrongattempts = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Lets play word guessing Game");
		// read the words from file
		ReadAllWordsfromFile();

		// pick a random word from the dictionary of words
		wordtobeGuessed = GetRandomWord();
		System.out.println(wordtobeGuessed); // for testing purpose

		// Restrict the no of attempts to double the length of word
		maxattempts = 2 * wordtobeGuessed.length();

		// Get Hidden word from actual word
		hiddenword = GetHiddenWord(wordtobeGuessed);
		System.out.println("Hidden Word to be guessed is " + hiddenword);
		System.out.println("You have " + maxattempts + " to guess the word");
		hiddencharArray = hiddenword.toCharArray();
		wrongletterbuilder= new StringBuilder();
		

		// Loops until user guess the complete word or reaches max attempts to guess
		while (!wordguessed && maxattempts > 0) {
			maxattempts--;
			userattempts++;
			guessedrightletterFlag = false;
			System.out.println("Guess a letter");
			String input = reader.nextLine().toLowerCase();
			char inputLetter = VerifyandGetRightInput(input);
			wordguessed = SolveWordwithGuessedLetter(inputLetter, wordtobeGuessed);

		}

	}
	
	/**
	 * Reads all words from file
	 */
	private static void ReadAllWordsfromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String word;
			while ((word = br.readLine()) != null) {
				filewords.add(word);
			}
			br.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	

	/**
	 *Gets Random word from the list
	 */
	private static String GetRandomWord() {
		int wordscount = filewords.size();
		Random rand = new Random();
		int randindex = rand.nextInt(wordscount);
		return filewords.get(randindex);

	}


	/**
	 * Validates the user input
	 * @param input from user
	 * @returns the input character to be solved to guess the word
	 */
	private static char VerifyandGetRightInput(String input) {
		if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
			System.out.println("Enter only letter");
			input = reader.nextLine().toLowerCase();
			VerifyandGetRightInput(input);
		}
		return input.charAt(0);

	}

	/**
	 *Returns Hidden word to guess from the actual word
	 */
	private static String GetHiddenWord(String wordtobeGuessed) {
		StringBuilder wordbuilder = new StringBuilder();
		for (int i = 0; i < wordtobeGuessed.length(); i++) {
			wordbuilder.append("-");
		}
		return wordbuilder.toString();
	}

	/**
	 * Solves the word based on input and returns true if the word is completely solved
	 * @param input letter provided b user and the actual word
	 */
	private static boolean SolveWordwithGuessedLetter(char inputLetter, String actualword) {
		int index = actualword.indexOf(inputLetter);

		while (index >= 0) {
			guessedrightletterFlag = true;
			hiddencharArray[index] = inputLetter;
			index = wordtobeGuessed.indexOf(inputLetter, index + 1);
		}
		hiddenword = String.valueOf(hiddencharArray);
		if (hiddenword.indexOf("-") < 0) {
			System.out.println("Congratulations!!, You Solved the word completely : " + hiddenword + " in " + userattempts + " attempts");
			return true;

		} else if (guessedrightletterFlag) {
			System.out.println("You guess is right and here is the updated hidden word : " + hiddenword);
		} else {
			wrongattempts++;
			wrongletterbuilder.append(inputLetter+" , ");
			System.out.println("You guess is wrong and you made "+ wrongattempts +" wrong attempts out of total attempts: "+ maxattempts);
			System.out.println("Total wrong inputs entered "+wrongletterbuilder);
		}
		if (maxattempts == 0) {
			System.out.println("You reached the Maxattemmpts " + (2 * actualword.length())
					+ " to guess and couldn't guess the word : " + actualword);
		}
		return false;

	}

}
