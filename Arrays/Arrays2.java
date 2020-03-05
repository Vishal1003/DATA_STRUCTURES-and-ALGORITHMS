package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Arrays2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int arr1[] = { 10, 20, 30, 60, 100 };
		int arr2[] = { 20, 30, 40, 50, 60, 70, 80 };

		int a[] = { 3, 1, 9, 7, 5, -1 };

//		System.out.println(Intersection(arr1, arr2));
		pairList(a, 8);
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


}
