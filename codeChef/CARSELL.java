package codeChef;

import java.util.Arrays;
import java.util.Scanner;

public class CARSELL {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = scn.nextInt();
			int[] price = new int[n];

			for (int i = 0; i < n; i++) {
				price[i] = scn.nextInt();
			}

			Arrays.sort(price);
			int sum = price[price.length - 1];
			int count = 1;

			for (int i = price.length - 2; i >= 0; i--) {
				if (price[i] - count >= 0) {
					int add = price[i] - count;
					sum = (sum + add % 1000000007) % 1000000007;
					count++;
				} else {
					break;
				}

			}

			System.out.println(sum % 1000000007);

		}
	}

}
