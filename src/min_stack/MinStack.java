package min_stack;

import java.util.EmptyStackException;
import java.util.Stack;

// Using O(n) space complexity
public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);

		if (this.stack.isEmpty()) {
			minStack.push(val);
			return;
		}

		int minTillNow = minStack.peek();
		if (val < minTillNow) {
			minTillNow = val;
		}
		minStack.push(minTillNow);
	}

	public void pop() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
