/*  Student information for assignment:
 *
/*  Student information for assignment:
 * 
 * replace <NAME> with your name.
 *
 *  On my honor, <Christopher Philip>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Christopher Philip
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Section 5 digit ID: 88620
 *  Grader name: Kris Vandercook
 *  Number of slip days used on this assignment: 0 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int MOST_POPULAR = 7;

	public static final int QUIT = 8;

	// CS314 students, explain your menu option 7 here:
	/*
	 * My custom option allows the user to input any decade they wish, and the
	 * program will return the most popular name of that decade by searching for
	 * which name contains a rank of 1 in that decade.
	 */

	// CS314 students, Explain your interesting search / trend here:
	/*
	 * The interesting trend I found was that using my custom method, the name
	 * Mary appeared twice in a row, meaning the name was popular for a total of
	 * 20 years, 1920-1940. I also can conclude that the majority of most
	 * popular names from 1900-2000 consisted of female names, suggesting that
	 * more females were born than males from 1900-2000.
	 */

	// CS314 students, add test code for NameRecord class here:
	public static void test() {
		ArrayList<Integer> ranks = new ArrayList<Integer>();
		ranks.add(0);
		ranks.add(283);
		ranks.add(28);
		ranks.add(333);
		ranks.add(0);
		ranks.add(0);
		NameRecord Chris = new NameRecord("Chris", 1900, ranks);
		System.out.println(Chris.getBestDecade());
		if (Chris.getBestDecade() == 1920)
			System.out.println("Test 1 passed");
		else
			System.out.println("Test 1 FAILED.");

		if (Chris.getName().equals("Chris"))
			System.out.println("Test 2 passed.");
		else
			System.out.println("Test 2 FAILED.");

		if (Chris.getRank(0) == 0)
			System.out.println("Test 3 passed.");
		else
			System.out.println("Test 3 FAILED.");

		if (Chris.isBetter())
			System.out.println("Test 4 FAILED.");
		else
			System.out.println("Test 4 passed.");

		if (Chris.isWorse())
			System.out.println("Test 5 FAILED.");
		else
			System.out.println("Test 5 passed.");

	}

	// simple test for toString
	public static void simpleToStringTest() {
		// raw data for Jake. Alter as necessary for your NameRecord
		// String jakeRawData =
		// "Jake 262 312 323 479 484 630 751 453 225 117 97";
		ArrayList<Integer> ranks = new ArrayList<Integer>();
		ranks.add(262);
		ranks.add(312);
		ranks.add(323);
		ranks.add(479);
		ranks.add(484);
		ranks.add(630);
		ranks.add(751);
		ranks.add(453);
		ranks.add(225);
		ranks.add(117);
		ranks.add(97);
		int baseDecade = 1900;
		NameRecord jakeRecord = new NameRecord("Jake", baseDecade, ranks);// complete
																			// with
																			// your
																			// constructor
		String expected = "Jake\n1900: 262\n1910: 312\n1920: "
				+ "323\n1930: 479\n1940: 484\n1950:"
				+ " 630\n1960: 751\n1970: 453\n1980: 225\n1990: 117\n2000: 97\n";
		String actual = jakeRecord.toString();
		System.out.println("expected string:\n" + expected);
		System.out.println("actual string:\n" + actual);
		if (expected.equals(actual))
			System.out.println("passed Jake toString test.");
		else
			System.out.println("FAILED Jake toString test.");
	}

	// main method. Driver for the whole program
	public static void main(String[] args) {
//		simpleToStringTest();
//		test();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Unable to set look at feel to local settings. "
					+ "Continuing with default Java look and feel.");
		}
		try {

			// uncomment the next two lines if you want to let user obtain file
			// via GUI
			/*
			 * System.out.println("Opening GUI to choose file with names data..."
			 * ); Scanner fileScanner = new Scanner(getFile());
			 */

			// uncomment next line to hard code name file
			Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if (choice == SEARCH)
					search(n, keyboard);
				else if (choice == ONE_NAME)
					oneName(n, keyboard);
				else if (choice == APPEAR_ONCE)
					appearOnce(n);
				else if (choice == APPEAR_ALWAYS)
					appearAlways(n);
				// CS314 students, complete this section
				else if (choice == MORE_POPULAR)
					morePopular(n, keyboard);
				else if (choice == LESS_POPULAR)
					lessPopular(n, keyboard);
				else if (choice == MOST_POPULAR)
					mostPopular(n, keyboard);
				else
					System.out.println("\n\nGoodbye.");

			} while (choice != QUIT);
		} catch (FileNotFoundException e) {
			System.out
					.println("Problem reading the data file. Exiting the program."
							+ e);
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		if (n == null)
			throw new IllegalArgumentException("Parameters were not met.");
		ArrayList<String> results = n.rankedEveryDecade();
		System.out.println(results.size()
				+ " names appear in every decade. The names are: ");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}

	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		if (n == null)
			throw new IllegalArgumentException("Parameters were not met.");

		ArrayList<String> results = n.rankedOnlyOneDecade();
		System.out.println(results.size()
				+ " names appear in exactly one decade. The names are: ");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}

	}

	// method that shows data for one name, or states that name has never been
	// ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the
	// top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		System.out.print("Enter a name: ");
		String input = keyboard.nextLine();
		NameRecord name = (n.getOneMatch(input));
		System.out.println();
		if (name == null)
			System.out.println(input + " does not appear in any decade.");
		else {
			System.out.print(name.toString());
		}
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data
	private static void search(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		System.out.print("Enter a partial name: ");
		String name = keyboard.nextLine();
		ArrayList<NameRecord> results = n.getMatches(name);
		System.out.println();
		System.out.println("There are " + results.size() + " matches for "
				+ name + ".");
		if (results.size() != 0) {
			System.out.println();
			System.out
					.println("The matches with their highest ranking decade are:");
			for (int i = 0; i < results.size(); i++) {
				System.out.println(results.get(i).getName() + " "
						+ results.get(i).getBestDecade());
			}
		}

	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		if (keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while (choice < SEARCH || choice > QUIT) {
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
	private static int getInt(Scanner s, String prompt) {
		System.out.print(prompt);
		while (!s.hasNextInt()) {
			s.next();
			System.out.println("That was not an int.");
			System.out.print(prompt);
		}
		return s.nextInt();
	}

	private static void morePopular(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		ArrayList<String> results = n.alwaysMorePopular();
		System.out.println(results.size()
				+ " are more popular in every decade.");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}

	private static void lessPopular(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		ArrayList<String> results = n.alwaysLessPopular();
		System.out.println(results.size()
				+ " are less popular in every decade.");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}

	// MY CUSTOM OPTION
	// Find the most popular name for a given decade
	private static void mostPopular(Names n, Scanner keyboard) {
		if (n == null || keyboard == null)
			throw new IllegalArgumentException("Parameters were not met.");

		System.out.print("Enter a decade: ");
		int decade = keyboard.nextInt();
		if (decade > 10 || decade < 0)
			System.out.println("DECADE OUT OF RANGE, PLEASE CHOOSE 0-10");
		else {
			String name = n.mostUsed(decade);
			System.out.println();
			System.out.println("The most popular name of "
					+ (1900 + (10 * decade)) + " is: " + name);
		}
	}

	// show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME
				+ " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE
				+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS
				+ " to display all names that appear in all decades.");
		System.out
				.println("Enter "
						+ MORE_POPULAR
						+ " to display all names that are more popular in every decade.");
		System.out
				.println("Enter "
						+ LESS_POPULAR
						+ " to display all names that are less popular in every decade.");
		// CS314 students fill in other options
		System.out.println("Enter " + MOST_POPULAR
				+ " to display the most popular name for a decade.");

		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/**
	 * Method to choose a file using a traditional window.
	 * 
	 * @return the file chosen by the user. Returns null if no file picked.
	 */
	public static File getFile() {
		// create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
		chooser.setDialogTitle("Select File With Baby Names Data.");
		int retval = chooser.showOpenDialog(null);
		File f = null;
		chooser.grabFocus();
		if (retval == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();
		return f;
	}

}