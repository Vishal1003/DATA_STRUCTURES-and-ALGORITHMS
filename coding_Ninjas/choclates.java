package coding_Ninjas;

import java.util.Scanner;

public class choclates {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String[] child = new String[100];

		int n = scn.nextInt();
		int count = 0;

		for (int i = 0; i < n; i++) {
			child[i] = scn.next();

			int sum = 0;

			for (int j = 0; j < i; j++) {
				if (child[i].equals(child[j]))
					sum += 1;
			}

			if (sum > (i - sum)) {
				count++;
			}
		}

		System.out.println(count);
	}
}
