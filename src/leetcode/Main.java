package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// INPUT: 1 --> 2 --> 3 --> 4 --> 5 --> 6
	// OUTPUT: 2 --> 1 --> 4 --> 3 --> 6 --> 5
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// start from 3rd node since we will handle first and second case
		ListNode rest = swapPairs(head.next.next);

		ListNode next = head.next;

		// swap pointer
		next.next = head;

		// now head will point to rest of the list
		head.next = rest;

		// since next is now head return it
		return next;
	}

	// reverse the list in group of k
	// in case we have 5 element and k is 3 reverse first 3 elements and dont
	// reverse last 2
	public ListNode kReverse(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;

		// we dont want to change the value of k so we took count
		int count = 0;

		// current can be null in case we have a group of k nodes eg: k=3 1->2->3
		while (k > count && current != null) {
			next = current.next;

			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		ListNode rest = kReverse(current, k);

		// to link the rest
		// since head was at 1 earlier and after reverse it will be at end of group 3-->
		// 2--> 1 ---> rest
		head.next = rest;

		// cause prev is head
		return prev;
	}

	// check linked list is cyclic
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		// USE HARE AND TOROTISE ALGO
		// slow and fast pointer
		ListNode slow = head;
		ListNode fast = head;

		// until fast is not null
		while (fast != null && fast.next != null) {

			// jump slow by 1 step but fast by 2 step and if at any time both are at same
			// location linked list is cyclic
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	// find middle of linked list
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// slow and fast pointer
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// detect and remove loop in linked list
	public ListNode removeLoop(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode current = head;

		// make a set to store all nodes
		Set<ListNode> log = new HashSet<>();

		// add initial current node in set
		log.add(current);

		while (current != null && current.next != null) {
			prev = current;
			current = current.next;

			// if set contains current node again means cyclic dependency is found
			if (log.contains(current)) {

				// make prev.next null
				prev.next = null;
				return head;
			}
			log.add(current);
		}
		return head;
	}

	// removed duplicates from sorted list
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;

		while (current != null && current.next != null) {
			// check if current value and next node value is same then skip the element
			// between
			if (current.val == current.next.val) {
				ListNode nextNode = current.next;
				current.next = nextNode.next;
				nextNode.next = null;
			}
			// if the value is not same for next node only then move current by one step other wise we can keep on comparing the values
			else {				
				current = current.next;
			}
		}
		return head;

	}

}
