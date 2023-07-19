package binarytree;

public class Main {

	public static void main(String[] args) {
		MyBinarySearchTree binarySearchTree = new MyBinarySearchTree();
		int nums[] = new int[] { 7, 3, 8, 1, 4, 10, 18, 22 };

		for (int num : nums) {
			binarySearchTree.insert(num);
		}
		
		MyBinarySearchTree t2 = new MyBinarySearchTree();
		int nums2[] = new int[] { 7, 3, 8, 1, 4, 10, 18, 22 };

		for (int num : nums2) {
			t2.insert(num);
		}

		System.out.println(binarySearchTree.find(4));
		binarySearchTree.preOrderTraverse();
		System.out.println();
		binarySearchTree.inOrderTraversal();
		System.out.println();
		binarySearchTree.postOrderTraversal();
		System.out.println();
		System.out.println("Depth: " + binarySearchTree.depth(1));
		System.out.println("Height: " + binarySearchTree.height(8));
		System.out.println(binarySearchTree.min());
		
		System.out.println(binarySearchTree.isEqual(t2));
	}
}
