import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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


/* CS314 Students: place results of shared birthdays experiments in this comment.
 *         //AVERAGE NUMBER OF PAIRS FROM BIRTHDAY TEST OF 182 PEOPLE: 45 PAIRS
       //CodeCamp.birthdayExperiment();
        
        //It took 50 people to pass 50% of shared birthdays
        //This result in fact did surprise me, I thought it would have taken longer
         * 
         */

        //Experiment 2
		//FINAL RESULT: 23 people to have better than a 50% chance of having at least one set of shared birthdays

//        Num People 2, number of experiments with one or more shared birthday: 114, percentage: 0.228
//
//        Num People 3, number of experiments with one or more shared birthday: 391, percentage: 0.782
//
//        Num People 4, number of experiments with one or more shared birthday: 797, percentage: 1.594
//
//        Num People 5, number of experiments with one or more shared birthday: 1304, percentage: 2.608
//
//        Num People 6, number of experiments with one or more shared birthday: 2074, percentage: 4.148
//
//        Num People 7, number of experiments with one or more shared birthday: 2803, percentage: 5.606
//
//        Num People 8, number of experiments with one or more shared birthday: 3763, percentage: 7.526
//
//        Num People 9, number of experiments with one or more shared birthday: 4734, percentage: 9.468
//
//        Num People 10, number of experiments with one or more shared birthday: 5844, percentage: 11.688
//
//        Num People 11, number of experiments with one or more shared birthday: 7155, percentage: 14.31
//
//        Num People 12, number of experiments with one or more shared birthday: 8496, percentage: 16.992
//
//        Num People 13, number of experiments with one or more shared birthday: 9633, percentage: 19.266
//
//        Num People 14, number of experiments with one or more shared birthday: 11339, percentage: 22.678
//
//        Num People 15, number of experiments with one or more shared birthday: 12764, percentage: 25.528
//
//        Num People 16, number of experiments with one or more shared birthday: 14427, percentage: 28.854
//
//        Num People 17, number of experiments with one or more shared birthday: 15881, percentage: 31.762
//
//        Num People 18, number of experiments with one or more shared birthday: 17424, percentage: 34.848
//
//        Num People 19, number of experiments with one or more shared birthday: 18939, percentage: 37.878
//
//        Num People 20, number of experiments with one or more shared birthday: 20558, percentage: 41.116
//
//        Num People 21, number of experiments with one or more shared birthday: 22231, percentage: 44.462
//
//        Num People 22, number of experiments with one or more shared birthday: 23712, percentage: 47.424
//
//        Num People 23, number of experiments with one or more shared birthday: 25212, percentage: 50.424
//
//        Num People 24, number of experiments with one or more shared birthday: 27002, percentage: 54.004
//
//        Num People 25, number of experiments with one or more shared birthday: 28271, percentage: 56.542
//
//        Num People 26, number of experiments with one or more shared birthday: 29897, percentage: 59.794
//
//        Num People 27, number of experiments with one or more shared birthday: 31479, percentage: 62.958
//
//        Num People 28, number of experiments with one or more shared birthday: 32742, percentage: 65.484
//
//        Num People 29, number of experiments with one or more shared birthday: 33960, percentage: 67.92
//
//        Num People 30, number of experiments with one or more shared birthday: 35220, percentage: 70.44
//
//        Num People 31, number of experiments with one or more shared birthday: 36715, percentage: 73.43
//
//        Num People 32, number of experiments with one or more shared birthday: 37663, percentage: 75.326
//
//        Num People 33, number of experiments with one or more shared birthday: 38707, percentage: 77.414
//
//        Num People 34, number of experiments with one or more shared birthday: 39868, percentage: 79.736
//
//        Num People 35, number of experiments with one or more shared birthday: 40465, percentage: 80.93
//
//        Num People 36, number of experiments with one or more shared birthday: 41618, percentage: 83.236
//
//        Num People 37, number of experiments with one or more shared birthday: 42369, percentage: 84.738
//
//        Num People 38, number of experiments with one or more shared birthday: 43057, percentage: 86.114
//
//        Num People 39, number of experiments with one or more shared birthday: 44028, percentage: 88.056
//
//        Num People 40, number of experiments with one or more shared birthday: 44496, percentage: 88.992
//
//        Num People 41, number of experiments with one or more shared birthday: 45180, percentage: 90.36
//
//        Num People 42, number of experiments with one or more shared birthday: 45720, percentage: 91.44
//
//        Num People 43, number of experiments with one or more shared birthday: 46224, percentage: 92.448
//
//        Num People 44, number of experiments with one or more shared birthday: 46576, percentage: 93.152
//
//        Num People 45, number of experiments with one or more shared birthday: 47022, percentage: 94.044
//
//        Num People 46, number of experiments with one or more shared birthday: 47391, percentage: 94.782
//
//        Num People 47, number of experiments with one or more shared birthday: 47747, percentage: 95.494
//
//        Num People 48, number of experiments with one or more shared birthday: 48029, percentage: 96.058
//
//        Num People 49, number of experiments with one or more shared birthday: 48324, percentage: 96.648
//
//        Num People 50, number of experiments with one or more shared birthday: 48539, percentage: 97.078
//
//        Num People 51, number of experiments with one or more shared birthday: 48762, percentage: 97.524
//
//        Num People 52, number of experiments with one or more shared birthday: 48901, percentage: 97.802
//
//        Num People 53, number of experiments with one or more shared birthday: 49052, percentage: 98.104
//
//        Num People 54, number of experiments with one or more shared birthday: 49192, percentage: 98.384
//
//        Num People 55, number of experiments with one or more shared birthday: 49309, percentage: 98.618
//
//        Num People 56, number of experiments with one or more shared birthday: 49384, percentage: 98.768
//
//        Num People 57, number of experiments with one or more shared birthday: 49499, percentage: 98.998
//
//        Num People 58, number of experiments with one or more shared birthday: 49595, percentage: 99.19
//
//        Num People 59, number of experiments with one or more shared birthday: 49647, percentage: 99.294
//
//        Num People 60, number of experiments with one or more shared birthday: 49715, percentage: 99.43
//
//        Num People 61, number of experiments with one or more shared birthday: 49746, percentage: 99.492
//
//        Num People 62, number of experiments with one or more shared birthday: 49774, percentage: 99.548
//
//        Num People 63, number of experiments with one or more shared birthday: 49843, percentage: 99.686
//
//        Num People 64, number of experiments with one or more shared birthday: 49861, percentage: 99.722
//
//        Num People 65, number of experiments with one or more shared birthday: 49880, percentage: 99.76
//
//        Num People 66, number of experiments with one or more shared birthday: 49894, percentage: 99.788
//
//        Num People 67, number of experiments with one or more shared birthday: 49916, percentage: 99.832
//
//        Num People 68, number of experiments with one or more shared birthday: 49932, percentage: 99.864
//
//        Num People 69, number of experiments with one or more shared birthday: 49952, percentage: 99.904
//
//        Num People 70, number of experiments with one or more shared birthday: 49965, percentage: 99.93
//
//        Num People 71, number of experiments with one or more shared birthday: 49969, percentage: 99.938
//
//        Num People 72, number of experiments with one or more shared birthday: 49979, percentage: 99.958
//
//        Num People 73, number of experiments with one or more shared birthday: 49978, percentage: 99.956
//
//        Num People 74, number of experiments with one or more shared birthday: 49980, percentage: 99.96
//
//        Num People 75, number of experiments with one or more shared birthday: 49991, percentage: 99.982
//
//        Num People 76, number of experiments with one or more shared birthday: 49985, percentage: 99.97
//
//        Num People 77, number of experiments with one or more shared birthday: 49993, percentage: 99.986
//
//        Num People 78, number of experiments with one or more shared birthday: 49992, percentage: 99.984
//
//        Num People 79, number of experiments with one or more shared birthday: 49996, percentage: 99.992
//
//        Num People 80, number of experiments with one or more shared birthday: 49996, percentage: 99.992
//
//        Num People 81, number of experiments with one or more shared birthday: 49998, percentage: 99.996
//
//        Num People 82, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 83, number of experiments with one or more shared birthday: 49996, percentage: 99.992
//
//        Num People 84, number of experiments with one or more shared birthday: 49997, percentage: 99.994
//
//        Num People 85, number of experiments with one or more shared birthday: 49998, percentage: 99.996
//
//        Num People 86, number of experiments with one or more shared birthday: 49999, percentage: 99.998
//
//        Num People 87, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 88, number of experiments with one or more shared birthday: 49999, percentage: 99.998
//
//        Num People 89, number of experiments with one or more shared birthday: 49999, percentage: 99.998
//
//        Num People 90, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 91, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 92, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 93, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 94, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 95, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 96, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 97, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 98, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 99, number of experiments with one or more shared birthday: 50000, percentage: 100.0
//
//        Num People 100, number of experiments with one or more shared birthday: 50000, percentage: 100.0
 
        
        // CS314 Students: add tests here.

