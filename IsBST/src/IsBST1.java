
public class IsBST1 {

	public static void main(String[] args) {

		BST1 bst = new BST1(10);
		System.out.println(bst.isBST());
	}
}

class BST1 {

	Node root;
	int size;
	int idx;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public BST1(int size) {
		this.idx = 0;
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
		int[] arr = new int[size];
		traverseInOrder(root, arr);

		for (int i = 0; i < size - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	public void traverseInOrder(Node root, int[] arr) {

		if (root == null)
			return;
		traverseInOrder(root.left, arr);
		arr[idx++] = root.data;
		traverseInOrder(root.right, arr);
	}
}
