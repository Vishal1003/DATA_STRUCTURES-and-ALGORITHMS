package codeChef;

import java.util.Scanner;

public class STRNO {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			int x = scn.nextInt();
			int k = scn.nextInt();

			if (primeFactors(x, k)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}

		}

	}

	public static boolean primeFactors(int n, int k) {

		int count = 0;

//		if (n % 2 == 0) {

		while (n % 2 == 0) {
			count++;
			n /= 2;
		}

//		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {

//			if (n % i == 0) {

			while (n % i == 0) {
				count++;
				n /= i;

			}
		}
//		}

		if (n > 2)
			count++;

		return (count >= k);
	}
}
