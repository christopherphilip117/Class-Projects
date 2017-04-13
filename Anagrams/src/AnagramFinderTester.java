import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class AnagramFinderTester {


	private static final String testCaseFileName = "testCaseAnagrams.txt";
	private static final String dictionaryFileName = "d3.txt";

	public static void main(String[] args) {


		// CS314 Students, delete the above tests when you turn in your assignment
		// CS314 Students add your LetterInventory tests here. 
		int testNum = 1;

		//test 1 constructor and toString
		String testDescrip = "Testing constructor and toString() on constructor with word given.";
		String testWord = "big brown bear";
		LetterInventory testerInventory = new LetterInventory(testWord);
		String expectedString = "abbbeginorrw";
		showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
		testNum++;

		//test 2 constructor and isEmpty();
		testDescrip = "Testing constructor and isEmpty() on default constructor";
		boolean expectedBool = false;
		showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
		testNum++;


		//test 3 test get()
		testDescrip = "Testing get() method";
		testWord = "jared writes great tests";
		testerInventory = new LetterInventory(testWord);
		char getTestChar = 'a';
		int expectedInt = 2;
		showResults(testerInventory.get(getTestChar), expectedInt, testDescrip, testNum);
		testNum++;

		//test 4 test get()
		getTestChar = 'z';
		expectedInt = 0;
		showResults(testerInventory.get(getTestChar), expectedInt, testDescrip, testNum);
		testNum++;

		//test 5 test size()
		testDescrip = "Testing size() method";
		expectedInt = 21;
		showResults(testerInventory.size(), expectedInt, testDescrip, testNum);
		testNum++;

		//test 6 test size()
		testWord = "live long and prosper";
		testerInventory = new LetterInventory(testWord);
		expectedInt = 18;
		showResults(testerInventory.size(), expectedInt, testDescrip, testNum);
		testNum++;

		//test 7 test isEmpty()
		testDescrip = "Testing isEmpty()";
		expectedBool = false;
		showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
		testNum++;

		//test 8 test toString()
		testDescrip = "Testing toString()";
		expectedString = "adeegillnnoopprrsv";
		showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
		testNum++;

		//test 9 test toString()
		testWord = "batcode";
		testerInventory = new LetterInventory(testWord);
		expectedString = "abcdeot";
		showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
		testNum++;

		//test 10 test add()
		testDescrip = "Testing add() method (relies on equal()";
		LetterInventory testerAdd = new LetterInventory("recursion");
		LetterInventory expectedLInv = new LetterInventory("recursionbatcode");
		showResults(testerInventory.add(testerAdd), expectedLInv, testDescrip, testNum);
		testNum++;

		//test 11 test add()
		testerAdd = testerAdd.add(new LetterInventory("recursion"));
		expectedLInv = new LetterInventory("recursion recursion");
		showResults(testerAdd, expectedLInv, testDescrip, testNum);
		testNum++;

		//test 12 test subtract()
		testDescrip = "Testing subtract() (relies on equals())";
		testerInventory = new LetterInventory("apples and bananas");
		expectedLInv = new LetterInventory("applesbananas");
		showResults(testerInventory.subtract(new LetterInventory("and")), expectedLInv, testDescrip, testNum);
		testNum++;

		//test 13 test subtract()
		testerInventory = new LetterInventory("the Joker");
		expectedLInv = new LetterInventory("joker");
		showResults(testerInventory.subtract(new LetterInventory("the")), expectedLInv, testDescrip, testNum);
		testNum++;

		//test 14 test add() and subtract()
		testDescrip = "Testing add() and subtract() (relies on equals())";
		testerInventory = new LetterInventory("Batman and NightWing");
		expectedLInv = new LetterInventory("Batman and Robin");
		testerInventory = testerInventory.subtract(new LetterInventory("nightwing"));
		testerInventory = testerInventory.add(new LetterInventory("RobIn"));
		showResults(testerInventory, expectedLInv, testDescrip, testNum);
		testNum++;


		//test 15 test equals()
		testerInventory = new LetterInventory("I pity the fool");
		expectedLInv = new LetterInventory("i PITY the Fool");
		showResults(testerInventory, expectedLInv, testDescrip, testNum);
		testNum++;

		//test 16 test isEmpty()
		testerInventory = new LetterInventory("");
		testDescrip = "Testing isEmpty()";
		expectedBool = true;
		showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
		testNum++;

	}

	public static void showResults(Object actual, Object expected, String testDescrip, int testNum){
		StringBuilder result = new StringBuilder();
		result.append("Test num: " + testNum);
		result.append("\n" + testDescrip);
		result.append("\n...............");
		if(actual.equals(expected)){
			result.append("\nActual: " + actual + "\nExpected: " + expected + "\n You have passed");
		}else{
			result.append("\nActual: " + actual + "\nExpected: " + expected + "\n TEST FAILED!!!!!!");
		}
		result.append("\n");

		System.out.println(result);



		// tests on the anagram solver itself
		//        boolean displayAnagrams = getChoiceToDisplayAnagrams();
		//        AnagramSolver solver = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
		//        runAnagramTests(solver, displayAnagrams);
		//    }
		//
		//    private static boolean getChoiceToDisplayAnagrams() {
		//        Scanner console = new Scanner(System.in);
		//        System.out.print("Enter y or Y to display anagrams during tests: ");
		//        String response = console.nextLine();
		//        return response.length() > 0 && response.toLowerCase().charAt(0) == 'y';
		//    }
		//
		//    public static boolean showTestResults(Object expected, Object actual, int testNum, String featureTested) {
		//        System.out.println("Test Number " + testNum + " testing " + featureTested);
		//        System.out.println("Expected result: " + expected);
		//        System.out.println("Actual result: " + actual);
		//        boolean passed = (actual == null && expected == null) || actual.equals(expected);
		//        if(passed)
		//            System.out.println("Passed test " + testNum);
		//        else
		//            System.out.println("!!! FAILED TEST !!! " + testNum);
		//        System.out.println();
		//        return passed;
		//    }

		/**
		 * Method to run tests on Anagram solver itself.
		 * pre: the files d5.txt and testCaseAnagrams.txt are in the local directory
		 * 
		 * assumed format for file is
		 * <NUM_TESTS>
		 * <TEST_NUM>
		 * <MAX_WORDS>
		 * <PHRASE>
		 * <NUMBER OF ANAGRAMS>
		 * <ANAGRAMS>
		 */
		//    private static void runAnagramTests(AnagramSolver solver, boolean displayAnagrams) {
		//        int solverTestCases = 0;
		//        int solverTestCasesPassed = 0;
		//        Stopwatch st = new Stopwatch();
		//        try {
		//            Scanner sc = new Scanner(new File(testCaseFileName));
		//            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
		//            System.out.println(NUM_TEST_CASES);
		//            for(int i = 0; i < NUM_TEST_CASES; i++) {
		//                // expected results
		//                TestCase currentTest = new TestCase(sc);
		//                solverTestCases++;
		//                st.start();
		//                // actual results
		//                List<List<String>> actualAnagrams = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
		//                st.stop();
		//                if(displayAnagrams) {
		//                    displayAnagrams("actual anagrams", actualAnagrams);
		//                    displayAnagrams("expected anagrams", currentTest.anagrams);
		//                }
		//
		//
		//                if(checkPassOrFailTest(currentTest, actualAnagrams))
		//                    solverTestCasesPassed++;
		//                System.out.println("Time to find anagrams: " + st.time());
		//            }
		//        }
		//        catch(Exception e) { //TODO CHANGE BACK TO Exception e
		//            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
		//                    " that file testCaseAnagrams.txt is in the correct location.");
		//            System.out.println(e);
		//            System.out.println("AnagramSolver test cases run: " + solverTestCases);
		//            System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
		//        }
		//        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
		//        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
		//    }
		//
		//
		//    // print out all of the anagrams in a list of anagram
		//    private static void displayAnagrams(String type,
		//            List<List<String>> anagrams) {
		//
		//        System.out.println("Results for " + type);
		//        System.out.println("num anagrams: " + anagrams.size());
		//        System.out.println("anagrams: ");
		//        for(List<String> singleAnagram : anagrams)
		//            System.out.println(singleAnagram);
		//    }
		//
		//
		//    // determine if the test passed or failed
		//    private static boolean checkPassOrFailTest(TestCase currentTest,
		//            List<List<String>> actualAnagrams) {
		//        System.out.println();
		//        if(actualAnagrams.equals(currentTest.anagrams)) {
		//            System.out.println("Passed test " + currentTest.testCaseNumber);
		//            return true;
		//        }
		//        else{
		//            System.out.println("\nFailed test case " + currentTest.testCaseNumber);
		//            System.out.println("PHRASE:    " + currentTest.phrase);
		//            System.out.println("MAX WORDS: " + currentTest.maxWords);
		//            System.out.println("Recall MAXWORDS = 0 means no limit.");
		//            System.out.println("Expected number of anagrams: " + currentTest.anagrams.size());
		//            System.out.println("Actual number of anagrams:   " + actualAnagrams.size());
		//            if(currentTest.anagrams.size() == actualAnagrams.size()) {
		//                System.out.println("Sizes the same, but either a difference in anagrams or anagrams not in correct order.");
		//            }
		//            System.out.println();
		//            return false;
		//        }  
		//    }
		//
		//    // class to handle the parameters for an anagram test 
		//    // and the expected reuslt
		//    private static class TestCase {
		//
		//        private int testCaseNumber;
		//        private String phrase;
		//        private int maxWords;
		//        private List<List<String>> anagrams;
		//
		//        // pre: sc is positioned at the start of a test case
		//        private TestCase(Scanner sc) {
		//            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
		//            maxWords = Integer.parseInt(sc.nextLine().trim());
		//            phrase = sc.nextLine().trim();
		//            anagrams = new ArrayList<List<String>>();
		//            readAndStoreAnagrams(sc);
		//        }
		//
		//        // pre: sc is positioned at the start of the resulting angrams
		//        // read in the number of angrams and then for each anagram:
		//        //  - read in the line
		//        //  - break the line up into words
		//        //  - create a new list of Strings for the anagram
		//        //  - add each word to the anagram
		//        //  - add the anagram to the list of anagrams
		//        private void readAndStoreAnagrams(Scanner sc) {
		//            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
		//            for(int j = 0; j < numAnagrams; j++){
		//                String[] words = sc.nextLine().split("\\s+");
		//                ArrayList<String> anagram = new ArrayList<String>();
		//                for(String st : words)
		//                    anagram.add(st);
		//                anagrams.add(anagram);
		//            }
		//            assert anagrams.size() == numAnagrams : "Wrong number of angrams read or expected";
		//        }
	}
}