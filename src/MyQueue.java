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
		items[rear] = val;

		// to maintain cyclic array so when we remove elements from front we can still utilize that space
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

	public String toString() {
		return Arrays.toString(items);
	}

}