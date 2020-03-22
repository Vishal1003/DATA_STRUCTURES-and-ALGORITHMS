package codeChef;

import java.util.ArrayList;
import java.util.Scanner;

public class CHCBOX {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			int n = scn.nextInt();

			int[] arr = new int[n];

			int k = 0;

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNext())
					arr[i] = scn.nextInt();
			}

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < arr.length; i++) {
				if (max < arr[i])
					max = arr[i];
			}

			ArrayList<Integer> ans = new ArrayList<Integer>();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max) {
					ans.add(i);
				}
			}

			if (ans.size() == 1) {

				System.out.println(Math.abs(ans.get(0) - (n / 2)));

			} else {

				if (ans.get(ans.size() - 1) - ans.get(0) >= (n / 2)) {
					System.out.println("0");
				} else {

					int end = arr.length - 1 - ans.get(ans.size() - 1);
					int start = ans.get(0);

					if (end < (n / 2) - start) {
						System.out.println("0");
					} else {
						System.out.println(Math.abs(ans.get(ans.size() - 1) - (n / 2)));
					}

				}

			}

		}

	}

	public static void rightRotateByOne(int[] A) {
		int last = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			A[i + 1] = A[i];
		}

		A[0] = last;
	}

	public static void rightRotate(int[] A, int k) {
		for (int i = 0; i < k; i++) {
			rightRotateByOne(A);
		}
	}
}
