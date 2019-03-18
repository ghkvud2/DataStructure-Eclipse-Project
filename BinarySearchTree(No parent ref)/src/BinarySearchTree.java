
public class BinarySearchTree {

	private Node root;

	public Node search(Node root, int data) {

		if (root == null || root.data == data)
			return root;

		if (root.data > data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}

	public void insert(int data) {

		Node newNode = new Node(data);
		Node pNode = null;
		Node curNode = root;

		while (curNode != null) {

			// 중복을 허용하지 않는다.
			if (curNode.data == data)
				return;

			pNode = curNode;

			if (curNode.data > data)
				curNode = curNode.left;
			else
				curNode = curNode.right;
		}

		// root가 비어있지 않다면
		if (pNode != null) {
			if (pNode.data > data)
				pNode.left = newNode;
			else
				pNode.right = newNode;
		} else {
			root = newNode;
		}
	}

	public Node remove(int data) {

		//삭제하려는 노드가 루트 노드인 경우, 루트 노드의 부모가 null이라면 삭제 과정이 복잡해질 수 있다.
		//삭제연산을 하기 위해서는 삭제할 노드와 그 노드의 부모노드의 주소를 항상 가지고 있어야 한다.
		//임시노드를 선언하지 않은 상태에서, 루트 노드를 지우게 될 경우, 루트 노드의 부모가 없으므로 삭제과정을 따로 코딩해야한다.
		//이를 방지하기 위해 tempNode를 선언하고 루트노드가 tempNode의 오른쪽 자식이 되게 한다.
		Node tempNode = new Node();
		tempNode.right = root;

		Node pNode = tempNode;
		Node curNode = root;
		Node delNode = null;

		while (curNode != null && curNode.data != data) {

			pNode = curNode;

			if (curNode.data > data)
				curNode = curNode.left;
			else
				curNode = curNode.right;
		}
		if (curNode == null)
			return null;

		delNode = curNode;

		if (delNode.left == null && delNode.right == null) {

			if (pNode.left == delNode)
				pNode.left = null;
			else
				pNode.right = null;

		} else if (delNode.left == null || delNode.right == null) {

			Node childNode;
			if (delNode.left == null)
				childNode = delNode.right;
			else
				childNode = delNode.left;

			if (delNode == pNode.left)
				pNode.left = childNode;
			else
				pNode.right = childNode;

		} else {

			// delNode의 Successor
			Node sNode = delNode.right;
			Node spNode = delNode;

			while (sNode.left != null) {
				spNode = sNode;
				sNode = sNode.left;
			}

			// 삭제할 노드에 Successor의 값을 대입한다.
			delNode.data = sNode.data;

			if (sNode == spNode.left)
				spNode.left = sNode.right;
			else
				spNode.right = sNode.right;

			delNode = spNode;
		}

		if (tempNode.right != root)
			root = tempNode.right;

		return delNode;

	}

	public void inorderTraverse(Node root) {

		if (root == null)
			return;

		inorderTraverse(root.left);
		System.out.print(root.data + " ");
		inorderTraverse(root.right);
	}

	public void BSTShowAll() {
		inorderTraverse(root);
	}

}
