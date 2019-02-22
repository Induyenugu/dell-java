import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	//DEfine class variables
	private static String[][] board = { { "", "", "" }, { "", "", "" }, { "", "", "" } };
	private static String playerTurn = "X";
	private static boolean winner = false;
	private static Scanner reader = new Scanner(System.in);
	private static int row;
	private static int column;

	private static int[][][] horizonatalCombos = { { { 0, 0 }, { 0, 1 }, { 0, 2 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 } },
			{ { 2, 0 }, { 2, 1 }, { 2, 2 } } };
	private static int[][][] verticalcombos = { { { 0, 0 }, { 1, 0 }, { 2, 0 } }, { { 0, 1 }, { 1, 1 }, { 2, 1 } },
			{ { 0, 2 }, { 1, 2 }, { 2, 2 } }, };
	private static int[][][] diagnolCombos = { { { 0, 0 }, { 1, 1 }, { 2, 2 } }, { { 0, 2 }, { 1, 1 }, { 2, 0 } } };

	public static void main(String[] args) {

		System.out.println("Lets play Tic Tac Toe.");
		printBoard();
		
		//Loop through the board after every entry frm player until one player wins
		while (!winner) {
			System.out.println("Its " + playerTurn + "'s turn");
			System.out.println("Pick a row and column rows being 0, 1,2 and columns being 0,1,2");

			GetInputfromTicTacToe();

			PlayTicTacToe(row, column);

		}

		reader.close();

	}

	/**
	 * THis method gets input from user and asks him until he enters valid input
	 */
	
	private static void GetInputfromTicTacToe() {
		
		String rowinput = reader.nextLine().toLowerCase();
		rowinput = CheckValidInput(rowinput);
		row = Integer.parseInt(rowinput);
		String columninput = reader.nextLine().toLowerCase();
		columninput = CheckValidInput(columninput);
		column = Integer.parseInt(columninput);
		if (!PositionAvailable(row, column)) {
			System.out.println("Already the position at row " + row + " and column " + column
					+ " is filled> Please enter available position again");
			GetInputfromTicTacToe();
		}
	}

	/**
	 * THis method checks the input entered is valid or not and returns the valid input back for each player
	 */
	
	private static String CheckValidInput(String input) {
		if (!(input.equals("0") || input.equals("1") || input.equals("2"))) {
			System.out.println("Enter valid input");
			input = reader.nextLine().toLowerCase();
			CheckValidInput(input);
		}
		return input;

	}

	/**
	 * This method helps in printing the board
	 */
	private static void printBoard() {
		System.out.println("  0  1  2 ");
		System.out.println("0 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
		System.out.println("  ---------");
		System.out.println("1 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
		System.out.println("  ---------");
		System.out.println("2 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
	}

	/*
	 * * This method keeps players moves based on row and column entered
	 */
	private static void PlayTicTacToe(int row, int column) {
		board[row][column] = playerTurn;
		printBoard();
		if (checkForWin()) {
			winner = true;
			System.out.println("PLayer " + playerTurn + " won");
		} else {
			playerTurn = playerTurn == "X" ? "O" : "X";
		}

	}
	
	/*
	 * check all possible winning combinations to see if the player won or not
	 */

	private static boolean checkForWin() {
		for (int[][] winningcombo : horizonatalCombos) {
			if (board[winningcombo[0][0]][winningcombo[0][1]].equals(board[winningcombo[1][0]][winningcombo[1][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]]
							.equals(board[winningcombo[2][0]][winningcombo[2][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]].equals(playerTurn)) {
				return true;
			}
		}
		for (int[][] winningcombo : verticalcombos) {
			if (board[winningcombo[0][0]][winningcombo[0][1]].equals(board[winningcombo[1][0]][winningcombo[1][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]]
							.equals(board[winningcombo[2][0]][winningcombo[2][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]].equals(playerTurn)) {
				return true;
			}
		}
		for (int[][] winningcombo : diagnolCombos) {
			if (board[winningcombo[0][0]][winningcombo[0][1]].equals(board[winningcombo[1][0]][winningcombo[1][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]]
							.equals(board[winningcombo[2][0]][winningcombo[2][1]])
					&& board[winningcombo[0][0]][winningcombo[0][1]].equals(playerTurn)) {
				return true;
			}
		}

		return false;
	}
	
	/*
	 * //Checks if the input position provdied by the player is available or not
	 */	
	private static boolean PositionAvailable(int row, int column) {
		return (board[row][column] == null || board[row][column] == "");

	}

}
