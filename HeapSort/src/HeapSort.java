
public class HeapSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 6, 2, 4, 9, 7, 5, 8 };
		int length = arr.length;
		heapSort(arr, length);
		show(arr, length);
	}

	public static void buildMaxHeap(int[] arr, int length) {

		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(arr, i, length);
		}
	}

	public static void heapify(int[] arr, int root, int length) {

		int parent = root;
		int leftChild = parent * 2 + 1;
		int rightChild = parent * 2 + 2;

		if (leftChild < length && arr[parent] < arr[leftChild])
			parent = leftChild;

		if (rightChild < length && arr[parent] < arr[rightChild])
			parent = rightChild;

		if (parent != root) {
			swap(arr, parent, root);
			heapify(arr, parent, length);
		}
	}

	public static void heapSort(int[] arr, int length) {

		buildMaxHeap(arr, length);

		for (int i = length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i - 1);
		}
	}

	public static void show(int[] arr, int length) {
		for (int i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}

