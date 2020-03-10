package codeChef;

import java.util.Scanner;

public class LAZERnew {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = 0;

		if (scn.hasNextInt()) {
			tc = scn.nextInt();
		}

		while (tc > 0) {

			int n = scn.nextInt();
			int q = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt())
					arr[i] = scn.nextInt();

			}

			while (q > 0) {

				int count = 0;

				int x1 = scn.nextInt();
				int x2 = scn.nextInt();
				int y = scn.nextInt();

				for (int i = 0; i < arr.length - 1; i++) {

					if (Math.max(arr[i + 1], arr[i]) >= y && Math.min(arr[i + 1], arr[i]) <= y) {

						if (Math.max(i + 1, i + 2) <= x2 && Math.min(i + 1, i + 2) >= x1)
							count++;

					}

				}

				System.out.println(count);

				q--;

			}

			tc--;
		}

	}

}
