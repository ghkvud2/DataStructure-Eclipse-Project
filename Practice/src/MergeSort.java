import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 1, 4, 2, 2, 3, 4, 6, 8, 1, 2, 3 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

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

		int fidx = left;
		int ridx = mid + 1;
		int idx = left;

		int[] temp = new int[right + 1];

		while (fidx <= mid && ridx <= right) {

			if (arr[fidx] <= arr[ridx])
				temp[idx++] = arr[fidx++];
			else
				temp[idx++] = arr[ridx++];
		}

		if (fidx > mid)
			for (int i = ridx; i <= right; i++)
				temp[idx++] = arr[i];

		if (ridx > right)
			for (int i = fidx; i <= mid; i++)
				temp[idx++] = arr[i];

		for (int i = left; i <= right; i++)
			arr[i] = temp[i];

	}

}
