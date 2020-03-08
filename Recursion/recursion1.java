package Recursion;

import java.util.Scanner;

public class recursion1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();

//		PID(n-1);
//		pattern2(n);

		int[] arr = { 12, 2, 3, 4, 5, 6 };
//		System.out.println(isSorted(arr, arr.length - 1));
		
		System.out.println(search(arr, 6, arr.length-1));

//		System.out.println(triangles(n));
	}

	public static void PID(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 != 0) {
			System.out.println(n);
		}

		PID(n - 1);

		if (n % 2 == 0) {
			System.out.println(n);
		}
	}

	public static void pattern1(int n) {
		if (n == 0) {
			return;
		}

		pattern1(n - 1);

		for (int i = 1; i <= n; i++) {
			System.out.print("*  ");
		}
		System.out.println();
	}

	public static void pattern2(int n) {
		if (n == 0) {
			return;
		}

		for (int i = 1; i <= n; i++) {
			System.out.print("*  ");
		}
		System.out.println();

		pattern2(n - 1);
	}

	public static int triangles(int n) {
		if (n == 1) {
			return 1;
		}

		int ans = triangles(n - 1);

		return ans + n;

	}

	public static boolean isSorted(int[] arr, int n) {

		if (n == 0) {
			return true;
		}

		if (isSorted(arr, n - 1)) {
			if (arr[n - 1] < arr[n])
				return true;
		}

		return false;

	}

	public static boolean search(int[] arr, int item, int n) {
		if (n == 0) {
			return (arr[n] == item);
		}

		if (arr[n] == item) {
			return true;
		}

		return search(arr, item, n - 1);

	}
}
