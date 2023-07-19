
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	public String toString() {
		return "Value: " + data;
	}

}

public class Main {
	public static void main(String[] args) {
		var root = new TreeNode(7);
		root.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(10);
	}
}
