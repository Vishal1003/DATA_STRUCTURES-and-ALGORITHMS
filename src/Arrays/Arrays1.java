package Arrays;

public class Arrays1 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 10, 88, 12, 33 };
//		maxElement(a);
//		maxIndex(a);
//		ArrayReversal(a);
//		AraayInverse(a);
		bubbleSort(a);
		selectionSort(a);
		insertionSort(a);

	}

//	Maximum in Array:
	public static void maxElement(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int val : arr) {
			if (val > max) {
				max = val;
			}
		}
		System.out.println(max);
	}

//	Max Element index
	public static void maxIndex(int[] arr) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		System.out.println(index);
	}

//	Searching
	public static void search(int[] arr, int item) {
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				flag = i;
			}
		}

		System.out.println(flag);
	}

//	Array Reversal
	public static void ArrayReversal(int[] arr) {
		int size = arr.length;
		int temp = 0;

		for (int i = 0; i < size / 2; i++) {
			temp = arr[i];
			arr[i] = arr[size - 1 - i];
			arr[size - 1 - i] = temp;
		}

		for (int val : arr) {
			System.out.print(val + "  ");
		}
		System.out.println();
	}

//	Inverted Array
	public static void AraayInverse(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[arr[i]] = i + 1;
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

// isMirror Inverse
	public static void isMirror(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[arr[i]] != i) {
				System.out.println("False");
				return;
			}
		}

		System.out.println("True");
	}

//	bubbleSort
	public static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("****************************");

	}

//	selectionSort
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

		}
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("****************************");

	}

//	insertionSort
	public static void insertionSort(int[] arr) {

		for (int counter = 1; counter < arr.length; counter++) {
			int temp = arr[counter];
			int j = counter - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("****************************");

	}
}
