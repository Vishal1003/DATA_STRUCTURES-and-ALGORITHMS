package codeChef;

import java.util.Scanner;

public class SQRDSUB {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		while (tc-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];

			int count = 0;

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNext())
					arr[i] = scn.nextInt();
			}

			for (int i = 0; i < arr.length; i++) {
				long multi = 1;
				for (int j = i; j < arr.length; j++) {
					multi *= arr[j];
					if (multi % 4 != 2 && multi % 4 != -2) {
						count++;
					}
				}
			}

			System.out.println(count);

		}

	}

}
