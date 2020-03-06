package codeChef;

import java.util.Scanner;

public class CHPINTU {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = 0;
		if (scn.hasNextInt())
			tc = scn.nextInt();

		while (tc > 0) {

			int n = scn.nextInt();
			int m = scn.nextInt();

			int[] fr = new int[n];
			int[] price = new int[n];

			for (int i = 0; i < fr.length; i++) {
				if (scn.hasNextInt())
					fr[i] = scn.nextInt();
			}

			for (int i = 0; i < price.length; i++) {
				if (scn.hasNextInt())
					price[i] = scn.nextInt();

			}

			int[] res = new int[m];

			for (int i = 0; i < fr.length; i++) {
				res[fr[i]] = res[fr[i]] + price[i];
			}

			int min = Integer.MAX_VALUE;
			int flag = 0;

			for (int i = 0; i < res.length; i++) {
				if (res[i] != 0 && res[i] < min) {
					min = res[i];
					flag = 1;
				}

			}

			if (flag == 0) {
				System.out.println("0");
			} else {
				System.out.println(min);
			}

			tc--;
		}

	}

}
