package codeForces;

import java.util.Scanner;

public class problemA {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();

			int size = n / 2;
			if (size % 2 != 0 ) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				long sum = size * (size + 1);
				for (int i = 2; i <= n; i += 2) {
					System.out.print(i + " ");
				}
				oddIntegers(sum, size);
			}

		}

	}

	static void oddIntegers(long n, int k) {

		int sum = 0;
		int i = 1;
		int j = 1;

		while (j < k) {
			sum = sum + i;
			System.out.print(i + " ");
			i = i + 2;
			j++;
		}

		long finalOdd = n - sum;

		System.out.println(finalOdd);
	}

}
