package codeChef;

import java.util.Arrays;
import java.util.Scanner;

public class break_chef {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();
		int s = scn.nextInt();
		while (tc > 0) {

			int n = scn.nextInt();

			int[] a = new int[n];
			int[] b = new int[n];

			for (int i = 0; i < a.length; i++) {
				if (scn.hasNextInt())
					a[i] = scn.nextInt();
			}

			for (int i = 0; i < b.length; i++) {
				if (scn.hasNextInt())
					b[i] = scn.nextInt();
			}

			Arrays.sort(a);
			Arrays.sort(b);
			
			for(int val : a) {
				System.out.print(val+" ");
			}
			System.out.println();
			for(int val : b) {
				System.out.print(val+" ");
			}
			

			subtask1(a, b);

			tc--;
		}

	}

	public static void subtask1(int[] a, int[] b) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (b[i] <= a[i]) {
				System.out.println("NO");
				return;
			}

		}

		System.out.println("YES");

	}
}
