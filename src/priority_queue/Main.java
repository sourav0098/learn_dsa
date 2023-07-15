package priority_queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// Priority Queue
		// Arrange element based on their priority
		Queue<Integer> queue=new PriorityQueue<>();
		queue.add(-10);
		queue.add(2);
		queue.add(4);
		queue.add(8);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		

	}

}
