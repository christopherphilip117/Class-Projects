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
public class RingBuffer {
	int size;
	int newCapacity;
	double [] ringBuffer;
	int first;
	int last;
	double trash;
	int maxSize;


	RingBuffer(int capacity){
		trash = -2;
		ringBuffer = new double [capacity];
		for(int i = 0; i < capacity; i++)
			ringBuffer[i] = trash;
		size = 0;
		newCapacity = capacity;
		first = 0;
		last = 0;


	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}

	public boolean isFull(){
		return size == newCapacity;

	}
	public void enqueue(double x){
		if(isFull())
			throw new RuntimeException("Buffer is full");

		ringBuffer[last] = x;
		last++;
		size++;

		if(last == newCapacity){
			last = 0;

		}

	}

	public double dequeue(){
		if(isEmpty())
			throw new RuntimeException("Buffer is empty");


		double take = ringBuffer[first];
		ringBuffer[first] = trash;
		size--;
		first++;

		if(first == newCapacity)
			first = 0;


		return take;
	}

	public double peek(){
		double preview = ringBuffer[first];
		return preview;
	}

	public String toString(){
		String buffer = "";
		buffer = "[" ;
		int x = first;
		for(int i = 0; i < size; i++){
			buffer += ringBuffer[x];
			if(i != size - 1)
				buffer += ", ";
			x++;
			if(x == ringBuffer.length)
				x = 0;
		}
		buffer += "]";

		return buffer;
	}

}






