package using_stack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public MyQueue() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	public void enqueue(int val) {
		stack1.push(val);
	}

	public int dequeue() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return -1;
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}
	
}
