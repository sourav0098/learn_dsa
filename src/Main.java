import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static Queue<Integer> reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();

		// push in stack
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}

		// pop from stack and put in queue
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}

		return queue;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1); // ENQUEUE
		queue.add(2);

		// add: will add element in queue and will throw an exception if queue is full
		queue.add(3);

		// offer: will add element in queue but it wont throw an exception if queue is
		// full
		queue.offer(5);

		System.out.println(queue.remove()); // DEQUEUE

		// remove element from queue and will throw exception if queue is empty
		System.out.println(queue.remove());

		// remove element from queue and will return null if queue is empty
		System.out.println(queue.poll());

		System.out.println(queue.peek());
		System.out.println(queue);
	}

}
