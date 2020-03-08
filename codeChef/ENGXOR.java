package codeChef;

import java.util.Scanner;

public class ENGXOR {

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);

		int tc = 0;
		if (scn.hasNextInt())
			tc = scn.nextInt();

		while (tc > 0) {

			int n = scn.nextInt();
			int q = scn.nextInt();

			int[] arr = new int[n];
			int[] p = new int[q];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt())
					arr[i] = scn.nextInt();

			}

			for (int i = 0; i < p.length; i++) {
				if (scn.hasNextInt())
					p[i] = scn.nextInt();
			}

			int[] ans = new int[n];

			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					ans[j] = p[i] ^ arr[j];
				}

				for (int j = 0; j < ans.length; j++) {
					ans[j] = decToBinary(ans[j]);

				}
				int even = 0, odd = 0;
				for (int j = 0; j < ans.length; j++) {
					if (ans[j] == 1) {
						even++;
					} else
						odd++;
				}

				System.out.println(even + " " + odd);

			}

			tc--;
		}

	}


	public static int decToBinary(int n) {
		int rem = 0, multi = 1, ans = 0;

		while (n != 0) {
			rem = n % 2;
			n = n / 2;
			ans = rem * multi + ans;
			multi = 10 * multi;

		}
		int count = 0, last = 0;
		int temp = ans;

		while (temp > 0) {
			last = temp % 10;
			if (last == 1) {
				count++;
			}

			temp = temp / 10;

		}

		if (count % 2 == 0) {
			return 1;
		}

		else
			return 0;

	}

}