public class CodeCampTester {

    public static void main(String[] args){
        final String newline = System.getProperty("line.separator");
        
        //test 1, hamming distance
        int[] h1 = {-1, 13, 4, 4, -15, -12, 8, 8, 8};
        int[] h2 = {1, 13, 10, 4, -5, 4, 3, -10, 1};
        int expected = 7;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: " + 
                expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 1, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        
        // test 2, hamming distance
        h1 = new int[] {1,1,1,1,1};
        h2 = new int[] {1,2,3,4,5};
        expected = 4;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 2 hamming distance: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 2, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 2, hamming distance");
        
       
        //test 3, isPermutation
        int[] a = {4,5,7,8,0};
        int[] b = {5,0,8,7,4};
        boolean expectedBool = true;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 3 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 3, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 3, isPermutation");

        //test 4, is Permutation
        a = new int []{-1,-2,-3,-4,-5};
        b = new int[]{1,2,3,4,5};
        expectedBool = false;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 4, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 4, isPermutation");
      
        // test 5, mostVowels
        String[] sList = {"Stand ASIDE", "CODING IS FANTASTIC!!!"};
        int expectedResult = 1;
        int actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 5 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 5, mostVowels");
        else
            System.out.println("***** FAILED ***** test 5, mostVowels");

        
        // test 6, mostVowels
        sList = new String[] {"I", "Love", "PIEEEEE", "VERY", "much"};
        expectedResult = 2;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 6 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 6, mostVowels");
        else
            System.out.println("***** FAILED ***** test 6, mostVowels");
        
        
        
        //test 7, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(365, 365);
        int expectedShared = 0;
        System.out.println(newline + "Test 7 shared birthdays: expected: " +
                "a value of 1 or more, actual: " + pairs);
        if( pairs > 0 )
            System.out.println("passed test 7, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 7, shared birthdays");  
        
        //test 8, sharedBirthdays, simple test
        pairs = CodeCamp.sharedBirthdays(1, 1);
        System.out.println(newline + "Test 8 shared birthdays: expected: 0, actual: " + pairs);
        if( pairs == 0 )
            System.out.println("passed test 8, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 8, shared birthdays");        
        
        
        //test 9, queensAreASafe
        char[][] board = { {'.', '.', '.'},
                          {'q', 'q', '.'},
                          {'.', '.', 'q'}};
        
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 9 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 9, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 9, queensAreSafe");

        //test 10, queensAreASafe
        board = new char[][]{{'.', 'q', '.', '.'},
                             {'.', '.', '.', '.'},
                             {'q', '.', 'q', '.'},
                             {'q', '.', 'q', '.'}};
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 10 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 10, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 10, queensAreSafe");
        
        
        
        // test 11, getValueOfMostValuablePlot
        int[][] city = {{0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0},
                          {0, 0, 0, 14, 0},
                          {0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0}};
        
        expected = 14;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 11, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 11, getValueOfMostValuablePlot");


         // test 12, getValueOfMostValuablePlot
        city = new int[][] {{10,10,10,10,10,10}};
        expected = 60;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 12 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 12, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 12, getValueOfMostValuablePlot");
    
        
       //CodeCamp.birthdayExperiment();
        
    } // end of main method
    
    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if(list == null)
            throw new IllegalArgumentException("list parameter may not be null.");
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for(int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
    
    
}