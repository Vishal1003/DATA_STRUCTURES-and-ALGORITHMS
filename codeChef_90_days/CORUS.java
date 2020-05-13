package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CORUS {

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

	public static void main(String[] args) {

		FastReader scn = new FastReader();

		int tc = scn.nextInt();

		while (tc-- > 0) {

			int n = scn.nextInt();
			int q = scn.nextInt();

			String str = scn.next();

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			

			for (int i = 0; i < str.length(); i++) {
				if (map.containsKey(str.charAt(i))) {
					map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
				} else {
					map.put(str.charAt(i), 1);
				}
			}

			while (q-- > 0) {
				int c = scn.nextInt();

				int len = 0;

				for (Map.Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() > c) {
						len += (entry.getValue() - c);
					}
				}

				System.out.println(len);
			}
		}

	}

}
