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
public class GuitarString {
	
	public RingBuffer ringBuff;
	int tics = 0;
	int N;
	public GuitarString(double frequency){
		N = (int)(44100/frequency);
		ringBuff = new RingBuffer(N);
		for(int i = 0; i < N; i++)
			ringBuff.enqueue(0.0);
		
	}
	
	public GuitarString(double[] init){
		int size = init.length;
		ringBuff = new RingBuffer(size);
		for(int i = 0; i < size; i++)
			ringBuff.enqueue(init[i]);
	}
	
	public void pluck(){
		
		for(int i = 0; i < N; i++){
			ringBuff.dequeue();
			
		}
		for(int i = 0; i < N; i++)
			ringBuff.enqueue(Math.random() - 0.5);
		}
	
	public double sample(){
		return ringBuff.peek();
	}
	
	public void tic(){
		double value = ringBuff.dequeue();
		double value2 = ringBuff.peek();
		double average = ((value + value2)/2) * .994;
		ringBuff.enqueue(average);
		tics++;
	}
	
	public int time(){
		return tics;
	}
		
	}