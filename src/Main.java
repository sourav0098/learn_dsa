import java.util.LinkedList;
import java.util.List;

// LINKED LIST
/**
 * Linked Lists are not stored in contagious location (random memory locations) 
 * Dynamic in size (can be easily shrinked and growed)
 * Insertion and deletion is faster
 * Uses more memory since it stores both data and address to next node
 * Sequential access is slow compared to array
 * No random access like arrays (using index) We need to traverse through linked list to access a specific node
 **/

// TYPES OF LINKED LIST
/**
 * 1) Singly Linked List
 * SLL nodes contains 2 field -data field and next link field.
 * In SLL, the traversal can be done using the next node link only. Thus traversal is possible in one direction only
 * Singly linked list is less efficient. It is preferred when we need to save memory and searching is not required as pointer of single index is stored.
 * Complexity of insertion and deletion at a given position is O(n) even when node is given
 * 
 * 2) Doubly Linked List
 * DLL nodes contains 3 fields -data field, a previous link field and a next link field.
 * In DLL, the traversal can be done using the previous node link or the next node link. Thus traversal is possible in both directions (forward and backward).
 * Doubly linked list is more efficient. When memory is not the problem and we need better performance while searching, we use doubly linked list.
 * Complexity of insertion and deletion at a given position is O(n / 2) = O(n) but in case if node is given then deletion is O(1)
 * 
 * 3) Circular Linked List
 * Unlike a singly linked list, which has a NULL pointer at the end of the list, a circular linked list has a pointer that points back to the first node in the list. 
 * This makes it possible to traverse the entire list without having to keep track of the end of the list.
 * */
public class Main {
 public static void main(String args[]) {
	 List<Integer> list =new LinkedList<>();
	 list.add(4);
	 list.add(2);
	 list.add(1);
	 System.out.println(list);
 }
}
