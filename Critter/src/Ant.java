import java.awt.*;
//import Critter.Direction;

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

public class Ant extends Critter{

	//Constants for class
	private boolean walkSouth;
	private boolean movedSouth = false;
	private boolean movedNorth = false;

	
	//boolean statement that assigns the walk boolean to a variable for the class
	public Ant(boolean b) {
		walkSouth = b;
	}
  
	//Returns the icon for ants to be displayed in the simulation
	public String toString() {
		return "%";
	}

	//Statement that retrns the ants only method of attack
	public Attack fight(String opponent) {
			return Attack.SCRATCH;
	}

	//Sets the icon's color
	public Color getColor() {
		return Color.RED;
	}

	//Program that saves the ants last position and direction and uses conditionals to plot the 
	//next movement
	public Direction getMove() {
		if(walkSouth == true) {
			if(movedSouth == false){
				movedSouth = true;
				return Direction.SOUTH;
			} else {
				movedSouth = false;
				return Direction.EAST;
			}
		} else {
			if(movedNorth == false){
				movedNorth = true;
				return Direction.NORTH;
			} else {
				movedNorth = false;
				return Direction.EAST;
			}
		}
	}
}
