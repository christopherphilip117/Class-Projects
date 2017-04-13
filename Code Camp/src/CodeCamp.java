//  CodeCamp.java - CS314 Assignment 1

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

import java.util.Random;

public class CodeCamp {
  
    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.<br>
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aList, int[] bList){
        // check preconditions
        if (aList == null || bList == null || aList.length != bList.length) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"hammingDistance. neither parameter may equal null, arrays" +
            		" must be equal length.");
        
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        int hammingdistance = 0;
        //both arrays MUST be equal in length to proceed
        //aList.length == bList.length
        int i = 0;
        while(i < aList.length){ //scrolls through and checks every value, 
        	//					incrementing the count variable for differences
        	if(aList[i] != bList[i])
        		hammingdistance ++;
        	i++;
        }
        
        return hammingdistance; //must change
    }
    
    
    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.<br>
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, 
     * <tt>false</tt> otherwise
     * 
    */
    public static boolean isPermutation(int[] listA, int[] listB) {
        // check preconditions
        if (listA == null || listB == null) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isPermutation. neither parameter may equal null.");
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        boolean isTrue = true;
        int count = 0;
        //both arrays MUST be equal in length
        if(listA.length != listB.length)
        	isTrue = false;
        //If they are of equal length, move on to check permutations
        else{
        	int[] listAcopy = listA;
        	int[] listBcopy = listB; //creates two copy lists for modification 
        	int size = listA.length;
        	for(int i = 0; i < size; i++){
        		
        		for(int j = 0; j < size; j++){
        			
        			if(listAcopy[i] == listBcopy[j]){
        				
        				count++;
        				listBcopy[j] = -100; //changes copy list to avoid recounts
        			}
        				
        			
        		}
        	}
        	if(count == size) //if the count equal to the size, all values are matching
        		isTrue = true;
        	else
        		isTrue = false;
        	
       }
        
        return isTrue; //must change
    }
    
    
    /**
     * Determine the index of the String that 
     * has the largest number of vowels. 
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
     * 'U', and 'u'</tt>.
     * The parameter <tt>list</tt> is not altered as a result of this method.
     * <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
     * <p>post: return the index of the non-null element in list that has the 
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero. 
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param list the array to check
     * @return the index of the non-null element in list that has 
     * the largest number of vowels.
     */
    public static int mostVowels(String[] list) {
        // check preconditions
        if (list == null || list.length == 0 || !atLeastOneNonNull(list))  
            throw new IllegalArgumentException("Violation of precondition: " +
            		"mostVowels. parameter may not equal null and must contain " +
            		"at least one none null value.");
       

        // CS314 STUDENTS: ADD YOUR CODE HERE
        //  You can use all methods from the String class and native arrays.
        int numvowels = 0;
        int max = -100;
        int pos = 0;
        String test = "";
        for(int i = 0; i < list.length; i++){
        	if(list[i] != null){
        	test = list[i];
        	test = test.toUpperCase(); //capitalizes each letter for faster operations
        	for(int j = 0; j < test.length(); j++){
        		char temp = test.charAt(j);
        		if(temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        			numvowels++;
        	}
        	if(numvowels > max){
        		pos = i;
        		max = numvowels;
        	}
        	numvowels = 0;
        }
       }
       


        return pos; //must change
    }
    

    
    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);
        
        //CS314 STUDENTS: ADD YOUR CODE HERE
        int bdays[] = new int[numPeople]; //creates a list for the number of people
        Random r = new Random();
        int pairs = 0;
        for(int i = 0; i < numPeople; i++){
        	bdays[i] = r.nextInt(numDaysInYear); //Creates random birthdays for the list
        }
        
        for(int j = 0; j < bdays.length; j++){
        	for(int h = j+1; h < bdays.length; h++){ //loops through the list
        		//										and compares birthdays for pairs
        		if(bdays[j] == bdays[h])
        			pairs++;
        	}
        	
        }
        
        

        return pairs; //must change
    }
    
    
    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
    */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board) 
                || !onlyContains(board, validChars))
            throw new IllegalArgumentException("Violation of precondition: " +
            		"queensAreSafe. The board may not be null, must be square, " +
            		"and may only contain 'q's and '.'s");        
                
      //CS314 STUDENTS: ADD YOUR CODE HERE
        int domain = board.length;
        int range = board[0].length;
        int count = 0;
        boolean safe = horizontal(board, domain, range, count); 
        //System.out.println("horizontal is " + safe);
        if(safe){
        	safe = vertical(board, domain, range, count);
        	//System.out.println("vertical is " + safe);
        }
        if(safe){
        	safe = diag(board, domain, range, count);
        	//System.out.println("diagonals are " + safe);
        }

        return safe; //must change
    }
    
    public static boolean horizontal(char[][]board, int domain, int range, int count){
    	boolean safe = true;
    	count  = 0;
    	for(int row = 0; row < domain; row++){
    		for(int col = 0; col < range; col++){  
    			//loops through each row and counts queens in each
    			if(board[row][col] == 'q'){         
    			//if two queens, the method defaults to false and skips all other checks
    				count++;
    			}
    		}
    		if(count >= 2){
    			safe = false;
    			row = domain;
    		}
    		else
    			count  = 0;
    		
    	}
    	return safe;
    }
    
    public static boolean vertical(char[][]board, int domain, int range, int count){
    	count  = 0;
    	boolean safe = true;
    	for(int col = 0; col < range; col++){
    		for(int row = 0; row < domain; row++){ //mimics the horizontal check, just different directions
    			if(board[row][col] == 'q')
    				count++;
    		}
    		if(count >= 2){
    			safe = false;
    			col = range;
    	}
    		else
    			count  = 0;
     }
    	return safe;
   }
    
    public static boolean diag(char[][]board, int domain, int range, int count){
    	count = 0;
    	boolean safe = true;
    	for(int row = 0; row < domain; row++){
    		for(int col = 0; col < range; col++){
    			if(board[row][col] == 'q'){
    				safe = upRight(board, domain, range, row, col);
    				//System.out.println("row = " + row + ", col = " + col);
    				if(safe)
        				safe = downRight(board, domain, range, row, col);
    			}
    		}
    		if(!safe)
				row = domain;
     }
    	return safe;
   }
    public static boolean downRight(char[][]board, int domain, int range, int row, int col){
    	boolean safe = true;
    	int count = 1;
    	if(row+1!=domain && col+1 != range){
    		while(safe && row!=domain-1 && col!=range-1){
    		row++;
    		col++;
    		if(board[row][col] == 'q')
    			count++;
    		}
    		if(count == 2)
    			safe = false;
    		
    	}
    	//System.out.println("Lower is " + safe);
    	return safe;
    }
    
    
    public static boolean upRight(char[][]board, int domain, int range, int row, int col){
    	boolean safe = true;
    	int count = 1;
    	if(row-1!=0 && col+1 != range){
    		while(safe && row!=0 && col!=range-1){
    		row--;
    		col++;
    		if(board[row][col] == 'q')
    			count++;
    		}
    		if(count == 2)
    			safe = false;
    		
    	}
    	//System.out.println("Upper is " + safe);
    	return safe;
    }
  
    	
    	
 
    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0 
                || !isRectangular(city) )
            throw new IllegalArgumentException("Violation of precondition: " +
            		"getValueOfMostValuablePlot. The parameter may not be null," +
            		" must value at least one row and at least" +
                    " one column, and must be rectangular."); 
        

        //CS314 STUDENTS: ADD YOUR CODE HERE
        int maxPlot = -1000000;
        int plot = 0;
        int domain = city.length;
        int range = city[0].length;
        for(int row = 0; row < domain; row++){
        	for(int col = 0; col < range; col++){ //first two loops loop through the entire array
        		for(int rect1 = row; rect1 < domain; rect1++){
        			for(int rect2 = col; rect2 < range; rect2++){ // second two loops create various rectangles
        				
        				//Last two loops will compute the plots and determine max plots
        				
        			for(int pos1 = row; pos1 <= rect1; pos1++){ //keeps pos1 within the row length of rectangle
        			  for(int pos2 = col; pos2 <= rect2; pos2++){ //keeps pos2 within the col length of rectangle
        					plot += city[pos1][pos2];   //Adds the sum of plots inside the decided rectangle
        					}
        						
        				}
        				if(plot > maxPlot)
        					maxPlot = plot;
        				plot = 0;
        				
        			}
        		}
        	}
        		
        }

        return maxPlot; //must change
    }
    
    
    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiement code here:
    public static void birthdayExperiment(){
    	int average = 0;
    	for(int i = 1; i <= 1000000; i++)
    		average += sharedBirthdays(182, 365);
    
    average = average/1000000;
    System.out.println("Out of 1,000,000 runs with 182 people"
    		+ " and 365 days, the average number "
    		+ "of pairs was " + average);
    
    
    for(int people = 2; people <= 100; people++){
    	average = 0;
    	for(int test = 0; test < 50000; test++){
    		if(sharedBirthdays(people, 365) > 0)
    			average++;
    	}
    	
    	System.out.print("Num People " + people + ", number of experiments "
    			+ "with one or more shared birthday: " + average
    			+ ", percentage: " + (average * 100.0 / 50000));
    	
    	System.out.println();
    	System.out.println();
    	
    }
    
    }
    
    // pre: list != null
    // post: return true if at least one element in list is null
    // otherwise return false.
    private static boolean atLeastOneNonNull(String[] list) {
        // check precondition
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"atLeastOneNonNull. parameter may not equal null.");
        
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < list.length ){
            foundNonNull = list[i] != null;
            i++;
        }
        return foundNonNull;
    }
    
    
    /* pre: mat != null
    post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isSquare. paremeter may not be null.");

        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while( isSquare && row < numRows ) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }
    
    
    /* pre: mat != null, valid != null
    post: return true if all elements in mat are one of the characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if(mat == null || valid == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"onlyContains. paremeters may not be null.");
        
        int row = 0;
        boolean correct = true;
        while( correct && row < mat.length) {
            int col = 0;
            while(correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }
    
    
    /*  pre: list != null
        post: return true if c is in list
     */
    private static boolean contains(char[] list, char tgtChar) {
        // check preconditions
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"contains. paremeter may not be null.");

        boolean found = false;
        int index = 0;
        while( !found && index < list.length) {
            found = list[index] == tgtChar;
            index++;
        }
        return found;
    }
   
    
     // pre: mat != null, mat.length > 0
     // post: return true if mat is rectangular
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if(mat == null || mat.length == 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isRectangular. paremeter may not be null and must contain" +
            		" at least one row.");

        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }
    
    // make constructor pirvate so no instances of CodeCamp can be created
    private CodeCamp() {
        
    }
}