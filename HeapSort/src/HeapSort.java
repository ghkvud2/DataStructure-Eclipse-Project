
public class HeapSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 5, 2, 1, 4, 6, 8, 9, 4, 5, 6, 7 };
		heapSort(arr);
		showArr(arr);
	}

	public static void buildMaxHeap(int[] arr) {

		int len = arr.length;
		for (int i = len / 2 - 1; i >= 0; i--)
			heapify(i, arr, len);
	}

	public static void heapify(int parent, int[] arr, int length) {

		int child = parent * 2 + 1;

		if (child >= length)
			return;

		if (child + 1 < length && arr[child] < arr[child + 1])
			child += 1;

		if (arr[parent] < arr[child])
			swap(arr, parent, child);

		heapify(child, arr, length);

	}

	public static void heapSort(int[] arr) {

		buildMaxHeap(arr);

		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(0, arr, i);
		}
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static void showArr(int[] arr) {
		for (int n : arr)
			System.out.print(n + " ");
		System.out.println();
	}
}
