import java.util.Stack;

public class Main {

//	The stack is a linear data structure that is used to store the collection of objects. It is based on Last-In-First-Out (LIFO).
// Stack underflow: When we try to access a element in stack when it is empty it is known as stack underflow
// stack overflow means when stack is full and u still try to put more items in stack
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// peek is used to see the top element in stack
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());

		while (!stack.isEmpty()) {
			Integer value = stack.pop();
			System.out.println(value);
		}
	}
}
