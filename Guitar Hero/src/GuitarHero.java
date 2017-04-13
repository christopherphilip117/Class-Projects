/**
 * CS312 Assignment 12.
 * 
 * On my honor, <Christopher Philip>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Guitar Hero.
 *
 *  email address: christopher.philip117@gmail.com
 *  UTEID: cp26645
 *  Unique 5 digit course ID: 52800
 *  Grader name: Eric
 *  Number of slip days used on this assignment: 0
 */
public class GuitarHero {
	public static void main(String[] args) {
	
	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	
	GuitarString[] frequency = new GuitarString[37];
	
	for(int i =0; i < frequency.length; i++){
		frequency[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
	}
	
	final double TEXT_POS_X = .5;
    final double TEXT_POS_Y = .5;
    
    StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Type a key, " + keyboard + " , to play");
	play(frequency, keyboard);
	
	}
	
	private static void play(GuitarString[] frequency, String keyboard) {        // the main input loop
        while (true) {
            
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                    
                	if(keyboard.indexOf(key) != -1){
                		int position = keyboard.indexOf(key);
                		frequency[position].pluck();
                	}
                
                
            }

            // compute the superposition of the samples
//            double sample = stringA.sample() + stringC.sample();
            double sample = 0;
            for(int i = 0; i < frequency.length; i++)
            	sample += frequency[i].sample();
            	

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < frequency.length; i++){
            	frequency[i].tic();
             }
        }
        
    }

}
