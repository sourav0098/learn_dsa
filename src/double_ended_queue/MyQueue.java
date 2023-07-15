package double_ended_queue;

//Deque (Double Ended Queue)
//In a double ended queue, insertion and removal of elements can be performed from either from the front or rear. Thus, it does not follow the FIFO (First In First Out) rule.
public class MyQueue {
	public int[] arr;
	public int size;
	public int front;
	public int rear;
	public int count;

	public MyQueue(int size) {
		this.arr = new int[size];
		this.size = size;
		this.count = 0;
		this.front = 0;
		this.rear = 0;
	}

	public void pushRear(int val) {
		if (size != count) {
			arr[rear] = val;
			rear = (rear + 1) % size;
			count++;
		} else {
			System.out.println("Stack is full");
		}
	}

	public void pushFront(int val) {
		if (size != count) {
			front--;
			if (front == -1) {
				front = size - 1;
			}
			arr[front] = val;
			count++;
		} else {
			System.out.println("Stack is full");
		}
	}

	public boolean popRear() {
		if (isEmpty()) {
			return false;
		} else {
			rear--;
			if (rear == -1) {
				rear = size - 1;
			}
			arr[rear] = 0;
			return true;
		}
	}

	public boolean popFront() {
		if (isEmpty()) {
			return false;
		} else {
			arr[front] = 0;
			front = (front + 1) % size;
			count--;
			return true;
		}
	}

	public int getFront() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[front];
		}
	}

	public int getRear() {
		if (isEmpty()) {
			return -1;
		} else {
			int rearIndex = rear - 1;
			if (rearIndex == -1) {
				rearIndex = size - 1;
			}

			return arr[rearIndex];

		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == size;
	}
}
