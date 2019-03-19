
public class BSTMain {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(8);
		bst.insert(1);
		bst.insert(6);
		bst.insert(4);
		bst.insert(9);
		bst.insert(3);
		bst.insert(2);
		bst.insert(7);

		System.out.println("[전체 순회]");
		bst.BSTShowAll();
		System.out.println("\n");

		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 1)
				bst.remove(i);
		}

		System.out.println("[홀수 삭제 후]");
		bst.BSTShowAll();
		System.out.println("\n");

	}
}
