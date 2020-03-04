package Arrays;

public class Arrays1 {

	public static void main(String[] args) {

		int a[] = { 10, 20, 50, 80, 930, 70,30 };
//		maxElement(a);
//		maxIndex(a);
		ArrayReversal(a);
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
		
		for(int val: arr) {
			System.out.print(val+"  ");
		}
		System.out.println();
	}
	
//	Inverted Array

}
