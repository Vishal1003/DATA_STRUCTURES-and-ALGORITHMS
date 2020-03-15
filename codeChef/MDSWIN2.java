package codeChef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MDSWIN2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt())
					arr[i] = scn.nextInt();

			}

			int q = scn.nextInt();

			while (q > 0) {

				Map<Integer, Integer> mp = new HashMap<>();
				int l = 0, r = 0;

				if (scn.hasNextInt())
					l = scn.nextInt();
				if (scn.hasNextInt())
					r = scn.nextInt();

				if (l == r) {
					System.out.println("1");
				} else {

					for (int i = l - 1; i <= r - 1; i++) {
						if (mp.containsKey(arr[i])) {
							mp.put(arr[i], mp.get(arr[i]) + 1);
						} else {
							mp.put(arr[i], 1);
						}
					}

					int[] pile = new int[mp.size()];

					int i = 0;

					for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
						if (i < pile.length) {
							pile[i] = entry.getValue();
							i++;
						}
					}

					int pileSum = 0;
					int ways = 0;
					int temp = 0;

					for (int j = 0; j < pile.length; j++) {
						pileSum = pileSum ^ pile[j];
					}

					if (pileSum == 0) {
						System.out.println("0"); // if the pile sum is 0 already then there is no chance that 1st person
													// can win
					} else {
//						if the pile_Sum is not 0 then we have to make it 0 for the next turn						

						for (int index = 0; index < pile.length; index++) {
							for (int val = 1; val <= pile[index]; val++) {
								if ((pileSum ^ val) == 0) {
									ways = nCrModPFermat(n, r, 998244353);
									System.out.println(ways);
									break;
								}
							}
						}

					}

					q--;
				}
			}
			tc--;
		}

	}

	static int power(int x, int y, int p) {

		
		int res = 1;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1; 
			x = (x * x) % p;
		}

		return res;
	}

	static int modInverse(int n, int p) {
		return power(n, p - 2, p);
	}

	static int nCrModPFermat(int n, int r, int p) {

	
		if (r == 0)
			return 1;

		int[] fac = new int[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;

		return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
	}

}
