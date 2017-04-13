import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

//*  On my honor, <Christopher Philip>, this programming assignment is my own work
//*  and I have not provided this code to any other student.
//*
//*  Name: Christopher Philip
//*  email address: christopher.philip117@gmail.com
//*  UTEID: cp26645
//*  Section 5 digit ID: 88620
//*  Grader name: Kris Vandercook
//*  Number of slip days used on this assignment: 2
/*
 * 
 * TEST RESULTS:
 * 
 * 
Random: average of 0.0023216000000000005 seconds to add 1000 items to the BST.
Random: height of 21 rows when it has 1000 items.
Random: size of 1000 items when 1000 supposed to be added
 
Random: average of 4.5430000000000004E-4 seconds to add 2000 items to the BST.
Random: height of 23 rows when it has 2000 items.
Random: size of 2000 items when 2000 supposed to be added
 
Random: average of 8.636000000000002E-4 seconds to add 4000 items to the BST.
Random: height of 26 rows when it has 4000 items.
Random: size of 4000 items when 4000 supposed to be added
 
Random: average of 0.0020273999999999995 seconds to add 8000 items to the BST.
Random: height of 29 rows when it has 8000 items.
Random: size of 8000 items when 8000 supposed to be added
 
Random: average of 0.0036239 seconds to add 16000 items to the BST.
Random: height of 32 rows when it has 16000 items.
Random: size of 16000 items when 16000 supposed to be added
 
Random: average of 0.007579299999999999 seconds to add 32000 items to the BST.
Random: height of 36 rows when it has 32000 items.
Random: size of 31999 items when 32000 supposed to be added
 
Random: average of 0.025862200000000002 seconds to add 64000 items to the BST.
Random: height of 38 rows when it has 64000 items.
Random: size of 63999 items when 64000 supposed to be added
 
Random: average of 0.0573187 seconds to add 128000 items to the BST.
Random: height of 39 rows when it has 128000 items.
Random: size of 127998 items when 128000 supposed to be added
 
Random: average of 0.125418 seconds to add 256000 items to the BST.
Random: height of 43 rows when it has 256000 items.
Random: size of 255992 items when 256000 supposed to be added
 
Random: average of 0.34053419999999995 seconds to add 512000 items to the BST.
Random: height of 46 rows when it has 512000 items.
Random: size of 511969 items when 512000 supposed to be added
 
Random: average of 0.8563221000000001 seconds to add 1024000 items to the BST.
Random: height of 49 rows when it has 1024000 items.
Random: size of 1023876 items when 1024000 supposed to be added
 
Order: average of 0.002457 seconds to add 1000 items to the BST.
Order: height of 1000 rows when it has 1000 items.
Order: size of 1000 items when 1000 supposed to be added.
 
Order: average of 0.0059024 seconds to add 2000 items to the BST.
Order: height of 2000 rows when it has 2000 items.
Order: size of 2000 items when 2000 supposed to be added.
 
Order: average of 0.0376904 seconds to add 4000 items to the BST.
Order: height of 4000 rows when it has 4000 items.
Order: size of 4000 items when 4000 supposed to be added.
 
Order: average of 0.15188909999999997 seconds to add 8000 items to the BST.
Order: height of 8000 rows when it has 8000 items.
Order: size of 8000 items when 8000 supposed to be added.
 
Order: average of 0.5868613 seconds to add 16000 items to the BST.
Order: height of 16000 rows when it has 16000 items.
Order: size of 16000 items when 16000 supposed to be added.
 
Order: average of 2.2993116000000002 seconds to add 32000 items to the BST.
Order: height of 32000 rows when it has 32000 items.
Order: size of 32000 items when 32000 supposed to be added.
 
Order: average of 9.2999074 seconds to add 64000 items to the BST.
Order: height of 64000 rows when it has 64000 items.
Order: size of 64000 items when 64000 supposed to be added.
 
Order: average of 38.157121000000004 seconds to add 128000 items to the BST.
Order: height of 128000 rows when it has 128000 items.
Order: size of 128000 items when 128000 supposed to be added.
 
Order: average of 204.44919939999997 seconds to add 256000 items to the BST.
Order: height of 256000 rows when it has 256000 items.
Order: size of 256000 items when 256000 supposed to be added.

Order: It took an average of 503.328157628159 seconds to add 512000 items to the BST.
Order:  height of 512000 rows when it has 512000 items.
Order:  size of 512000 items when 512000 supposed to be added.
 
Order: It took an average of 1593.3286157904 seconds to add 1024000 items to the BST.
Order:  height of 1024000 rows when it has 1024000 items.
Order:  size of 1024000 items when 1024000 supposed to be added.
 
TreeSet Order:: It took an average of 0.00743629057170000020015 seconds to add 1000 items to the BST.
TreeSet Order::  size of 1000 items when 1000 supposed to be added.
 
TreeSet Order:: It took an average of 7.5035562999999999E-4 seconds to add 2000 items to the BST.
TreeSet Order::  size of 2000 items when 2000 supposed to be added.
 
TreeSet Order:: It took an average of 0.00105645663 seconds to add 4000 items to the BST.
TreeSet Order::  size of 4000 items when 4000 supposed to be added.
 
TreeSet Order:: It took an average of 0.00263547307 seconds to add 8000 items to the BST.
TreeSet Order::  size of 8000 items when 8000 supposed to be added.
 
TreeSet Order:: It took an average of 0.004025458703 seconds to add 16000 items to the BST.
TreeSet Order::  size of 16000 items when 16000 supposed to be added.
 
TreeSet Order:: It took an average of 0.0065808845500000001 seconds to add 32000 items to the BST.
TreeSet Order::  size of 32000 items when 32000 supposed to be added.
 
TreeSet Order:: It took an average of 0.014360616900000001 seconds to add 64000 items to the BST.
TreeSet Order::  size of 64000 items when 64000 supposed to be added.
 
TreeSet Order:: It took an average of 0.0373922960000001 seconds to add 128000 items to the BST.
TreeSet Order::  size of 128000 items when 128000 supposed to be added.
 
TreeSet Order:: It took an average of 0.06843688531 seconds to add 256000 items to the BST.
TreeSet Order::  size of 256000 items when 256000 supposed to be added.
 
TreeSet Order:: It took an average of 0.16478392151298886 seconds to add 512000 items to the BST.
TreeSet Order::  size of 512000 items when 512000 supposed to be added.
 
TreeSet Order:: It took an average of 0.76482024739000009 seconds to add 1024000 items to the BST.
TreeSet Order::  size of 1024000 items when 1024000 supposed to be added.



How do these times compare to the times it took for you BinarySearchTree class when inserting integers in sorted order? 

- When using the TreeSet, it was noticably more efficient and faster than using the binary tree

What do you think is the cause for these differences?

- This is due to the fact that we use naive methods and algorithms to make our trees,
resulting in very unbalanced trees, and less efficient code.

 */

