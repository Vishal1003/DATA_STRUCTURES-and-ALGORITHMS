package codeChef;

import java.util.Scanner;

public class LAZER_new {

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

				for (int j = x1; j < x2-1; j++) {
					if (y >= arr[j] && y <= arr[j]) {
						count++;
					}
				}

				System.out.print(count + "\n");

				q--;

			}

			tc--;
		}

	}

}
