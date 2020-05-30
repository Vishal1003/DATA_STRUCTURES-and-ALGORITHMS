package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ck_prop1 {

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();

			int arr[] = new int[n];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				if (!map.containsKey(arr[i])) {
					map.put(arr[i], 1);
				} else {
					map.replace(arr[i], map.get(arr[i]) + 1);
				}
			}

			int found = 0;

			for (int key1 : map.keySet()) {
				int url = map.get(key1);

				for (int key2 : map.keySet()) {
					if (key2 != key1 && map.get(key2) == url) {
						System.out.println("NO");
						found = 1;
						break;
					}
				}
				if (found == 1)
					break;
			}

			int f = 0;
			if (found == 0)
				for (int i = 0; i < arr.length; i++) {
					int element = arr[i];
					if (i + 1 != n && arr[i + 1] == element)
						continue;

					for (int j = i + 1; j < n; j++) {
						if (arr[j] == element) {
							f = 1;
							System.out.println("NO");
							break;
						}

					}

					if (f == 1)
						break;
				}

			if (found == 0 && f == 0) {
				System.out.println("YES");
			}
		}

	}

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
