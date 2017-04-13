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

public class Vulture extends Critter{

	//Constants for class based on movement and hunger variables
	private boolean isHungry=true;
	private int moveCountv=1;

	//Sets the icon's color
	public Color getColor() {
		return Color.BLACK;
	}

	//Mimics the bird's attack motions while taking into account whether the Vulture is
	//hungry or not
	public Attack fight(String opponent) {
		if(opponent.equals("%")) {
			isHungry=true;
			return Attack.ROAR;
		}
		isHungry=true;
		return Attack.POUNCE;
	}

	//Boolean statement that takes into account the vulture's current hunger status and reassigns it
	//accordingly
	public boolean eat() {
		if(isHungry == true){
			isHungry = false;
			return true;
		}else{
			return false;
		}
	}

	//Movement method that mimics the Bird's movement
	public Direction getMove() {
		if(moveCountv > 0 && moveCountv <= 3){
			moveCountv++;
			return Direction.NORTH;
		}else if(moveCountv > 3 && moveCountv <= 6){
			moveCountv++;
			return Direction.EAST;
		}else if(moveCountv >6 && moveCountv<=9){
			moveCountv++;
			return Direction.SOUTH;
		}else if(moveCountv>9&&moveCountv<=12) {
			moveCountv++;
			return Direction.WEST;
		} else {
			moveCountv=2;
			return Direction.NORTH;
		}
	}

	//Returns icons identical in position and type to Birds
	public String toString(){
		String icon = "";
		if(moveCountv > 0 && moveCountv <= 4){
			icon = "^";
		}else if(moveCountv > 3 && moveCountv <= 7){	
			icon = ">";
		}else if(moveCountv >6 && moveCountv<=10){
			icon = "V";
		}else if(moveCountv>9&&moveCountv<=13) {	
			icon = "<";
		} else {	
			icon = "^";
		}
		return icon;
	}

}
