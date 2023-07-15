package leet_code;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return queue;
		}

		int num = queue.poll();
		reverseQueueUsingRecursion(queue);
		queue.offer(num);

		return queue;
	}

	public static Queue<Integer> reverseKElementsQueue(Queue<Integer> queue, int k) {
		if (queue.isEmpty() || k <= 0) {
			return queue;
		}

		int num = queue.poll();
		reverseKElementsQueue(queue, k - 1);
		queue.offer(num);

		return queue;
	}

	// Reverse First K elements of Queue
	public static Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
		queue = reverseKElementsQueue(queue, k);
		for (int i = 0; i < queue.size() - k; i++) {
			queue.offer(queue.poll());
		}
		return queue;
	}

	//	Interleave The First Half Of The Queue With The Second Half
	// I/P ==> 1,2,3,4,5,6
	// O/P ==> 1,4,2,5,3,6
	public static Queue<Integer> interLeaveQueue(Queue<Integer> queue) {
		Queue<Integer> newQueue = new ArrayDeque<Integer>();
		int size = queue.size();

		// first lets divide the queue and add half of the elements in another queue
		for (int i = 0; i < size / 2; i++) {
			newQueue.add(queue.poll());
		}
		
		// then add one element from newQueue then from the same queue to the end and continue it ...
		for (int i = 0; i < size/2; i++) {
			queue.offer(newQueue.poll());
			queue.offer(queue.poll());
		}
		return queue;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(12);
		queue.add(1);
		queue.add(9);
		queue.add(5);
		queue.add(3);
		System.out.println(queue);
//		System.out.println(reverseQueueUsingRecursion(queue));
//		System.out.println(modifyQueue(queue, 2));
		System.out.println(interLeaveQueue(queue));
		
	}
}
