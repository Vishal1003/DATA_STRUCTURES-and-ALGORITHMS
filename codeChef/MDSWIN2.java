package codeChef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MDSWIN2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt())
					arr[i] = scn.nextInt();

			}

			int q = scn.nextInt();

			while (q > 0) {

				Map<Integer, Integer> mp = new HashMap<>();
				int l = 0, r = 0;

				if (scn.hasNextInt())
					l = scn.nextInt();
				if (scn.hasNextInt())
					r = scn.nextInt();

				if (l == r) {
					System.out.println("1");
				} else {

					for (int i = l - 1; i <= r - 1; i++) {
						if (mp.containsKey(arr[i])) {
							mp.put(arr[i], mp.get(arr[i]) + 1);
						} else {
							mp.put(arr[i], 1);
						}
					}

					int[] pile = new int[mp.size()];

					int i = 0;

					for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
						if (i < pile.length) {
							pile[i] = entry.getValue();
							i++;
						}
					}

					System.out.println(getTotalWays(pile, mp.size()));

					q--;
				}
			}
			tc--;
		}

	}

	static int xorArray(int arr[], int n) {
		int res = 0;
		for (int i = 0; i < n; i++)
			res = res ^ arr[i];

		return res;
	}

	static int getTotalWays(int arr[], int n) {

		int xorArr = xorArray(arr, n);

		if (xorArr == 0)
			return 0;

		int numberOfWays = 0;

		for (int i = 0; i < n; i++) {
			int requiredCoins = xorArr ^ arr[i];
			if (requiredCoins < arr[i])
				numberOfWays++;
		}
		return numberOfWays;
	}
}
