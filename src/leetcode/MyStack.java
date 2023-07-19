package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MyStack {

	public String reverseString(String input) {
		Stack<Character> stack = new Stack<>();
		StringBuilder string = new StringBuilder();

		for (char c : input.toCharArray()) {
			stack.push(c);
		}

		while (!stack.isEmpty()) {
			string.append(stack.pop());
		}
		return string.toString();
	}

	/**
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * An input string is valid if:
	 * 
	 * Open brackets must be closed by the same type of brackets. Open brackets must
	 * be closed in the correct order. Every close bracket has a corresponding open
	 * bracket of the same type.
	 * 
	 * Input: s = "[(){}]" Output: true
	 */
	public boolean isValidParanthesis(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				// opening bracket==> push in stack
				stack.push(c);
			} else {

				// if stack is empty it means we don't have starting bracket and we found
				// closing first so invalid
				if (stack.isEmpty())
					return false;

				// pop the top from stack
				char top = stack.pop();

				if (c == '}' && top != '{' || c == ']' && top != '[' || c == ')' && top != '(') {
					// close bracket
					return false;
				}
			}
		}

		// if stack is empty it means we popped all pairs, and if something is left then
		// we didn't found pair so invalid
		return stack.isEmpty();

	}

	// Insert an element at the bottom of a a stack without using any other data
	// structure
	public Stack<Integer> pushAtBottom(Stack<Integer> stack, int x) {

		// check if stack is empty
		if (stack.isEmpty()) {
			stack.push(x);
			return stack;
		}

		// use recursion(recursion also use stack internally)
		int num = stack.pop();

		// recursive call
		pushAtBottom(stack, x);

		// after recursion, push all the elements back in stack
		stack.push(num);
		return stack;

	}

	// reverse a stack using recursion
	// to reverse a stack using recursion we need to take every number and push it
	// at bottom
	public void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int num = stack.pop();
		// recursion call
		reverseStack(stack);

		// push each number at bottom
		pushAtBottom(stack, num);
	}

	// insert sorted
	public void insertInSortedWay(Stack<Integer> stack, int num) {
		// if stack is empty just push the number
		if (stack.isEmpty()) {
			stack.push(num);
		}

		// take top number
		int top = stack.peek();

		// if top is smaller or equal to I/P number then push it otherwise pop the top
		// element and make the recursive call until the condition is true, at the end
		// push all the top number
		if (top <= num) {
			stack.push(num);
		} else {
			stack.pop();

			// recursive call
			insertInSortedWay(stack, num);

			// push the top numbers
			stack.push(top);
		}
	}

	// sort stack using recursion
	public void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		// pop numbers
		int num = stack.pop();

		// recursive call
		sortStack(stack);

		// f(n) to insert in sorted way
		insertInSortedWay(stack, num);
	}

	
	// check if a string is redundant or not
	// (a+(b*c))	==> false
	// ((a)+b)		==> true since it can be written as (a+b)
	
	public boolean redundantBracket(String s) {
		Stack<Character> stack = new Stack<>();
		List<Character> operators = Arrays.asList('+', '-', '*', '/');

		for (char c : s.toCharArray()) {
			// if opening bracket or any operator then push it in stack
			if (c == '(' || operators.contains(c)) {
				stack.push(c);
			}
			// if closing bracket
			else if (c == ')') {
				
				// check top element in stack
				char top = stack.peek();
				
				// if it is anything other than operators it means string is redundant. Eg: '(' opening bracket is found i.e () are adjacent make it redundant
				if (!operators.contains(top)) {
					return true;
				}
				
				// otherwise pop all the operators from stack
				while(!stack.isEmpty() && operators.contains(stack.peek())){
					stack.pop();
				}
				// along with operators also pop ( bracket
				stack.pop();
			}
		}
		return false;
	}

	public static void main(String[] args) {
	}

}
