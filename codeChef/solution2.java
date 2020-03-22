package codeChef;

import java.util.Arrays;
import java.util.Scanner;

public class solution2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = scn.nextInt();
			int b = scn.nextInt();
			int[] arr = new int[n];

			for (int j = 0; j < n; j++) {

				if (scn.hasNextInt())
					arr[j] = scn.nextInt();

			}

			Arrays.sort(arr);

			int count = 0, sum = 0;

			for (int j = 0; j < n; j++) {
				sum += arr[j];
				if (sum > b) {
					break;
				}
				count++;
			}

			int out = t + 1;

			System.out.println("Case #" + out + ": " + count);

		}

	}

}
