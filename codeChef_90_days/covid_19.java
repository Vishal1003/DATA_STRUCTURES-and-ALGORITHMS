package codeChef_90_days;

import java.util.Scanner;

public class covid_19 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		while (tc-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNext())
					arr[i] = scn.nextInt();
			}

			int[] dist = new int[arr.length - 1];

			for (int i = 0; i < n - 1; i++) {
				dist[i] = Math.abs(arr[i + 1] - arr[i]);
			}

			int count = 0;
			int min = 100000;
			int max = -1;
			int len = dist.length - 1;

			for (int i = 0; i < dist.length; i++) {
				if (dist[i] <= 2) {
					count++;
				}

				if (dist[i] > 2) {

					if (count < min) {
						min = count;
					}

					if (count > max) {
						max = count;
					}

					count = 0;

				}

				if (i == len) {
					if (count < min) {
						min = count;
					}

					if (count > max) {
						max = count;
					}
				}
			}

			int best = min + 1;
			int worse = max + 1;
			System.out.println(best + " " + worse);

		}

	}

}
