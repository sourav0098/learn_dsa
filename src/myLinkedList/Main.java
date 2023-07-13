package myLinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(21);
		list.insert(2);
		list.insert(11);
		list.insert(10);
		
		list.insertBeginning(10);
		list.insertBeginning(5);
		
		list.insertAt(9, 2);

		System.out.println(list.sum());
		System.out.println(list.indexOf(11));
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		list.deleteNodeFromBeginning();
		System.out.println(list);
		list.deleteNodeFromEnd();
		System.out.println(list);
		list.printRecursive();
		
	}
}