public class BSTTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
        BinarySearchTree<Integer> emptyBST = new BinarySearchTree<>();

        String num = "1.1";
        String type = "Add method";
        BinarySearchTree<Integer> bst5 = new BinarySearchTree<>();
        bst5.add(10);
        bst5.add(13);
        bst5.add(12);
        bst5.add(-500);

        ArrayList<Integer> test4 = new ArrayList<>();
        test4.add(-500);
        test4.add(10);
        test4.add(12);
        test4.add(13);

        List<Integer> test3 = bst5.getAll();
        if (test3.equals(test4)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test4);
            System.out.println(test3);
        }

        num = "1.2";

        if (!bst5.add(-500) && test3.equals(test4)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test4);
            System.out.println(test3);
        }

        num = "1.3";
        if (!bst5.add(10) && test3.equals(test4)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test4);
            System.out.println(test3);
        }

        bst1.add(20);
        bst1.add(21);
        bst1.add(22);
        bst1.add(19);

        // Get all test
        type = "Get All method";
        num = "Test 2.1";

        bst1 = new BinarySearchTree<>();
        bst1.add(30);
        bst1.add(25);
        bst1.add(20);
        bst1.add(22);
        bst1.add(50);
        bst1.add(40);
        bst1.add(35);
        bst1.add(45);
        bst1.add(55);
        bst2 = bst1;

        ArrayList<Integer> conTest = new ArrayList<>();

        conTest.add(30);
        conTest.add(25);
        conTest.add(20);
        conTest.add(22);
        conTest.add(50);
        conTest.add(40);
        conTest.add(35);
        conTest.add(45);
        conTest.add(55);
        Collections.sort(conTest);

        List<Integer> test = bst1.getAll();
        if (test.equals(conTest)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        // Empty test
        num = "Test 2.2";

        bst1 = new BinarySearchTree<>();

        conTest = new ArrayList<>();

        Collections.sort(conTest);

        test = bst1.getAll();
        if (test.equals(conTest)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        type = "Iterative add method";
        num = "Test 3.1";

        bst1 = new BinarySearchTree<>();
        bst1.iterativeAdd(10);
        bst1.iterativeAdd(20);
        bst1.iterativeAdd(5);

        conTest = new ArrayList<>();

        conTest.add(5);
        conTest.add(10);
        conTest.add(20);
        Collections.sort(conTest);

        test = bst1.getAll();
        if (test.equals(conTest)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "Test 3.2";

        bst1 = new BinarySearchTree<>();
        bst1.iterativeAdd(10);
        bst1.iterativeAdd(20);
        bst1.iterativeAdd(30);
        bst1.iterativeAdd(40);

        conTest = new ArrayList<>();

        conTest.add(10);
        conTest.add(20);
        conTest.add(30);
        conTest.add(40);
        Collections.sort(conTest);

        test = bst1.getAll();
        if (test.equals(conTest)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        // size check
        if (bst1.size() == conTest.size()) {
            System.out.println("PASSED: " + "Size check " + num);
        } else {
            System.out.println("FAILED: " + "Size check " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "Test 3.3";

        type = "Iterative add";
        bst1 = new BinarySearchTree<>();
        bst1.iterativeAdd(10);
        bst1.iterativeAdd(20);
        bst1.iterativeAdd(30);
        bst1.iterativeAdd(40);
        bst1.iterativeAdd(40);

        conTest = new ArrayList<>();

        conTest.add(10);
        conTest.add(20);
        conTest.add(30);
        conTest.add(40);
        Collections.sort(conTest);

        test = bst1.getAll();
        if (test.equals(conTest)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        // size check
        type = "Size check 2";
        if (bst1.size() == conTest.size()) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        // remove Check
        BinarySearchTree<Integer> bst4 = new BinarySearchTree<>();
        bst4.add(15);
        bst4.add(11);
        bst4.add(5);
        bst4.add(14);
        bst4.add(20);
        bst4.add(33);
        bst4.add(16);

        ArrayList<Integer> test2 = new ArrayList<Integer>();
        test2.add(5);
        test2.add(14);
        test2.add(15);
        test2.add(16);
        test2.add(20);
        test2.add(33);

        num = "4.1";
        type = "Remove Method test";
        bst4.remove(11);

        if (bst4.getAll().equals(test2)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(bst4.getAll());
            System.out.println(test2);
        }

        // size check
        if (bst4.size() == test2.size()) {
            System.out.println("PASSED: " + "Size check " + num);
        } else {
            System.out.println("FAILED: " + "Size check " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        bst4 = new BinarySearchTree<>();
        bst4.add(15);
        bst4.add(11);
        bst4.add(5);
        bst4.add(14);
        bst4.add(20);
        bst4.add(33);
        bst4.add(16);

        test2 = new ArrayList<Integer>();
        test2.add(5);
        test2.add(11);
        test2.add(14);
        test2.add(16);
        test2.add(20);
        test2.add(33);

        num = "4.3";

        if (bst4.remove(15) && bst4.getAll().equals(test2)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(bst4.getAll());
            System.out.println(test2);
        }

        // size check
        if (bst4.size() == test2.size()) {
            System.out.println("PASSED: " + "Size check " + num);
        } else {
            System.out.println("FAILED: " + "Size check " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        if (!(bst4.remove(300) && bst4.getAll().equals(test2))) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(bst4.getAll());
            System.out.println(test2);
        }

        // Num at depth test
        type = "numNodesAtDepth test";
        num = "5.1";
        if (bst1.numNodesAtDepth(3) == 1) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "5.2";
        if (bst1.numNodesAtDepth(0) == 1) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "5.3";
        if (bst1.numNodesAtDepth(1) == 1) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "5.4";
        if (bst1.numNodesAtDepth(5) == 0) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        num = "5.5";
        // bst2 is [20, 22, 25, 30, 35, 40, 45, 50, 55]
        if (bst2.numNodesAtDepth(3) == 3) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }
        num = "5.6";
        if (bst2.numNodesAtDepth(2) == 3) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        bst1 = new BinarySearchTree<>();
        // empty test
        num = "5.7";

        if (bst1.numNodesAtDepth(2) == 0) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(test);
            System.out.println(conTest);
        }

        // get(kth) method
        bst3 = new BinarySearchTree<>();
        bst3.add(10);
        type = "get(kth) method test";
        num = "6.0";
        if (bst3.get(0) == 10) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(bst3.get(0));
            System.out.println(10);
        }

        type = "get(kth) method test";
        num = "6.1";
        if (bst2.get(1) == 22) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(bst2.get(1));
            System.out.println(22);
        }

        int actVal = bst2.get(0);
        int expected = 20;
        num = "6.2";
        if (actVal == expected) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actVal);
            System.out.println(expected);
        }

        actVal = bst2.get(3);
        expected = 30;
        num = "6.3";
        if (actVal == expected) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actVal);
            System.out.println(expected);
        }

        actVal = bst2.get(8);
        expected = 55;
        num = "6.4";
        if (actVal == expected) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actVal);
            System.out.println(expected);
        }

        actVal = bst2.get(6);
        expected = 45;
        num = "6.5";
        if (actVal == expected) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actVal);
            System.out.println(expected);
        }

        List<Integer> actual = bst2.getAllGreaterThan(50);
        List<Integer> expList = new ArrayList<>();
        expList.add(55);

        type = "getGreaterThan method";
        num = "7.1";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        actual = bst2.getAllGreaterThan(25);
        expList = new ArrayList<>();
        expList.add(30);
        expList.add(35);
        expList.add(40);
        expList.add(45);
        expList.add(50);
        expList.add(55);

        num = "7.2";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        actual = bst2.getAllGreaterThan(60);
        expList = new ArrayList<>();

        num = "7.3";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        actual = bst2.getAllLessThan(22);
        expList = new ArrayList<>();
        expList.add(20);

        type = "getLessThan method";
        num = "8.1";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        actual = bst2.getAllLessThan(55);
        expList = new ArrayList<>();
        expList.add(20);
        expList.add(22);
        expList.add(25);
        expList.add(30);
        expList.add(35);
        expList.add(40);
        expList.add(45);
        expList.add(50);

        type = "getLessThan method";
        num = "8.2";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        actual = bst2.getAllLessThan(-1);
        expList = new ArrayList<>();

        type = "getLessThan method";
        num = "8.3";
        if (actual.equals(expList)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            System.out.println(actual);
            System.out.println(expList);
        }

        type = "max method";
        num = "9.1";

        if (bst2.max() == 55) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst2.printTree();
        }

        num = "9.2";
        BinarySearchTree<Integer> bst6 = new BinarySearchTree<>();
        bst6.add(0);
        if (bst6.max() == 0) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst6.printTree();
        }

        type = "min method";
        num = "10.1";

        if (bst2.min() == 20) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst2.printTree();
        }

        num = "10.2";
        if (bst6.min() == 0) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst6.printTree();
        }

        type = "height method";
        num = "11.1";

        if (bst6.height() == 0) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst6.printTree();
        }

        type = "height method";
        num = "11.1";

        bst6.add(1);
        bst6.add(2);
        bst6.add(3);
        bst6.add(4);
        bst6.add(5);
        bst6.add(6);
        bst6.add(7);

        num = "11.2";
        if (bst6.height() == 7) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst6.printTree();
        }

        num = "11.3";
        if (emptyBST.height() == -1) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst6.printTree();
        }

        type = "isPresent method";
        num = "12.1";
        if (bst2.isPresent(20)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst2.printTree();
        }

        num = "12.2";
        if (!bst2.isPresent(300)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
            bst2.printTree();
        }

        num = "12.3";
        if (!emptyBST.isPresent(300)) {
            System.out.println("PASSED: " + type + " " + num);
        } else {
            System.out.println("FAILED: " + type + " " + num);
        }
        
        questionsTest();

    }
    
    private static void questionsTest(){
		Random r = new Random();
		Stopwatch s = new Stopwatch();
		
		for(int n = 1000; n <= 1024000; n *= 2){
			
			double averageTime = 0;
			int avgHeight = 0;
			int averageSize = 0;
			for(int index = 0; index < 10; index++){
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					b.add( r.nextInt() );
				}
				s.stop();
				averageTime += s.time();
				avgHeight += b.height();
				averageSize += b.size();
				
			}
			System.out.println("Random: average of " + averageTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("Random: height of " + avgHeight/10 + " rows when it has " + n + " items.");
			System.out.println("Random: size of " + averageSize/10 + " items when " + n + " supposed to be added");
			System.out.println(" ");
		}

		for(int n = 1000; n <= 1024000; n *= 2){
			
			double averageTime = 0;
			int avgHeight = 0;
			int averageSize = 0;
			for(int index = 0; index < 10; index++){
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					b.iterativeAdd(i);
				}
				s.stop();
				averageTime += s.time();
				averageSize += b.size();
			}
			System.out.println("Order: average of " + averageTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("Order: height of " + averageSize/10 + " rows when it has " + n + " items.");
			System.out.println("Order: size of " + averageSize/10 + " items when " + n + " supposed to be added.");
			System.out.println(" ");
		}

		for(int n = 1000; n <= 1024000; n *= 2){
			
			double averageTime = 0;
			int averageSize = 0;
			for(int index = 0; index < 10; index++){
				TreeSet<Integer> t = new TreeSet<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					t.add(i);
				}
				s.stop();
				averageTime += s.time();
				averageSize += t.size();
			}
			System.out.println("TreeSet Order:: average of " + averageTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("TreeSet Order:: size of " + averageSize/10 + " items when " + n + " supposed to be added.");
			System.out.println(" ");
		}
	}

}
