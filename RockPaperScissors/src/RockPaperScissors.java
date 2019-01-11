import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Take one word from User
		System.out.println("Lets play the game Rock Paper Scissor and you are player1");
		System.out.println("Please type one word from Rock Paper scissor");
		Scanner reader = new Scanner(System.in);
		String player1 = reader.nextLine().toLowerCase();	
		String[] gamearray= {"rock", "paper", "scissor"};
		//Generates random value for player2
		String player2=getPlayer2(gamearray);		
		
		System.out.println("Player1 entered "+ player1);
		System.out.println("Player2 entered "+ player2);
		
		//Check who is won and print
		System.out.println("Winner is "+ CheckWhoWon(player1, player2, gamearray));
		reader.close();

	}

	/*
	 * Get random word from rock paper scissor
	 */
	private static String getPlayer2(String[] gamearray)
	{
				
		Random r=new Random();
        int randomNumber=r.nextInt(gamearray.length);
		return gamearray[randomNumber];	
	}
	
	/*
	 * CHecks who is won
	 */
	private static String CheckWhoWon(String player1, String player2, String[] gamearray)
	{
		
		if(player1.equalsIgnoreCase(player2))
			return "draw";
		List<String> mylist = Arrays.asList(gamearray);
		if(mylist.contains(player1))
		{
			if(player1=="rock" && player2=="paper")
					return player2;
			if(player2=="rock" && player1=="paper")
				return player1;
			if(player1=="paper" && player2=="scissor")
				return player2;
			if(player2=="paper" && player1=="scissor")
				return player1;
			if(player1=="rock" && player2=="scissor")
				return player1;
			if(player2=="scissor" && player1=="rock")
				return player2;
			
		}
		//return player2 as won  if player1 enters a different word other than rock paper and scissor 
		return "player2";
		
	}
}
