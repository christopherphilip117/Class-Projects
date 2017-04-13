import java.awt.Color;
import java.util.Random;

//import Critter.Attack;
/**
 * CS312 Assignment 11.
 *
 * On <OUR> honor, <Jaemin Goh> and <Christopher Philip), this programming assignment is <OUR> own work
 * and <WE> have not provided this code to any other student.
 *
 * Student 1 name: Jaemin Goh
 * UTEID: jg57942
 * email address: jaemin_goh@yahoo.com
 * Section 5 digit ID:52800
 * Grader name:Eric
 * Number of slip days used on this assignment: 0 
 *
 * Student 2 name:Christopher Philip
 * UTEID:cp26645
 * email address: christopher.philip117@gmail.com
 * 
 */

public class Hippo extends Critter{
	
	//Constants for the class for direction, and hunger variables
	private String hungerOMeter;
	private int hungerInt;
	private int moveCountH=0;
	private int direction=0;

	//Method that returns the Hippo's icon based on its hunger status
	public Hippo(int hunger) {
		hungerInt = hunger;
		hungerOMeter=""+hunger;
	}

	//If the Hippo eats, its icon changes based on its hunger change
	public boolean eat() {
		if(hungerInt>0){
			hungerInt--;
			hungerOMeter = "" + hungerInt;
			return true;
		}
		hungerOMeter = "" + hungerInt;
		return false;

	}

	//Sets the icons color for is the Hippo is hungry and if it is not
	public Color getColor() {
		if(hungerInt == 0)
			return Color.WHITE;
		return Color.GRAY;
	}

	//Method that returns attack motions based on hunger factors
	public Attack fight(String opponent) {
		if(hungerInt==0)
			return Attack.POUNCE;
		else
			return Attack.SCRATCH;
	}

	//Returns the icon to be displayed in the simulation
	public String toString() {
		return hungerOMeter;
	}

	//Movement method for Hippo based on current direction and a random direction number
	public Direction getMove() {
		Random r = new Random();
		if(moveCountH%5==0)
			direction = r.nextInt(4);
		//determine what direction hippo is going
		//after getting the direction number above.
		if(direction==0){
			moveCountH++;
			return Direction.NORTH;
		}else if(direction==1){
			moveCountH++;
			return Direction.EAST;
		}else if(direction==2){
			moveCountH++;
			return Direction.SOUTH;
		}else{
			moveCountH++;
			return Direction.WEST;
		}
		
	}
}
