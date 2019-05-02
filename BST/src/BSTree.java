
public class BSTree {

	Node root;

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {

		if (current == null)
			return new Node(value);

		if (current.value > value)
			current.left = addRecursive(current.left, value);
		else if (current.value < value)
			current.right = addRecursive(current.right, value);
		else
			return current;

		return current;
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {

		if (current == null)
			return false;

		if (current.value == value)
			return true;
		else if (current.value > value)
			return containsNodeRecursive(current.left, value);
		else
			return containsNodeRecursive(current.right, value);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {

		if (current == null)
			return null;

		if (current.value == value) {

			if (current.left == null && current.right == null)
				return null;

			if (current.right == null)
				return current.left;

			if (current.left == null)
				return current.right;

			int successor = findSuccessor(current.right);
			current.value = successor;
			current.right = deleteRecursive(current.right, successor);
			return current;

		} else if (current.value > value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		} else {
			current.right = deleteRecursive(current.right, value);
			return current;
		}
	}

	private int findSuccessor(Node current) {
		if (current.left == null)
			return current.value;
		else
			return findSuccessor(current.left);
	}

	public void traverseInOrder(Node current) {

		if (current == null)
			return;

		traverseInOrder(current.left);
		System.out.print(current.value + " ");
		traverseInOrder(current.right);
	}

	public static void main(String[] args) {
		BSTree bst = new BSTree();
		bst.add(6);
		bst.add(4);
		bst.add(8);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		bst.add(9);

		bst.traverseInOrder(bst.root);
		System.out.println();
		
		bst.delete(5);
		bst.traverseInOrder(bst.root);
		System.out.println();
		
		bst.delete(4);
		bst.traverseInOrder(bst.root);
		System.out.println();
		
		bst.delete(8);
		bst.traverseInOrder(bst.root);
		System.out.println();

	}
}
