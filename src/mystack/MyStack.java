package mystack;

import java.util.EmptyStackException;

public class MyStack {
	private int[] items;
	private int top = 0;
	int size;

	public MyStack(int size) {
		this.size = size;
		this.items = new int[size];
		this.top = 0;
	}

	public void push(int val) {
		if (this.top == this.size) {
			// stack overflow means when stack is full and u still try to put more items in stack
			throw new StackOverflowError();
		}
		this.items[this.top] = val;
		this.top++;
	}

	public int pop() {

		if (this.top == 0) {
			throw new EmptyStackException();
		}
		top--;

		int value = items[top];
		items[top] = 0;
		return value;
	}

	public int peek() {
		return items[top - 1];
	}

	public int size() {
		return this.top;
	}

	public String toString() {
		String result = "";
		for (int i = size - 1; i >= 0; i--) {
			result += items[i] + " ";
		}
		return result;
	}
}
