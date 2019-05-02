
public class ArrayToBST {

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BST bst = new BST();
		bst.makeTree(arr);
		bst.traverseInOrder(bst.root);
	}
}

class BST {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

	}

	public void makeTree(int[] arr) {
		root = makeTree(arr, 0, arr.length - 1);
	}

	public Node makeTree(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = makeTree(arr, start, mid - 1);
		node.right = makeTree(arr, mid + 1, end);
		return node;
	}

	public void traverseInOrder(Node root) {

		if (root == null)
			return;

		traverseInOrder(root.left);
		System.out.print(root.data + " ");
		traverseInOrder(root.right);
	}

}
