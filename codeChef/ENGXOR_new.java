package codeChef;
// path /eclipse-workspace/SelfWork/src

import java.util.Scanner;

public class ENGXOR_new {

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
					ans[j] = count(ans[j]);

				}
				int even = 0, odd = 0;
				for (int j = 0; j < ans.length; j++) {
					if (ans[j] == 1) {
						even++;
					} else
						odd++;
				}

				System.out.print(even + " " + odd + "\n");

			}

			tc--;
		}

	}

	public static int count(int n) {

		int count1 = 0;

		while (n > 0) {

			int ans = n & 1;
			if (ans == 1)
				count1++;

			n = n >> 1;
		}

		if (count1 % 2 == 0) {
			return 1;
		} else
			return 0;

	}

}
