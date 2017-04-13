/*
 *  CS312 Assignment 2.
 *  On my honor, <Christopher Philip>, this programming assignment is my own work.
 *
 *  A program to print out the UT Tower in ASCII art form.
 *
 *  Name: Christopher Philip
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Section 5 digit ID: 52800
 *  Grader name: Eric
 *  Number of slip days used on this assignment: 0 
 */

public class Tower {

	// CS312 students, DO NOT ALTER THE FOLLOWING LINE.
	public static final int SIZE = TowerSize.getSize();

	public static void main(String[] args) {
		towerTop();
		topBase();
		towerMain();
		baseSteps();
		bottomBase();
	}

	// In this method, I lay out the foundations for the spacing of the very tip
	// of the tower.
	public static void spacingTop() {
		int space = (SIZE * 5) - (SIZE - 2);
		for (int i = 1; i <= space; i++) {
			System.out.print(" ");
		}
	}

	// This method continues off the spacing, and begins laying down the actual
	// characters for the top.
	public static void towerTop() {
		int hashtag = (2 * SIZE) - 1;
		spacingTop();
		for (int i = 1; i <= hashtag; i++) {
			System.out.print("#");
		}
		System.out.println();
		spacingTop();

		for (int i = 1; i <= SIZE; i++) {
			for (int x = 1; x <= hashtag; x++) {
				System.out.print("|");
			}
			System.out.println();
			spacingTop();
		}

		for (int i = 1; i <= hashtag; i++) {
			System.out.print("#");
		}
		System.out.println();

	}

	// This code finalizes the tip of the tower, and lays down the beginning for
	// the main part.
	public static void spacingTopBase() {
		int space = SIZE * 4;
		for (int i = 1; i <= space; i++) {
			System.out.print(" ");
		}
	}

	// This method adds the little "~" that ends the tip, and begins the body of
	// the tower.
	public static void curlyLine() {
		int curlyLine = (SIZE * 2) + 3;
		for (int i = 1; i <= curlyLine; i++) {
			System.out.print("~");
		}
		System.out.println(" ");
	}

	// since the spacing for the body and tip are different, adjustments using
	// previous variables are needed.
	public static void topBase() {
		spacingTopBase();
		curlyLine();
	}

	// The body of the tower. Prints out the first character, runs a loop to
	// fill in the rest, and adds
	// an extra at the end to finish.
	public static void towerMain() {
		for (int i = 1; i <= SIZE * SIZE; i++) {
			spacingTopBase();
			System.out.print("|");
			for (int x = 1; x <= SIZE; x++) {
				System.out.print("-O");

			}
			System.out.print("-|");
			System.out.println(" ");
			spacingTopBase();
			curlyLine();
		}
	}

	// This is the most complex part. Taking into account the rows, the
	// different spacing, and the
	// actual characters, a triple nested loop was needed to account for all
	// these factors.
	// using paper, I created variables and equations for the spacing, the rows,
	// and the
	// character filling. Laying each in their appropriate place, the loop runs
	// through,
	// the first loop prints the rows, the second, the spacing, and the third,
	// the characters.
	public static void baseSteps() {
		int modulus = (SIZE % 2) * 2;
		int baseSpace = (SIZE * 2) - (SIZE / 2) - modulus;
		int steps = (SIZE / 2);
		int printed = (SIZE * 5) - (3 * steps);
		for (int i = 0; i <= steps; i++) {
			for (int y = 1; y <= baseSpace; y++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int x = 1; x <= printed; x++) {

				System.out.print("\"'");
			}
			printed += 3;
			baseSpace -= 3;
			System.out.print("\"\\");
			System.out.println();

		}
	}

	// the final part to the tower is the bottom base
	// this code prints out the bottom base using a nested for loop that prints
	// out the rows,
	// then the filling of characters precisely.
	public static void bottomBase() {

		for (int i = 1; i <= SIZE; i++) {
			System.out.print("/");
			for (int x = 1; x <= (SIZE * 5); x++) {
				System.out.print("\"O");
			}
			System.out.print("\"\\");
			System.out.println(" ");
		}
	}

}
