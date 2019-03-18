
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

			// �ߺ��� ������� �ʴ´�.
			if (curNode.data == data)
				return;

			pNode = curNode;

			if (curNode.data > data)
				curNode = curNode.left;
			else
				curNode = curNode.right;
		}

		// root�� ������� �ʴٸ�
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

		//�����Ϸ��� ��尡 ��Ʈ ����� ���, ��Ʈ ����� �θ� null�̶�� ���� ������ �������� �� �ִ�.
		//���������� �ϱ� ���ؼ��� ������ ���� �� ����� �θ����� �ּҸ� �׻� ������ �־�� �Ѵ�.
		//�ӽó�带 �������� ���� ���¿���, ��Ʈ ��带 ����� �� ���, ��Ʈ ����� �θ� �����Ƿ� ���������� ���� �ڵ��ؾ��Ѵ�.
		//�̸� �����ϱ� ���� tempNode�� �����ϰ� ��Ʈ��尡 tempNode�� ������ �ڽ��� �ǰ� �Ѵ�.
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

			// delNode�� Successor
			Node sNode = delNode.right;
			Node spNode = delNode;

			while (sNode.left != null) {
				spNode = sNode;
				sNode = sNode.left;
			}

			// ������ ��忡 Successor�� ���� �����Ѵ�.
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
