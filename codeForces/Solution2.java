package codeForces;

import java.util.*;

public class Solution2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		while (tc-- > 0) {
			int x = scn.nextInt();
			int n = scn.nextInt();
			int m = scn.nextInt();
			boolean f1 = false;

			while ((n > 0 || m > 0)) {

				while (n > 0)
					if (x / 2 + 10 != x && x / 2 + 10 < x && m > 0) {
						x = method1(x);
						n = n - 1;
						if (x <= 0) {
							System.out.println("YES");
							f1 = true;
							break;

						}
					} else {
						break;
					}

				if (f1 == true) {
					break;
				}

				if (x <= 0) {
					System.out.println("YES");
					f1 = true;
					break;
				}

				if (f1 == false) {
					x = x - 10;
					m = m - 1;
				}

				if (x <= 0) {
					System.out.println("YES");
					f1 = true;
					break;
				}

			}

			if (f1 == false) {
				System.out.println("NO");
			}
		}
	}

	public static int method1(int x) {
		return (x / 2) + 10;
	}

	public static int method2(int x) {
		return x - 10;
	}

}
