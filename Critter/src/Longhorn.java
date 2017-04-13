import java.awt.Color;
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

public class Longhorn extends Critter{

	//Class constants based on direction
	private boolean movingSouth=false;
	
	//Returns the color for the icon
	public Color getColor() {
		return Color.ORANGE;
	}

	//Returns the icon to be displayed in the simulation
	public String toString() {
		return "L";
	}

	//Method that takes into account every possible attack on longhorn and returns specific attacks
	//that will guarantee a win
	public Attack fight(String opponent){
		if(opponent.equals("%"))
			return Attack.ROAR;
		if(opponent.equals("V")||opponent.equals("^")||opponent.equals("<")||
				opponent.equals(">")||opponent.equals("0"))
			return Attack.SCRATCH;
		else if(opponent.equals("S"))
			return Attack.POUNCE;
		else
			return Attack.ROAR;
		
	}

	//Complex method that takes into account fellow longhorns nearby and accounts for direction and position
	//to prevent longhorn mating, and keep longhorns from traveling outside of the height boundaries, and keep
	//them moving east horizontally, while traversing up and down richocheting of the height boundaries
	public Direction getMove() {
		int height = getHeight();
		int y = getY();
		if(movingSouth==false && y>0 && !getNeighbor(Direction.NORTH).equals("L"))
			return Direction.NORTH;
		else if(movingSouth == false && y==0 && !getNeighbor(Direction.EAST).equals("L")){
			movingSouth = true;
			return Direction.EAST;
		} else if (movingSouth == true && y < height-1 && !getNeighbor(Direction.SOUTH).equals("L")){
			return Direction.SOUTH;
		} else if(movingSouth == true && y == height-1 && !getNeighbor(Direction.EAST).equals("L")){
			movingSouth = false;
			return Direction.EAST;
		} else if (getNeighbor(Direction.NORTH).equals("L")&&!getNeighbor(Direction.EAST).equals("L")){
			return Direction.EAST;
		}else if (getNeighbor(Direction.SOUTH).equals("L")&&!getNeighbor(Direction.WEST).equals("L")){
			return Direction.WEST;
		}
		return Direction.CENTER;
	}
}