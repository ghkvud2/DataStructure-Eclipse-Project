import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 1, 4, 2, 2, 3, 4, 6, 8, 1, 2, 3 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	public static void quickSort(int[] arr, int left, int right) {

		if (left <= right) {

			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {

		int pivot = left;
		int low = pivot + 1;
		int high = right;

		while (low <= high) {

			while (arr[pivot] >= arr[low] && low <= right)
				low += 1;

			while (arr[pivot] <= arr[high] && high >= left + 1)
				high -= 1;

			if (low <= high)
				swap(arr, low, high);
		}
		swap(arr, high, pivot);
		return high;
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
