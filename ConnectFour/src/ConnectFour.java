import java.util.Scanner;

/**
 * CS312 Assignment 10.
 *
 * On my honor, <Christopher Philip>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Section 5 digit ID: 52800
 *  Grader name: Eric
 *  Number of slip days used on this assignment: 2
 *  
 * Program that allows two people to play Connect Four.
 */


public class ConnectFour {

	// CS312 Students, add you constants here

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		intro();

		// complete this method
		String[][] game = createArray();
		playGame(game, keyboard);
		keyboard.close();
	}

//Method that creates the board
	public static String[][] createArray(){
		String[][] game = new String[6][7];

		for(int row = 0; row < game.length; row++){
			for(int column = 0; column < game[0].length; column++){
				game[row][column] = ".";
			}
		}
		return game;
	}
	
	
    //Method runs all methods for the game
	public static void playGame(String[][] game, Scanner keyboard){
		System.out.print("Player 1 enter your name: ");
		String player1 = keyboard.nextLine();
		System.out.print("Player 2 enter your name: ");
		String player2 = keyboard.nextLine();
		String chip1 = "r";
		String chip2 = "b";
		boolean win = false;
		while(!win){
			win = turns(player1, game, chip1, keyboard);
			if(win != true){
				win = turns(player2, game, chip2, keyboard);
			}
		}
	}

   //utilizes a count from the last player position to count above and below it
	//count increments each time a matching piece is found
	//if count = 4, a 4 pair has been matched and will return a true for the win
	public static Boolean RightDiag(String[][] game, String chip, String player, int choice, int rowpos){
		boolean win = false;
		int count = 0;
		int rowtemp = rowpos;
		int coltemp = choice;
		boolean breaks = false;
		while(rowtemp < 6 && coltemp > -1 && breaks == false && count != 4){
			//System.out.println("Row is: " + rowtemp + " " + "Col is: " + coltemp);
			if(game[rowtemp][coltemp] == chip)
				count++;
			else
				breaks = true;
			
			rowtemp ++;
			coltemp--;
		}
		rowtemp = rowpos - 1;
		coltemp = choice + 1;
		breaks = false;
		while(rowtemp > -1 && coltemp < 7 && breaks == false && count!= 4){
			//System.out.println("Row is: " + rowtemp + " " + "Col is: " + coltemp);
			if(game[rowtemp][coltemp] == chip)
				count++;
			else
				breaks = true;

			rowtemp --;
			coltemp++;
		}

		if(count == 4){
			win = true;		
			System.out.println(player + " wins!!");
			printBoardFinal(game);

		}
		return win;
	}

	public static Boolean LeftDiag(String[][] game, String chip, String player, int choice, int rowpos){
		boolean win = false;
		int count = 0;
		int rowtemp = rowpos;
		int coltemp = choice;
		boolean breaks = false;
		while(rowtemp < 6 && coltemp < 7 && breaks == false && count != 4){
			//System.out.println("Row is: " + rowtemp + " " + "Col is: " + coltemp);
			if(game[rowtemp][coltemp] == chip)
				count++;
			else
				breaks = true;

			rowtemp ++;
			coltemp++;

		}
		rowtemp = rowpos - 1;
		coltemp = choice - 1;
		breaks = false;
		while(rowtemp > -1 && coltemp > -1 && breaks == false && count!= 4){
			//System.out.println("Row is: " + rowtemp + " " + "Col is: " + coltemp);
			if(game[rowtemp][coltemp] == chip)
				count++;
			else
				breaks = true;

			rowtemp --;
			coltemp--;
		}

		if(count == 4){
			win = true;		
			System.out.println(player + " wins!!");
			printBoardFinal(game);

		}
		return win;
	}
	
     //simple method that turns the row the player was last on into a string
	//and then runs through to find a matching four pieces
	public static Boolean horizontalWin(String[][] game, String chip, String player){
		boolean win = false;
		int count = 0;
		String temp = "";
		for(int row = 0; row < game.length; row++){
			for(int col = 0; col < game[0].length; col++){
				temp += game[row][col];
			}
			if(temp.contains(chip+chip+chip+chip) && count == 0){
				win = true;		
				System.out.println(player + " wins!!");
				printBoardFinal(game);
				count++;
			}
		}
		return win;
	}
	
    //similar to the horizontal, except in the vertical direction
	public static Boolean verticalWin(String[][]game, String chip, String player, int choice){
		boolean win = false;
		String temp = "";
		for(int row = 0; row < game.length; row++){
			temp += game[row][choice];
		}
		if(temp.contains(chip+chip+chip+chip)){
			win = true;		
			System.out.println(player + " wins!!");
			printBoardFinal(game);
		}
		return win;
	}
     
	//final method that prints out the final board after a win is declared
	public static void printBoardFinal(String[][]game){
		System.out.println();
		System.out.println("Final Board");
		String columns = "1 2 3 4 5 6 7  column numbers";
		System.out.println(columns);
		for(int row = 0; row < game.length; row++){
			for(int column = 0; column < game[0].length; column++){
				System.out.print(game[row][column] + " ");
			}
			System.out.println();
		}
	}
	
     //method that scans the whole array to see if every spot has been filled
	public static Boolean draw(String[][] game){
		int count = 0;
		for(int row = 0; row < game.length; row++){
			for(int column = 0; column < game[0].length; column++){
				if(game[row][column] != ".")
					count++;
			}
		}
		if(count == (game.length * game[0].length)){
			System.out.println("This game is a draw.");
			printBoardFinal(game);
			return true;
		}
		else
			return false;
	}

   //increments the turns and checks every turn for a winner
	public static Boolean turns(String player, String[][] game, String chips, Scanner keyboard){
		boolean win = false;
		System.out.println();
		String columns = "1 2 3 4 5 6 7  column numbers";
		System.out.println("Current Board");
		System.out.println(columns);
		for(int row = 0; row < game.length; row++){
			for(int column = 0; column < game[0].length; column++){
				System.out.print(game[row][column] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(player + " it is your turn.");
		System.out.println("Your pieces are the " + chips + "'s.");
		System.out.print(player + ", enter the column to drop your checker: ");
		String prompt = player + ", enter the column to drop your checker: ";
		int choice = (getInt(keyboard, prompt)) - 1;
		boolean correct = false;
		while(!correct){
			if(choice >= 0 && choice <= 6){
				if(game[0][choice] != "."){
					System.out.println((choice + 1) + " is not a legal column. That column is full");
					System.out.print(player + ", enter the column to drop your checker: ");
					choice = (getInt(keyboard, prompt)) - 1;
				}
				else
					correct = true;
			}

			else{
				System.out.println(choice+1 + " is not a valid column.");
				System.out.print(player + ", enter the column to drop your checker: ");
				choice = (getInt(keyboard, prompt)) - 1;
			}
		}
		win = modifyBoard(choice, game, chips, player);
		return win;
	}

   //method that modifies the board based on player input, and what is already in the board
	public static Boolean modifyBoard(int choice, String[][] game, String chips, String player){
		int rowpos = 0;
		boolean win = false;
		for(int i = game.length-1; i >= 0; i--){
			if(game[i][choice] == "."){
				rowpos = i;
				game[i][choice] = chips;
				i = -1;
			}
		}
		//Sends in the current board and player location to determine either a win, or a draw, or neither and 
		//continues game
		win = verticalWin(game, chips, player, choice);
		if(win == false)
			win = horizontalWin(game, chips, player);
		if(win == false)
			win = draw(game);
		if(win == false)
			win = RightDiag(game, chips, player, choice, rowpos);
		if(win == false)
			win = LeftDiag(game, chips, player, choice, rowpos);

		return win;
	}



	// show the intro
	public static void intro() {
		System.out.println("This program allows two people to play the");
		System.out.println("game of Connect four. Each player takes turns");
		System.out.println("dropping a checker in one of the open columns");
		System.out.println("on the board. The columns are numbered 1 to 7.");
		System.out.println("The first player to get four checkers in a row");
		System.out.println("horizontally, vertically, or diagonally wins");
		System.out.println("the game. If no player gets fours in a row and");
		System.out.println("and all spots are taken the game is a draw.");
		System.out.println("Player one's checkers will appear as r's and");
		System.out.println("player two's checkers will appear as b's.");
		System.out.println("Open spaces on the board will appear as .'s.\n");
	}


	//prompt the user for an int. The String prompt will
	// be printed out. I expect key is connected to System.in.
	public static int getInt(Scanner keyboard, String prompt) {

		while(!keyboard.hasNextInt()) {
			String notAnInt = keyboard.nextLine();
			System.out.println(notAnInt + " is not an integer.");
			System.out.print(prompt);
		}
		int result = keyboard.nextInt();
		keyboard.nextLine();
		return result;
	}
}