
package codeChef;

import java.util.*;

class ansLeak {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = 0;
		if (scn.hasNext())
			tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int k = scn.nextInt();

			ArrayList<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				HashMap<Integer, Integer> map = new HashMap<>();

				for (int j = 0; j < k; j++) {
					int scan = 0;
					if (scn.hasNext())
						scan = scn.nextInt();
					if (map.containsKey(scan)) {
						map.replace(scan, map.get(scan) + 1);
					} else {
						map.put(scan, 1);
					}

				}

				int key = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();
				ans.add(key);
			}

			for (int val : ans) {
				System.out.print(val + " ");
			}

			System.out.println();
		}

	}
}