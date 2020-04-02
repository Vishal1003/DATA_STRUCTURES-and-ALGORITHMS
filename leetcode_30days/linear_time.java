package leetcode_30days;

import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Scanner;

public class linear_time {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(singleNumber(arr));
	}

	public static int singleNumber(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int n = nums[i];
			if (map.containsKey(n)) {
				map.replace(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		int value = 1;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (value == entry.getValue()) {
				return entry.getKey();
			}
		}

		return 0;
	}

}
