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
					int x = 0;

					if ((arr[i + 1] >= y && arr[i] <= y) || (arr[i + 1] <= y && arr[i] >= y)) {

						if (((i + 1) == x2 && arr[i] == y)) {
							if ((i + 2) > (i + 1))
								continue;
						}
						if (((i + 2) == x2 && arr[i + 1] == y)) {
							if ((i + 2) < (i + 1))
								continue;
						}

						if (((i + 2) == x1) && arr[i + 1] == y) {
							if ((i + 1) < (i + 2))
								continue;
						}
						
						if (((i + 1) == x1) && arr[i] == y) {
							if ((i + 1) > (i + 2))
								continue;
						}

						int m = arr[i + 1] - arr[i];

						int c = (i + 2) * arr[i] - (i + 1) * arr[i + 1];

						if (m != 0) {
							x = (y - c) / m;
							if ((x1 <= x && x2 >= x) || (x2 <= x && x1 <= x)) {
								count++;
							}
						} else {
							if (((i + 1) <= x1 && (i + 2) > x1) || ((i + 2) <= x1 && (i + 1) > x1)
									|| ((i + 1) >= x1 && (i + 2) <= x1) || (i + 2 >= x2 && i + 1 < x2)
									|| (i + 1 >= x2 && i + 2 < x2)) {
								count++;
							}
						}

					}
				}

				System.out.println(count);

				q--;

			}

			tc--;
		}

	}

}
