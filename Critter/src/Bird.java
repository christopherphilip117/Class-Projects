import java.awt.Color;

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

public class Bird extends Critter{
	//Constants for keeping positions and directions
	private int moveCount=1;
	
	//Sets the icon's color
	public Color getColor() {
		return Color.BLUE;
	}
	
	//Sets the attack methods for the bird
	//If fighting an ant, the bird will roar
	//Otherwise, it will pounce
	public Attack fight(String opponent) {
		if(opponent.equals("%"))
			return Attack.ROAR;
		else
			return Attack.POUNCE;
	}
	
	//Movement method that moves the bird three steps in a given direction, and turns it
	//accordingly for another three steps, and so on
	//Movement forms a 3x3 box
	public Direction getMove() {
		if(moveCount > 0 && moveCount <= 3){
			moveCount++;
			return Direction.NORTH;
		}else if(moveCount > 3 && moveCount <= 6){
			moveCount++;
			return Direction.EAST;
		}else if(moveCount >6 && moveCount<=9){
			moveCount++;
			return Direction.SOUTH;
		}else if(moveCount>9&&moveCount<=12) {
			moveCount++;
			return Direction.WEST;
		} else {
			moveCount=2;
			return Direction.NORTH;
		}
	}
	
	//Returns the icon based on the bird's given direction for the simulation
	public String toString(){
		String iconB = "";
		if(moveCount > 0 && moveCount <= 4){
			iconB = "^";
		}else if(moveCount > 3 && moveCount <= 7){	
			iconB = ">";
		}else if(moveCount >6 && moveCount<=10){
			iconB = "V";
		}else if(moveCount>9&&moveCount<=13) {	
			iconB = "<";
		} else {	
			iconB = "^";
		}
		return iconB;
	}

}
