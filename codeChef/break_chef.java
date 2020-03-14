package codeChef;

import java.util.Arrays;
import java.util.HashMap;
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

			subtask1(a, b);

			tc--;
		}

	}

	public static void subtask1(int[] a, int[] b) {

		boolean value = true;
		int count = 0;

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		if (b[0] <= a[0]) {
			System.out.println("NO");
			return;
		} else {
			map.put(a[0], value);
			map.put(b[0], value);
		}

		for (int i = 1; i < a.length; i++) {

			if (map.containsKey(a[i])) {
				for (int j = i; j < b.length; j++) {
					if (b[j] > a[i]) {
						map.put(b[j], value);
						count = 1;
						break;
					}
				}

				if (count == 0) {
					System.out.println("NO");
					return;
				}

			} else {
				System.out.println("NO");
				return;
			}

		}

		System.out.println("YES");

	}
}
