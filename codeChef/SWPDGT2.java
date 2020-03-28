package codeChef;

import java.util.Scanner;

public class SWPDGT2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {
			int a = scn.nextInt();
			int b = scn.nextInt();

			int sum = a + b;

			int temp1 = a;
			int temp2 = b;
			int ca = 0;
			int cb = 0;

			int rem1 = temp1 % 10;
			int rem2 = 0;
			if (temp1 / 10 != 0) {
				rem2 = temp1 / 10;
				ca = 1;
			}

			int rem3 = temp2 % 10;
			int rem4 = 0;

			if (temp2 / 10 != 0) {
				rem4 = temp2 / 10;
				cb = 1;
			}

			if (ca == 1 && cb == 1) {

				int sum1 = rem4 * 10 + rem2 + rem3 * 10 + rem1;
				int sum2 = rem2 * 10 + rem4 + rem1 * 10 + rem3;

				if (sum1 > sum2 && sum1 > sum) {
					System.out.println(sum1);
				} else if (sum2 > sum1 && sum2 > sum) {
					System.out.println(sum2);
				} else {
					System.out.println(sum);
				}

			} else if (ca == 1 && cb == 0) {

				int sum1 = rem3 * 10 + rem1 + rem2;

				if (sum1 > sum) {
					System.out.println(sum1);
				} else {
					System.out.println(sum);
				}

			}

			else if (cb == 1 && ca == 0) {

				int sum1 = rem1 * 10 + rem3 + rem4;

				if (sum1 > sum) {
					System.out.println(sum1);
				} else {
					System.out.println(sum);
				}

			} else {
				System.out.println(sum);
			}

		}

	}

}
