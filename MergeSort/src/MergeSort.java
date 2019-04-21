
public class MergeSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 1, 2, 3, 6, 7, 1, 5, 4, 3 };
		mergeSort(arr, 0, arr.length - 1);
		showArr(arr);
	}

	public static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merging(arr, left, mid, right);
		}
	}

	public static void merging(int[] arr, int left, int mid, int right) {

		int fIdx = left;
		int rIdx = mid + 1;
		int idx = left;

		int[] temp = new int[right + 1];

		while (fIdx <= mid && rIdx <= right) {

			if (arr[fIdx] <= arr[rIdx])
				temp[idx++] = arr[fIdx++];
			else
				temp[idx++] = arr[rIdx++];
		}

		if (fIdx > mid)
			for (int i = rIdx; i <= right; i++)
				temp[idx++] = arr[i];

		if (rIdx > right)
			for (int i = fIdx; i <= mid; i++)
				temp[idx++] = arr[i];

		for (int i = left; i <= right; i++)
			arr[i] = temp[i];

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
