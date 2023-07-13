package myLinkedList;

class Node {
	// Node contains data and pointer
	public int data;
	public Node next = null;

	public Node(int data) {
		this.data = data;
	}
}

public class LinkedList {
	// head and tail of LinkedList
	private Node head;
	private Node tail;

	// by default head and tail is null in case of empty linked list
	public LinkedList() {
		head = null;
		tail = null;
	}

	// insert
	public void insert(int value) {
		// create new node
		Node node = new Node(value);
		// in case of empty linked list both head and tail are null
		if (isEmpty()) {
			head = tail = node;

		}
		// if head is not null then tail which is last node make it point to new node
		// then make the new node as tail
		else {
			tail.next = node;
			tail = node;
		}
	}

	public void insertBeginning(int value) {
		Node node = new Node(value);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public void insertAt(int data, int index) {
		// create new node
		Node node = new Node(data);

		// take 2 pointers one for current and one for prev
		Node current = this.head;
		Node prev = null;

		if (isEmpty()) {
			throw new IllegalArgumentException();
		}

		while (current != null && index > 0) {
			prev = current;
			current = current.next;
			index--;
		}
		// make prev point to new node and make that node point to current
		prev.next = node;
		node.next = current;
	}

	public void reverse() {

		if (head == null || head.next == null) {
			return;
		}

		// need 3 pointers
		Node prev = null;
		Node current = this.head;
		Node next = head.next;

		while (next != null) {
			current.next = prev;
			// move all pointer 1 step forward
			prev = current;
			current = next;
			next = next.next;
		}

		// we need to do the below step to make the last node point to prev
		current.next = prev;

		// we reversed the pointer but also need to move head to last so after loop
		head = current;
	}

	public void deleteNodeFromBeginning() {
		if (isEmpty()) {
			return;
		}
		head = head.next;
	}

	public void deleteNodeFromEnd() {
		if (isEmpty()) {
			return;
		}
		Node current = head;

		// traverse until 2nd last element
		while (current.next.next != null) {
			current = current.next;
		}

		current.next = null;
		tail = current;
	}

	public void removeNthFromEnd(int n) {
		if (isEmpty()) {
			return;
		}

		Node fast = head;
		Node prev = null;
		Node current = head;

		//	move fast to n position (linked list start from 1  as it does not have indexing)
		while (n > 1 & fast != null) {
			fast = fast.next;
			n--;
		}

		while (fast.next != null) {
			prev = current;
			current = current.next;
			fast = fast.next;
		}

		// for case where n = list size and we want to remove first node from starting
		// [1,2] n=2
		if (prev == null) {
			head = head.next;
			
			// for garbage collection
			current.next = null;
		} 

		prev.next = current.next;
		current.next = null;
	}

	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		} else {
			return false;
		}
	}

	public int sum() {
		int sum = 0;
		Node current = this.head;
		while (current != null) {
			sum += current.data;
			current = current.next;
		}
		return sum;
	}

	public int indexOf(int value) {
		int index = 0;
		Node current = this.head;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	public String toString() {
		String result = "[";
		Node current = head;
		while (current != null) {
			result += current.data + " ";
			current = current.next;
		}
		result += "]";
		return result;

	}
	
	public void printRecursive(Node head) {
		if(head==null) {
			return;
		}
		System.out.print(head.data+"-->");
		printRecursive(head.next);
	}
	
	public void printRecursive() {
		printRecursive(head);
	}
	
	public Node reverseRecursive(Node head) {
		// Base case: if the head is null or there is only one node in the list, return the head
		if(head==null || head.next==null) {
			return head;
		}
		
		// Recursive call to reverse the rest of the list
		Node rest=reverseRecursive(head.next);
		
		// In call stack func(1)-> func(2)-> fun(3)->func(4)->func(5)
		// while back track func(5) will return 5 and then below 3 steps will run at func(4) and so on...
		// change the direction of pointer 4 <-- 5 (4: head 	5:next)
		
		// Reversing the connection between the current node and the next node
	    Node next = head.next;  // store the reference to the next node
	    next.next = head;       // reverse the connection
	    head.next = null;       // set the current node's next reference to null
		
		return rest;
	}
}
