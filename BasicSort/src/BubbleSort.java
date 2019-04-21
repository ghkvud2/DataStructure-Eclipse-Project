
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 1, 2, 3, 6, 7, 1, 5, 4, 3 };
		bubbleSort(arr, arr.length);
		showArr(arr);
	}

	public static void bubbleSort(int[] arr, int length) {

		for (int i = length - 1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
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
