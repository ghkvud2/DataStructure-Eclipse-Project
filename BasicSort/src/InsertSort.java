
public class InsertSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 1, 2, 3, 6, 7, 1, 5, 4, 3 };
		insertSort(arr, arr.length);
		showArr(arr);
	}

	public static void insertSort(int[] arr, int length) {

		for (int i = 1; i < length; i++) {

			int temp = arr[i];
			int j = i;

			for (; j > 0; j--) {
				if (temp < arr[j - 1])
					arr[j] = arr[j - 1];
				else
					break;
			}
			arr[j] = temp;
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
