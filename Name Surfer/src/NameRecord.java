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

import java.util.ArrayList;

public class NameRecord {
	private ArrayList<Integer> rank = new ArrayList<Integer>();
	private String name;
	private int baseDecade;

	public NameRecord(String name, int baseDecade, ArrayList rank) {
		this.name = name;
		this.baseDecade = baseDecade;
		this.rank = rank;

	}

	// Method to return the nameh
	
	public String getName() {
		return name;
	}

	public int getBaseDecade() {

		return baseDecade;
	}

	public int getRank(int decade) {
		return rank.get(decade);
	}

	public int getBestDecade() {
		int max = 0;
		for (int decade = 1; decade < rank.size(); decade++) {
			if (rank.get(max) == 0)
				max = decade;
			else if ((rank.get(decade) <= rank.get(max))
					&& rank.get(decade) != 0) {
				max = decade;
			}
		}

		return (this.baseDecade + (10 * max));

	}

	public int getNumTop1000() {
		int count = 0;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) <= 1000 && rank.get(i) != 0)
				count++;
		}

		return count;
	}

	public boolean alwaysIn1000() {
		int count = getNumTop1000();
		if (count == rank.size())
			return true;
		else
			return false;
	}

	public boolean onceIn1000() {
		int count = getNumTop1000();
		if (count == 1)
			return true;
		else
			return false;
	}

	public boolean isBetter() {
		boolean increasing = true;
		// Loops through and checks to see if ranks are in a increasing order
		for (int i = 1; i < rank.size(); i++) {
			int temp = rank.get(i - 1);
			if ((rank.get(i) >= temp) || (temp == 0 && rank.get(i) == 0)) {
				increasing = false;
				i = rank.size();
			}
		}
		return increasing;
	}

	public boolean isWorse() {
		boolean decreasing = true;
		// Loops through and checks to see if ranks are in a decreasing order
		for (int i = 1; i < rank.size(); i++) {
			int temp = rank.get(i - 1);
			if ((rank.get(i) <= temp && rank.get(i) != 0) || (temp == 0)) {
				decreasing = false;
				i = rank.size();
			}
		}
		return decreasing;
	}

	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(name + "\n");
		for (int i = 0; i < rank.size(); i++) {
			print.append((baseDecade + (i * 10)) + ": " + rank.get(i) + "\n");
		}
		return print.toString();
	}

}
