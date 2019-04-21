import java.util.Arrays;

public class BasicSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 1, 4, 2 };

//		bubbleSort(arr, arr.length);
//		selectionSort(arr, arr.length);
		insertSort(arr, arr.length);

		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static void bubbleSort(int[] arr, int length) {

		for (int i = length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void selectionSort(int[] arr, int length) {

		for (int i = 0; i < length - 1; i++) {

			int idx = i;

			for (int j = i + 1; j < length; j++) {
				if (arr[idx] > arr[j])
					idx = j;
			}
			swap(arr, idx, i);
		}

	}

	public static void insertSort(int[] arr, int length) {

		int i, j;

		for (i = 1; i < length; i++) {

			int temp = i;

			for (j = i - 1; j >= 0; j--) {

				if (temp < arr[j])
					arr[j + 1] = arr[j];
				else
					break;
			}
			arr[j + 1] = temp;
		}
	}

}
