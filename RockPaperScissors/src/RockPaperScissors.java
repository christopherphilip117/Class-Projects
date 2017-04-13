import java.util.Scanner;

/**
 * CS312 Assignment 4.
 * 
 * On my honor, <Christopher Philip>, this programming assignment is my own work
 * and I have not shared my solution with any other student in the class.
 *
 * A program to play Rock Paper Scissors
 *
 * email address: christopher.philip117@gmail.com UTEID: cp26645 Unique 5 digit
 * course ID: 52800 Grader name: Eric Number of slip days used on this
 * assignment: 0
 */

public class RockPaperScissors {

	/*
	 * A program to allow a human player to play rock - paper - scissors against
	 * the computer. If args.length != 0 then we assume the first element of
	 * args can be converted to an int
	 */
	public static void main(String[] args) {
		RandomPlayer computerPlayer = buildRandomPlayer(args);
		game(computerPlayer);

	}
	/*
	 * Build the random player. If args is length 0 then the default
	 * RandomPlayer is built that follows a predictable sequence. If args.length
	 * > 0 then we assume we can convert the first element to an int and build
	 * the RandomPlayer with that initial value.
	 */
	public static RandomPlayer buildRandomPlayer(String[] args) {
		if (args.length == 0) {
			return new RandomPlayer();
		} else {
			int seed = Integer.parseInt(args[0]);
			return new RandomPlayer(seed);
		}
	}
	public static void game(RandomPlayer computerPlayer) {

		Scanner console = new Scanner(System.in);

		System.out
				.print("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent."
						+ "\n" + "Please type in your name and press return: ");
		String yourName = console.next();
		System.out.println();
		System.out.println("Welcome " + yourName + ".");
		System.out.println();
		roundCount(computerPlayer, console, yourName);
	}
	public static int roundCount(RandomPlayer computerPlayer, Scanner console,
			String yourName) {

		System.out
				.print("All right "
						+ yourName
						+ ". How many rounds would you like to play?"
						+ "\n"
						+ "Enter the number of rounds you want to play and press return: ");
		int rounds = console.nextInt();
		console.nextLine();
		System.out.println();
		roundPlay(computerPlayer, rounds, console, yourName);
		return rounds;
	}
	public static void roundPlay(RandomPlayer computerPlayer, int rounds,
			Scanner console, String yourName) {
		int humanWins = 0;
		int comWins = 0;

		for (int i = 1; i <= rounds; i++) {
			System.out.println("Round " + i + ".");
			System.out.print(yourName
					+ ", please enter your choice for this round." + "\n"
					+ "1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
			int playerPick = console.nextInt();

			console.nextLine();
			int computer = computerPlayer.getComputerChoice();

			String answer = playerChoice(yourName, playerPick);

			if (computer == 1)
				System.out.println("Computer picked ROCK, " + yourName
						+ " picked " + answer);
			else if (computer == 2)
				System.out.println("Computer picked PAPER, " + yourName
						+ " picked " + answer);
			else if (computer == 3)
				System.out.println("Computer picked SCISSORS, " + yourName
						+ " picked " + answer);

			System.out.println();

			if (computer == 1 && playerPick == 1) {
				System.out
						.println("We picked the same thing! This round is a draw."
								+ "\n");
			} else if (computer == 1 && playerPick == 2) {
				System.out.println("PAPER covers ROCK. You win." + "\n");
				humanWins++;
			} else if (computer == 1 && playerPick == 3) {
				System.out.println("ROCK breaks SCISSORS. I win." + "\n");
				comWins++;
			} else if (computer == 2 && playerPick == 1) {
				System.out.println("PAPER covers ROCK. I win." + "\n");
				comWins++;
			} else if (computer == 2 && playerPick == 2) {
				System.out
						.println("We picked the same thing! This round is a draw."
								+ "\n");
			} else if (computer == 2 && playerPick == 3) {
				System.out.println("SCISSORS cut PAPER. You win." + "\n");
				humanWins++;
			} else if (computer == 3 && playerPick == 1) {
				System.out.println("ROCK breaks SCISSORS. You win." + "\n");
				humanWins++;
			} else if (computer == 3 && playerPick == 2) {
				System.out.println("SCISSORS cut PAPER. I win." + "\n");
				comWins++;
			} else if (computer == 3 && playerPick == 3) {
				System.out
						.println("We picked the same thing! This round is a draw."
								+ "\n");
			}
			/* End of FOR LOOP */}
		System.out.println();
		int draws = rounds - humanWins - comWins;
		System.out.println("Number of games of ROCK PAPER SCISSORS: " + rounds);
		System.out.println("Number of times Computer won: " + comWins);
		System.out
				.println("Number of times " + yourName + " won: " + humanWins);
		System.out.println("Number of draws: " + draws);
		if (humanWins > comWins)
			System.out.println("You, " + yourName
					+ ", are a master at ROCK, PAPER, SCISSORS.");
		else if (comWins > humanWins)
			System.out
					.println("I, Computer, am a master at ROCK, PAPER, SCISSORS.");
		else
			System.out.println("We are evenly matched.");
	}
	
	public static String playerChoice(String yourName, int playerPick) {
		String rps = "";
		if (playerPick == 1)
			rps = "ROCK.";
		else if (playerPick == 2)
			rps = "PAPER.";
		else if (playerPick == 3)
			rps = "SCISSORS.";
		return rps;
	}
}