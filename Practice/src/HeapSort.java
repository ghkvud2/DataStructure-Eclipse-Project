import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 5, 1, 2 };
		heapSort(arr, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void buildMaxHeap(int[] arr, int length) {

		for (int i = length / 2; i >= 0; i--)
			heapify(arr, i, length);
	}

	public static void heapify(int[] arr, int parent, int length) {

		int child = parent * 2 + 1;
		if (child > length)
			return;

		if (child + 1 <= length && arr[child] < arr[child + 1])
			child += 1;

		if (arr[parent] < arr[child])
			swap(arr, parent, child);
		heapify(arr, child, length);

	}

	public static void heapSort(int[] arr, int length) {

		buildMaxHeap(arr, length);

		for (int i = length; i > 0; i--) {

			swap(arr, 0, i);
			heapify(arr, 0, i - 1);
		}
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
