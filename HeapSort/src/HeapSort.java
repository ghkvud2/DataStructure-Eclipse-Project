
public class HeapSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 6, 2, 4, 9, 7, 5, 8 };
		int length = arr.length;
		heapSort(arr, length );
		show(arr, length);

//		int[] arr = new int[] { 4, 14, 7, 2, 8, 1 };
//		int length = arr.length;
//		buildMaxHeap(arr, length);
//		show(arr, length);
	}

	public static void buildMaxHeap(int[] arr, int length) {

		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(arr, i, length);
		}
	}

//	public static void heapify(int[] arr, int root, int length) {
//
//		int parent = root;
//		int leftChild = parent * 2 + 1;
//		int rightChild = parent * 2 + 2;
//
//		if (leftChild < length && arr[parent] < arr[leftChild])
//			parent = leftChild;
//
//		if (rightChild < length && arr[parent] < arr[rightChild])
//			parent = rightChild;
//
//		if (parent != root) {
//			swap(arr, parent, root);
//			heapify(arr, parent, length);
//		}
//	}

	public static void heapify(int[] arr, int parent, int length) {

		// 자식 노드가 없는 경우
		if (parent * 2 + 1 >= length)
			return;

		// 자식 노드들 중, 더 큰 자식노드 찾기
		int child = parent * 2 + 1;
		if (child + 1 < length && arr[child] < arr[child + 1])
			child += 1;

		// 부모노드 < 자식노드 일 경우 위치를 바꿔줌
		if (arr[parent] < arr[child]) {
			int temp = arr[parent];
			arr[parent] = arr[child];
			arr[child] = temp;
		}
		heapify(arr, child, length);
	}

//	public static void heapSort(int[] arr, int length) {
//
//		buildMaxHeap(arr, length);
//
//		for (int i = length - 1; i > 0; i--) {
//			swap(arr, 0, i);
//			heapify(arr, 0, i - 1);
//		}
//	}

	public static void heapSort(int[] arr, int length) {

		buildMaxHeap(arr, length);

		for (int i = length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
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
