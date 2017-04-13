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
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A collection of NameRecords. Stores NameRecord objects and provides methods
 * to select NameRecords based on various criteria.
 */
public class Names {
	private int initial;
	private ArrayList<NameRecord> names = new ArrayList<NameRecord>();

	public Names(Scanner input) {
		String line;
		int numRanks;
		line = input.nextLine();
		String[] parsedData = line.split("\\s+");
		initial = Integer.parseInt(parsedData[0]);
		line = input.nextLine();
		parsedData = line.split("\\s+");
		numRanks = Integer.parseInt(parsedData[0]);

		while (input.hasNextLine()) {
			line = input.nextLine();
			// create a NameRecord object based on line and add it to the
			// ArrayList of NameRecord objects
			parsedData = line.split("\\s+");
			// Checks if line contains number of ranks needed to be recorded
			if (parsedData.length - 1 == numRanks) {
				// Add name record
				ArrayList<Integer> ranks = new ArrayList<Integer>();
				for (int i = 1; i < parsedData.length; i++)
					ranks.add(Integer.parseInt(parsedData[i]));

				names.add(new NameRecord(parsedData[0], initial, ranks));
			}

		}

	}

	public String mostUsed(int decade) {
		if (!(decade > -1 && decade < 11))
			throw new IllegalArgumentException("Decade out of range");
		String name = null;
		for (int i = 0; i < names.size(); i++) {
			NameRecord name1 = names.get(i);

			// find the name ranked 1 for a decade
			if (name1.getRank(decade) == 1) {
				name = name1.getName();
				i = names.size();
			}

		}
		return name;
	}

	/**
	 * Returns an ArrayList of NameRecord objects that contain a given
	 * substring, ignoring case. The names must be in sorted order based on
	 * name.
	 * 
	 * @param partialName
	 *            != null, partialName.length() > 0
	 * @return an ArrayList of NameRecords whose names contains partialName. If
	 *         there are no NameRecords that meet this criteria returns an empty
	 *         list.
	 */

	public ArrayList<NameRecord> getMatches(String partialName) {
		if (partialName == null || partialName.length() < 0)
			throw new IllegalArgumentException("Parameters were not met.");
		ArrayList<NameRecord> matches = new ArrayList<NameRecord>();

		// To avoid any capitalization differences
		partialName = partialName.toUpperCase();
		for (int i = 0; i < names.size(); i++) {
			String test = names.get(i).getName().toUpperCase();
			if (test.contains(partialName)) {
				NameRecord name = names.get(i);
				matches.add(name);
			}
		}
		return matches;

	}

	public NameRecord getOneMatch(String exact) {
		exact = exact.toUpperCase();
		NameRecord name = null;
		int i = 0;
		boolean found = false;
		while (!found && i < names.size()) {
			String test = names.get(i).getName().toUpperCase();
			if (test.equals(exact)) {
				name = names.get(i);
				found = true;
			}
			i++;
		}

		return name;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the top
	 * 1000 or better for every decade. The Strings must be in sorted order
	 * based on name.
	 * 
	 * @return A list of the names that have been ranked in the top 1000 or
	 *         better in every decade. The list is in sorted ascending order. If
	 *         there are no NameRecords that meet this criteria returns an empty
	 *         list.
	 */

	public ArrayList<String> rankedEveryDecade() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).alwaysIn1000())
				results.add(names.get(i).getName());

		}
		return results;

	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the top
	 * 1000 or better in exactly one decade. The Strings must be in sorted order
	 * based on name.
	 * 
	 * @return A list of the names that have been ranked in the top 1000 or
	 *         better in exactly one decade. The list is in sorted ascending
	 *         order. If there are no NameRecords that meet this criteria
	 *         returns an empty list.
	 */
	public ArrayList<String> rankedOnlyOneDecade() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).onceIn1000())
				results.add(names.get(i).getName());

		}
		return results;

	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting more
	 * popular every decade. The Strings must be in sorted order based on name.
	 * 
	 * @return A list of the names that have been getting more popular in every
	 *         decade. The list is in sorted ascending order. If there are no
	 *         NameRecords that meet this criteria returns an empty list.
	 */
	public ArrayList<String> alwaysMorePopular() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).isBetter())
				results.add(names.get(i).getName());

		}
		return results;

	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting less
	 * popular every decade. The Strings must be in sorted order based on name.
	 * 
	 * @return A list of the names that have been getting less popular in every
	 *         decade. The list is in sorted ascending order. If there are no
	 *         NameRecords that meet this criteria returns an empty list.
	 */
	public ArrayList<String> alwaysLessPopular() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).isWorse())
				results.add(names.get(i).getName());

		}
		return results;

	}

}
