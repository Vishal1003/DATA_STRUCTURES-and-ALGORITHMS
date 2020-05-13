package codeForces;

import java.util.Scanner;

public class problemB {

	static int LAS[][] = new int[1000][2];

	static int solve(int arr[], int n, int i, int pos) {

		// Base Case
		if (i == n)
			return 0;

		if (LAS[i][pos] == 1)
			return LAS[i][pos];

		int inc = 0, exc = 0;
		if (arr[i] > 0 && pos == 1) {
			pos = 0;
			inc = 1 + solve(arr, n, i + 1, pos);
		}

		else if (arr[i] < 0 && pos == 0) {
			pos = 1;
			inc = 1 + solve(arr, n, i + 1, pos);
		}

		exc = solve(arr, n, i + 1, pos);

		LAS[i][pos] = Math.max(inc, exc);

		return LAS[i][pos];
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();

			int[] arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				if (scn.hasNext()) {
					arr1[i] = scn.nextInt();
				}
			}

			System.out.println(Math.max(solve(arr1, n, 0, 0), solve(arr1, n, 0, 1)));
		}

	}

}
