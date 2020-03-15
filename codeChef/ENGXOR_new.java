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
			int even = 0, odd = 0;

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt()) {
					arr[i] = scn.nextInt();
					if (arr[i] % 2 == 0) {
						even++;
					} else
						odd++;
				}
			}
			while (q > 0) {
				int query = scn.nextInt();
				if (query % 2 == 0) {
					System.out.println(even + " " + odd);
				} else {
					System.out.println(odd + " " + even);
				}

				q--;
			}

		}

		tc--;
	}

}
