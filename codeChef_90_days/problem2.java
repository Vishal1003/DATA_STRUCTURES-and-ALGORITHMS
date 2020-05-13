package codeChef_90_days;

import java.util.Scanner;

public class problem2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc-- > 0) {

			int n = scn.nextInt();
			long a = scn.nextInt();
			long sum = 0;

			for (int i = 1; i <= n; i++) {
				long pi = 1;
				pi = (long) Math.pow(a, 2 * i-1) % 1000000007;
				a = (a * pi);
				sum += pi % 1000000007;
			}

			System.out.println(sum % 1000000007);

		}
	}
}
