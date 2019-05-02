
public class IsBST2 {

	public static void main(String[] args) {
		BST2 bst = new BST2(10);
		System.out.println(bst.isBST());
	}
}

class BST2 {

	Node root;
	Integer prev;
	int size;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public BST2(int size) {
		this.prev = null;
		this.size = size;
		root = makeTree(0, size - 1);
	}

	public Node makeTree(int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeTree(start, mid - 1);
		node.right = makeTree(mid + 1, end);
		return node;
	}

	public boolean isBST() {
		return isBST(root);
	}

	public boolean isBST(Node root) {
		if (root == null)
			return true;

		if (!isBST(root.left))
			return false;

		if (prev != null && root.data < prev)
			return false;

		prev = root.data;

		if (!isBST(root.right))
			return false;

		return true;
	}

}
