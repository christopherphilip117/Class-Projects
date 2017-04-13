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

public class LetterInventory {
	public final int alphabet = 26;
	private int size;
	private int[] inventory;



	public LetterInventory(String word){
		if(word == null)
			throw new IllegalArgumentException("Word sent in is Null");
		//this.size = 0;
		inventory = new int[alphabet];
		String lowercase = word.toLowerCase();
		for(int i = 0; i < lowercase.length(); i++){
			char temp = lowercase.charAt(i);
			if('a' <= temp && temp <= 'z'){
				inventory[temp - 'a']++;
				size++;
			}

		}
	}

	public int get(char input){
		char temp = Character.toLowerCase(input);
		if(!('a' <= temp && temp <= 'z'))
			throw new IllegalArgumentException("Character sent in is not a letter");

		return inventory[temp - 'a'];
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0)
			return true;
		else
			return false;
	}

	public String toString(){
		StringBuilder result = new StringBuilder();
		if(size == 0)
			return "";

		for(int i = 0; i < inventory.length; i++){
			for(int letter = 0; letter < inventory[i]; letter++){
				result.append((char) ('a' + i));
			}
		}
		return result.toString();
	}

	public LetterInventory add(LetterInventory that){
		if(that == null)
			throw new IllegalArgumentException("Cannot add NULL");

		LetterInventory result = new LetterInventory("");

		for(int i = 0; i < alphabet; i++){
			int num = this.inventory[i] + that.inventory[i];


			result.size += num;

			result.inventory[i] = num;

		}
		return result;

	}

	//LetterInventory result = new LetterInventory(this.toString() + that.toString());

	public LetterInventory subtract(LetterInventory that){
		if(that == null)
			throw new IllegalArgumentException("Cannot add NULL");

		LetterInventory result = new LetterInventory("");

		for(int i = 0; i < alphabet; i++){
			int num = this.inventory[i] - that.inventory[i];

			if(num < 0)
				return null;

			result.size += num;

			result.inventory[i] = num;

		}
		return result;

	}

	public boolean equals(Object that){
		if(that == null)
			return false;

		if(!(that instanceof LetterInventory))
			return false;

		LetterInventory other = (LetterInventory) that;

		for(int i = 0; i < alphabet; i++){
			if(this.inventory[i] != other.inventory[i])
				return false;
		}
		return true;
	}


}
