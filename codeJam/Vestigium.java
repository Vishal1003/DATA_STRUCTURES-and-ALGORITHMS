package codeJam;

import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 1; t <= tc; t++) {

			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			int r = 0, c = 0, sum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = scn.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					int num = arr[i][j];

					// row
					for (int col = j + 1; col < n; col++) {
						if (num == arr[i][col])
							r += 1;
						break;
					}

					// col
					for (int row = i + 1; row < n; row++) {
						if (num == arr[row][j]) {
							c += 1;
							break;
						}
					}

					if (i == j) {
						sum += arr[i][j];
					}

				}
			}

			System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);

		}

	}

}
