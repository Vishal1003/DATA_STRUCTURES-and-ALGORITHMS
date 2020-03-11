package Recursion;

import java.util.ArrayList;

public class recursion2 {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 20, 50, 80, 20, 90 };
		int item = 20;
		ArrayList<Integer> ans = new ArrayList<Integer>();

//		System.out.println(first_index(arr, item, 0));
//		System.out.println(last_index(arr, item, arr.length - 1));
		System.out.println(all_indices(arr, item, 0, ans));
	}

	public static int first_index(int[] arr, int item, int i) {

		if (i == arr.length) {
			return -1;
		}

		if (arr[i] == item) {
			return i;
		}

		return first_index(arr, item, i + 1);

	}

	public static int last_index(int[] arr, int item, int i) {

		if (i == -1)
			return -1;

		if (arr[i] == item)
			return i;

		return last_index(arr, item, i - 1);

	}

	public static ArrayList<Integer> all_indices(int[] arr, int item, int i, ArrayList<Integer> ans) {

		if (i == arr.length) {
			return ans;
		}

		if (arr[i] == item) {
			ans.add(i);
		}

		return all_indices(arr, item, i + 1, ans);

	}

	
}
