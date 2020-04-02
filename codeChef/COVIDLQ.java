package codeChef;

import java.util.Scanner;

public class COVIDLQ {

	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();
		for (int t = 0; t < tc; t++) {

			int flag = 0;
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			for (int i = 0; i < arr.length; ++i) {
				if (i + 1 < arr.length && arr[i] == 1) {
					for (int j = i + 1; j <= i + 5; ++j) {
						if (arr[j] == 1) {
							System.out.println("NO");
							flag = 1;
							break;
						}
					}
					i = i + 5;
				}

				if (flag == 1) {
					break;
				}

			}

			if (flag == 0)
				System.out.println("YES");

		}

	}

}
