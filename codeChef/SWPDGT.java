package codeChef;

import java.util.Scanner;

public class SWPDGT {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			int n = scn.nextInt();
			int m = scn.nextInt();

			int arr[] = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int ans[] = new int[n + 1];

			int idx = 0;

			for (int i = 0; i < n; i++) {
				ans[i] = arr[i];
			}

			long lcm = lcm_of_array_elements(arr);
			long max = lcm;

			for (int i = 1; i <= m; i++) {
				ans[n] = i;
				long lcm2 = lcm_of_array_elements(ans);

				if (lcm2 > max) {
					max = lcm2;
					idx = i;
				}

			}

			if (idx != 0)
				System.out.println(idx);
			else
				System.out.println('1');

		}

	}

	public static long lcm_of_array_elements(int[] arr) {

		int[] element_array = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			element_array[i] = arr[i];
		}

		long lcm_of_array_elements = 1;
		int divisor = 2;

		while (true) {
			int counter = 0;
			boolean divisible = false;

			for (int i = 0; i < element_array.length; i++) {

				if (element_array[i] == 0) {
					return 0;
				} else if (element_array[i] < 0) {
					element_array[i] = element_array[i] * (-1);
				}
				if (element_array[i] == 1) {
					counter++;
				}

				if (element_array[i] % divisor == 0) {
					divisible = true;
					element_array[i] = element_array[i] / divisor;
				}
			}

			if (divisible) {
				lcm_of_array_elements = lcm_of_array_elements * divisor;
			} else {
				divisor++;
			}

			if (counter == element_array.length) {
				return lcm_of_array_elements;
			}
		}
	}

}
