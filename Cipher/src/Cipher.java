import java.util.Scanner;

/**
 * CS312 Assignment 5.
 * 
 * On my honor, <Christopher Philip>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to encrypt and decrypt messages using a columnar transposition cipher.
 *
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Unique 5 digit course ID: 52800
 *  Grader name: Eric
 *  Number of slip days used on this assignment: 0 
 */

public class Cipher {

    // CS312 Students: This constant must be set to 10 in the
    // final version of your program that your turn in.
    public static final int MAX_ROWS = 10;

    // main method to demonstrate various encryptions and
    // decryptions using a columnar transposition cipher
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        showIntro();
        encrypt(keyboard);

        keyboard.close();
        
    }


    // show the introduction to the program
    public static void showIntro() {
        System.out.println("This program demonstrates a transposition cipher.");
        System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
        System.out.println();
        System.out.println("This program will demonstrate encrypting a message with");
        System.out.println("a columnar transposition cipher both with and without");
        System.out.println("padding characters. The program will then decrypt a message");
        System.out.println("assuming it was encrypted with a columnar transposition cipher");
        System.out.println("with padding.");
        System.out.println("After accepting user input, the program displays some tests.");
    }
    
    //This method establishes the message to encrypt and decrypt by the program, inputed by a person
    //
    public static void encrypt(Scanner keyboard){
    	System.out.println("\n");
    	System.out.println("A demonstration of encrypting with a columnar transposition cipher:");
    	System.out.println();
    	System.out.print("Enter the message to encrypt: ");
    	String message = keyboard.nextLine();
    	System.out.println();
    	nopadResult(message); //The final result of the unpadded encryption
    	System.out.println();
    	padResult(message); //The padded result of the padded encryption
    	
    	System.out.println();
    	System.out.println("A demonstration of decrypting with a columnar transposition cipher:" + "\n" +
    			"If the length of the message is not a multiple of the number of rows" + "\n" + 
    			"it will be padded which may throw off the decryption.");
    	
    	System.out.println();
    	System.out.print("Enter the message to decrypt: ");
    	String message2 = keyboard.nextLine();
    	System.out.println();
    	
    	decryptResult(message2); //The padded final decryption result from the encrypted string
    
    }
    
    //This method uses a while loop to increment each row itereation for encryption
    public static void nopadResult(String message){
    	System.out.println("Message encrypted with columnar transposition cipher and no padding.");
    	int count = 2;
    	while (count <= 10){
    		nopadding(message, count);
    		count++;
    	}
    }
    
    //This method uses the length of the string and row count to navigate the string, and print out 
    //the correct encryption within the parameters of the established rows
    public static void nopadding(String message, int row){
    	System.out.print("Encrypted with " + row + " rows: ");
    	int x = 0;
    	for (int i = 1; i<= row; i++){
    		for(int  j = x; j < message.length(); j+=row){
    			System.out.print(message.charAt(j));
    			}
    		x++;
    	}
    	System.out.println();
    	
    }
    
    //Uses a while loop to increment the row iteration for the padded encryption
    public static void padResult(String message){
    	System.out.println("Message encrypted with columnar transposition cipher and padding.");
    	System.out.println();
    	int count = 2;
    	while (count <= 10){
    	padding(message, count);
    	count++;
    	}
    	
    }
    
    //An equation is used to determine the amount of padding needed for the string
    //The pads are added to the string, and the result is sent to the nopadding method 
    //for the final loops for encryption
    public static void padding (String message, int row){
    	System.out.print("Clear text padded for " + row + " rows: ");
    	int column = (message.length() / row) + Math.min(1, message.length() % row);
    	int charsNeeded = column  * row;
    	int charsPadding = charsNeeded - message.length();
    	for(int i = 1; i <= charsPadding; i++){
    		message += "X";
    	}
    	System.out.print(message);
    	System.out.println();
    	nopadding(message, row);
    	System.out.println();
    	
    }
    
    //Uses the same element of while loops for the decryption part of the program
    //if statement used to only add a new line if the line printed is not the last line in the program
   public static void decryptResult (String message2){
	   System.out.println("Messages Decrypted with a Columnar Transposition Cipher");
	   
	   int count = 2;
	   while (count <= 10){
		   if (count < 10){
			   decrypting(message2, count);
			   count++;
			   System.out.println();
		   }
		   else if (count == 10){
			   decrypting(message2, count);
			   count++;
			
		   }
		  
	   }
	   
   }
   
   //Establishes the amount of padding needed for the encrypted string
   public static void decrypting(String message2, int row){
	   System.out.print("\n" + "Decrypted text padded for " + row + " rows: ");
	   
   	int column = (message2.length() / row) + Math.min(1, message2.length() % row);
   	int charsNeeded = column  * row;
   	int charsPadding = charsNeeded - message2.length();
   	for(int i = 1; i <= charsPadding; i++){
   		message2 += "X";
   	}
   	System.out.print(message2);
   	System.out.println();
   	decryptPad(message2, row, column);
   	
	   
   }
   
   //This method uses the columns established in the previous method to increment and print each part
   //of the string. Decrypts using columns based on the number of rows used.
   public static void decryptPad(String message2, int row, int column){
	   System.out.print("Decrypted with " + row + " rows: ");
	   int x = 0;
	   for (int i = 1; i <= column; i++){
		   for(int j = x; j < message2.length(); j+=column){
			   System.out.print(message2.charAt(j));
		   }
		   x++;
	   }
	   
	   
	   
   }

   
   
   
   
  
}
