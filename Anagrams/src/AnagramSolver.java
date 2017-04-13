import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
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

public class AnagramSolver {
	private List<String> sorteddictionary;
	private Map<String, LetterInventory> completeInventory;

	public AnagramSolver(List<String> dictionary){
		//Make the global variable of dictionary into the sent in one
		sorteddictionary = new ArrayList<String>(dictionary);

		//Assume dictionary is not sorted, sort in case.
		Collections.sort(sorteddictionary);

		//Create a map in which the letter inventory for every word is stored
		completeInventory = new HashMap<String, LetterInventory>();

		//create a map of all letterinventories in the given dictionary
		for(int i = 0; i < sorteddictionary.size(); i++){
			String currentWord = sorteddictionary.get(i);
			completeInventory.put(sorteddictionary.get(i), new LetterInventory(currentWord));
		}
	}

	//Method to check if the target string is a complete word
	private boolean areAllLetters(String test){
		//convert the string into lower case
		test = test.toLowerCase();
		for(int i = 0; i < test.length(); i++){
			//if the charater is within a-z, it is a letter
			if('a' <= test.charAt(i) && test.charAt(i) <= 'z')
				return true;
		}
		return false;
	}

	//Create a sublist of only words that can possibly be an anagram
	private ArrayList<String> makeSmallerList(LetterInventory possible, List<String> originalDictionary){
		ArrayList<String> newDictionary = new ArrayList<String>();
		for(int i = 0; i < originalDictionary.size(); i++){
			String currentWord = originalDictionary.get(i);
			LetterInventory temp = completeInventory.get(currentWord);
			//The word is in fact a possible anagram
			if(possible.subtract(temp) != null)
				newDictionary.add(currentWord);
		}
		return newDictionary;
	}

	//Method to concatenate old anagrams and words with a new word
	private ArrayList<String> makeNewAnagrams(String word, List<String> anagram){
		ArrayList<String> newAnagram = new ArrayList<String>();

		for(int i = 0; i < anagram.size(); i++){
			newAnagram.add(anagram.get(i));

		}

		newAnagram.add(word);
		return newAnagram;
	}

	public List<List<String>> getAnagrams(String target, int max){
		if(!(areAllLetters(target)) || target == null)
			throw new IllegalArgumentException("Target String cannot be passed in");
		//If max is 0, there is no limit
		if(max == 0)
			max = target.length();

		//create a word bank of the target word
		LetterInventory possible = new LetterInventory(target);

		//Resulting anagrams
		List<List<String>> result = new ArrayList<List<String>>();
		//A cursor for the current anagram
		List<String> current = new ArrayList<String>();
		//Map to keep track of created anagrams
		HashMap<ArrayList<String>, Integer> created = new HashMap<ArrayList<String>, Integer>();

		//

		recursiveAnagrams(possible, result, created, max, current, sorteddictionary);
		Collections.sort(result, new AnagramComparator());
		return result;
	}

	private void recursiveAnagrams(LetterInventory possible, List<List<String>> result, 
			HashMap<ArrayList<String>, Integer> created, int max, List<String> current, List<String> dictionary){

		//Create the sublist dictionary
		ArrayList<String> newDictionary = makeSmallerList(possible, dictionary);

		//Create a temporary List for the next anagrams
		ArrayList<String> next;


		//Loop through the sub dictionary
		for(int cursor = 0; cursor < newDictionary.size(); cursor++){

			String currentWord = newDictionary.get(cursor);

			//Get a possible letter inventory out of the word and target letter inventory
			LetterInventory newPossibility = possible.subtract(completeInventory.get(currentWord));

			//Add anagrams and keep track
			next = makeNewAnagrams(currentWord, current);

			Collections.sort(next);

			//base case if the new inventory is empty

			if (newPossibility.isEmpty()){



				//Check to make sure the anagram has not been noted already
				if(!(created.containsKey(next))){

					result.add(next);

					created.put(next, 1);

				}
			}


			//recursive call
			else if(next.size() < max)
				recursiveAnagrams(newPossibility, result, created, max, next, newDictionary);

		}

	}



	private static class AnagramComparator implements Comparator<List<String>> {
		public int compare(List<String> x, List<String> y){
			if(x == null || y == null)
				throw new IllegalArgumentException("One or both Lists are null");

			if(x.size() < y.size())
				return -1;

			else if(x.size() > y.size())
				return 1;

			else{
				int size = x.size();
				for(int i = 0; i < size; i++){
					String xtemp = x.get(i);
					String ytemp = y.get(i);

					if(xtemp.compareTo(ytemp) != 0)
						return xtemp.compareTo(ytemp);
				}
			}
			return 0;
		}
	}


}
