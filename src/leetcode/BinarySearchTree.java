package leetcode;

public class BinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Validate Binary Search Tree
	private boolean validateBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}

		// out of range and 2 values cant be same
		if (root.val <= min || root.val >= max) {
			return false;
		}

		return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
	}
	
	// Validate Binary Search Tree
	public boolean isValidBST(TreeNode root) {
		return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

}
