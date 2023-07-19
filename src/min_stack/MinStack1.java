package min_stack;

import java.util.Stack;

// O(1) SC
public class MinStack1 {

	int minElement;
	Stack<Integer> stack;

	public MinStack1() {
		this.stack = new Stack<>();
		this.minElement = 0;
	}

	public void push(int val) {

		// if stack is empty just push the value in stack and minElement
		if (this.stack.isEmpty()) {
			stack.push(val);
			this.minElement = val;
		} else {
			// if I/P value is greater or equal to minElement then just push in stack
			if (val >= minElement) {
				stack.push(val);
			}
			// is val is smaller than minElement then make a new value using formula and add
			// in stack
			else {
				int newValue = 2 * val - minElement;
				stack.push(newValue);

				// update minElement
				this.minElement = val;
			}
		}
	}

	public int pop() {
		// pop the top element
		int top = stack.pop();

		// if top>=minElement just return the value
		if (top >= minElement) {
			return top;
		}
		// in this case since we stored the original value in minimum so return that and
		// update the currentMin to find next min value
		else {
			int currentMin = this.minElement;
			minElement = 2 * minElement - top;
			return currentMin;
		}
	}

	public int top() {
		int top = stack.peek();
		if (top >= minElement) {
			return top;
		} else {
			return this.minElement;
		}
	}

	public int getMin() {
		if (stack.isEmpty()) {
			return -1;
		}
		return this.minElement;
	}
}
