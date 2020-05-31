package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Arrays2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int arr1[] = { 1, 0, 2, 9 };
		int arr2[] = { 3, 4, 5, 6, 7 };

		int[][] a = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
//		System.out.println(Intersection(arr1, arr2));
//		pairList(a, 8);
//		arraySum(arr1, arr2);
//		waveCol(a);
		antispiralPrint(a);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("--------////////---------------");
	}

//	Intersection of two Arrays
	public static ArrayList<Integer> Intersection(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				ans.add(one[i]);
				i++;
				j++;

			}
		}

		return ans;

	}

// 	Pair Sum
	public static void pairList(int[] arr, int target) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] + arr[j] == target) {
					System.out.println(arr[i] + " " + arr[j]);
				}

			}
		}

	}

// 	Sum of Arrays
	public static void arraySum(int[] arr1, int[] arr2) {
		int len1 = arr1.length - 1;
		int len2 = arr2.length - 1;

		ArrayList<Integer> ans = new ArrayList<Integer>();

		int rem = 0;
		while (len1 >= 0 && len2 >= 0) {

			int sum = arr1[len1] + arr2[len2];
			if ((rem + sum) >= 10) {
				ans.add((rem + sum) % 10);
				rem = (rem + sum) / 10;
			} else {
				ans.add(rem + sum);
				rem = 0;
			}

			len1--;
			len2--;

		}
		if (len1 == -1 && len2 != -1) {
			while (len2 >= 0) {
				if ((rem + arr2[len2]) >= 10) {
					ans.add((rem + arr2[len2]) % 10);
					rem = (rem + arr2[len2]) / 10;
				} else {
					ans.add(rem + arr2[len2]);
					rem = 0;
				}

				len2--;
			}
		} else if (len1 != -1 && len2 == -1) {
			while (len1 >= 0) {
				if ((rem + arr1[len1]) >= 10) {
					ans.add((rem + arr1[len1]) % 10);
					rem = (rem + arr1[len1]) / 10;
				} else {
					ans.add(rem + arr1[len1]);
					rem = 0;
				}

				len1--;

			}

		}
		System.out.println(ans);
	}

//	Row-wise printing
	public static void rowWise(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + ", ");
				}
			} else {
				for (int j = arr[0].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + ", ");
				}
			}
		}

	}

//	Waveprint Column wise
	public static void waveCol(int[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + ", ");
				}
			} else {
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[i][j] + ", ");
				}
			}
		}
	}

//	Spiral Print
	public static void spiralPrint(int[][] arr) {
		int minRow = 0;
		int minCol = 0;
		int maxRow = arr.length - 1;
		int maxCol = arr[0].length - 1;
		int nel = arr.length * arr[0].length;
		int count = 0;
		while (count < nel) {
			for (int i = minRow; i <= maxRow && count < nel; i++) {
				System.out.print(arr[i][minCol] + " ");
				count++;
			}
			minCol++;

			for (int i = minCol; i <= maxCol && count < nel; i++) {
				System.out.print(arr[maxRow][i] + " ");
				count++;
			}
			maxRow--;

			for (int i = maxRow; i >= minRow && count < nel; i--) {
				System.out.print(arr[i][maxCol] + " ");
				count++;
			}
			maxCol--;

			for (int i = maxCol; i >= minCol && count < nel; i--) {
				System.out.print(arr[minRow][i] + " ");
				count++;
			}
			minRow++;

		}

	}

//	antiSpiral Print
	public static void antispiralPrint(int[][] arr) {
		int minRow = 0;
		int minCol = 0;
		int maxRow = arr.length - 1;
		int maxCol = arr[0].length - 1;
		int nel = arr.length * arr[0].length;
		int count = 0;
		while (count < nel) {

			for (int i = minCol; i <= maxCol && count < nel; i++) {
				System.out.print(arr[minRow][i] + " ");
				count++;
			}
			minRow++;

			for (int i = minRow; i <= maxRow && count < nel; i++) {
				System.out.print(arr[i][maxCol] + " ");
				count++;
			}
			maxCol--;

			for (int i = maxCol; i >= minCol && count < nel; i--) {
				System.out.print(arr[maxRow][i] + " ");
				count++;
			}
			maxRow--;
			for (int i = maxRow; i >= minRow && count < nel; i--) {
				System.out.print(arr[i][minCol] + " ");
				count++;
			}
			minCol++;

		}

	}

}
