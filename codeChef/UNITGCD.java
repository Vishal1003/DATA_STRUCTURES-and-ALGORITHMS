package codeChef;

import java.util.Scanner;

public class UNITGCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			int n = scn.nextInt();

			if (n == 1) {
				System.out.println("1");
				System.out.println("1 1");
			} else if (n == 2) {
				System.out.println("1");
				System.out.println("1 1 2");
			} else {

				System.out.println(n / 2);
				System.out.println("3 1 2 3");

				for (int i = 4; i < n; i = i + 2) {
					int next = i + 1;
					System.out.println("2 " + i + " " + next);
				}

				if (n % 2 == 0) {
					System.out.println("1 " + n);
				}

			}

		}

	}

}
