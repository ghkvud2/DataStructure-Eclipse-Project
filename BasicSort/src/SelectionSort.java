
public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 1, 2, 3, 6, 7, 1, 5, 4, 3 };
		selectSort(arr, arr.length);
		showArr(arr);
	}

	public static void selectSort(int[] arr, int length) {

		for (int i = 0; i < length - 1; i++) {

			int val = i;

			for (int j = i + 1; j < length; j++) {
				if (arr[val] > arr[j])
					val = j;
			}
			swap(arr, i, val);
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
