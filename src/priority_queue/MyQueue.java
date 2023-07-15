package priority_queue;

import java.util.Arrays;

public class MyQueue {

	private int[] items;
	private int front;
	private int rear;
	private int size;
	private int count;

	public MyQueue(int size) {
		this.items = new int[size];
		this.size = size;
		this.front = -1;
		this.rear = 0;
		this.count = 0;
	}

	public void enqueue(int val) {
		if (count == size) {
			System.out.println("Queue is full");
			return;
		}
		
		// in priority queue we need to insert element based on sorting
		int i=0;
		// start from right side (rear) check if value is less than element moving from end to start, if not then shift that element to right otherwise insert val
		for (i = rear; i > 0; i--) {
			// if val is less than item then break loop
			if (items[i - 1] <= val) {
				break;
			}
			//	otherwise shift to right
			if (items[i - 1] > val) {
				// shift the element to right
				items[i] = items[i - 1];
			}
		}
		
		items[i] = val;
		// to maintain cyclic array so when we remove elements from front we can still
		// utilize that space
		rear = (rear + 1) % size;
		count++;
	}

	public int dequeue() {
		if (count == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		front = (front + 1) % size;
		count--;
		int val = items[front];
		items[front] = 0;
		return val;
	}
	
	public int Front() {
        if(count==0){
            return -1;
        }else{
            return items[(front+1)%size];
        }
    }
    
    public int Rear() {
        if(count==0){
            return -1;
        }else{
            int lastIndex=rear-1;
            // if rear is at 0 because of circular queue
            if(lastIndex==-1){
                lastIndex=size-1;
            }
            return items[lastIndex];
        }
    }
    
    public boolean isEmpty() {
        if(count==0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull() {
       if(this.count==this.size){
           return true;
       } else{
           return false;
       }
    }

	public String toString() {
		return Arrays.toString(items);
	}

}