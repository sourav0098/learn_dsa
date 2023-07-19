package binarytree;

class TreeNode {
	int data;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode(int data) {
		this.data = data;
	}

	public String toString() {
		return "Value: " + data;
	}

}

public class MyBinarySearchTree {
	private TreeNode root;

	public MyBinarySearchTree() {
		this.root = null;
	}

	// USING RECURSION
	private TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}

		if (value < root.data) {
			root.leftChild = insert(root.leftChild, value);
		} else {
			root.rightChild = insert(root.rightChild, value);
		}
		return root;
	}

	public void insert(int value) {
		// using recursion
		root = insert(root, value);

		// first time when root is null then create root node for tree
//		if (this.root == null) {
//			this.root = new TreeNode(value);
//			return;
//		}
//
//		TreeNode current = root;
//
//		while (true) {
//			if (value <= current.data) {
//				// go to left
//
//				// if null then insert data other wise go to left
//				if (current.leftChild == null) {
//					current.leftChild = new TreeNode(value);
//					break;
//				} else {
//					current = current.leftChild;
//				}
//
//			} else {
//				// go to right
//
//				// if null then insert data otherwise go right
//				if (current.rightChild == null) {
//					current.rightChild = new TreeNode(value);
//					break;
//				} else {
//					current = current.rightChild;
//				}
//			}
//		}
	}

	private TreeNode find(TreeNode root, int value) {
		if (root == null) {
			return null;
		}

		if (root.data == value) {
			return root;
		}

		if (value < root.data) {
			// search in left sub tree
			return find(root.leftChild, value);
		} else {
			return find(root.rightChild, value);
		}

	}

	public TreeNode find(int value) {
		return find(root, value);
	}

	// Pre Order Traversal
	private void preOrderTraverse(TreeNode root) {
		if (root == null)
			return;

		// Pre Order: Root --> Left --> Right
		System.out.print(root.data + " ");
		preOrderTraverse(root.leftChild);
		preOrderTraverse(root.rightChild);
	}

	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	// In Order Traversal
	private void inOrderTraverse(TreeNode root) {
		if (root == null)
			return;

		// In Order: Left --> Root --> Right
		inOrderTraverse(root.leftChild);
		System.out.print(root.data + " ");
		inOrderTraverse(root.rightChild);
	}

	public void inOrderTraversal() {
		inOrderTraverse(root);
	}

	// Post Order Traversal
	private void postOrderTraverse(TreeNode root) {
		if (root == null)
			return;

		// Post Order: Left --> Right --> Root
		postOrderTraverse(root.leftChild);
		postOrderTraverse(root.rightChild);
		System.out.print(root.data + " ");
	}

	public void postOrderTraversal() {
		postOrderTraverse(root);
	}

	private int depth(TreeNode root, int value, int depth) {
		if (root == null) {
			return -1;
		}
		if (root.data == value) {
			return depth;
		}

		if (value < root.data) {
			return depth(root.leftChild, value, depth + 1);
		} else {
			depth++;
			return depth(root.rightChild, value, depth + 1);
		}
	}

	// Depth of Node
	public int depth(int value) {
		return depth(root, value, 0);
	}

	private int heightofTree(TreeNode root) {
		if (root == null) {
			return -1;
		}

		if (root.leftChild == null && root.rightChild == null) {
			return 0;
		}

		int myHeight = Math.max(heightofTree(root.leftChild), heightofTree(root.rightChild)) + 1;
		return myHeight;
	}

	// Height of whole tree
	public int heightofTree() {
		return heightofTree(root);
	}

	private int heightofNode(TreeNode root, int value) {
		if (root == null) {
			return -1;
		}

		// when value is equal then get height of that sub tree
		if (root.data == value) {
			return heightofTree(root);
		}

		// if value less than root.data go left otherwise right
		if (value < root.data) {
			return heightofNode(root.leftChild, value);
		} else {
			return heightofNode(root.rightChild, value);
		}
	}

	// height of node
	public int height(int value) {
		return heightofNode(root, value);
	}

	private TreeNode getMinimum(TreeNode root) {
		if (root == null) {
			return null;
		}

		// got to extreme left until it is null
		if (root.leftChild == null) {
			return root;
		} else {
			// else go to left child
			return getMinimum(root.leftChild);
		}

	}

	public TreeNode min() {
		return getMinimum(root);
	}

	public boolean isEqual(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}

		if (r1 == null) {
			return false;
		}

		if (r2 == null) {
			return false;
		}

		return r1.data == r2.data && isEqual(r1.leftChild, r2.leftChild) && isEqual(r1.rightChild, r2.rightChild);
	}

	public boolean isEqual(MyBinarySearchTree tree) {
		return isEqual(root, tree.root);	
	}

}
