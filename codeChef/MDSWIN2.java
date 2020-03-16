package codeChef;

import java.util.Arrays;
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

			for (int query = 0; query < q; query++) {

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

					int pileSum = 0;
					int ways = 0;
				
					for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
						pileSum = pileSum ^ entry.getValue();
					}

					if (pileSum == 0) {
						System.out.println("0"); // if the pile sum is 0 already then there is no chance that 1st person
													// can win
					} else {
//						if the pile_Sum is not 0 then we have to make it 0 for the next turn	

						for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
							
							int xor_curr = entry.getValue() ^ pileSum;
							if (entry.getValue() > xor_curr)
								ways = ways + (nCrModp(entry.getValue(), xor_curr, 998244353) % 998244353);
						
						}

						System.out.println(ways);

					}
				}
			}
			tc--;
		}

	}

	static int nCrModp(int n, int r, int p) {

		int C[] = new int[r + 1];
		Arrays.fill(C, 0);

		C[0] = 1;
		for (int i = 1; i <= n; i++) {

			for (int j = Math.min(i, r); j > 0; j--)

				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r];
	}

}
