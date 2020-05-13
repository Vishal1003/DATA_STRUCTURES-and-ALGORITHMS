package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class CHANDF {

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
			long x = scn.nextLong();
			long y = scn.nextLong();
			long l = scn.nextLong();
			long r = scn.nextLong();

			long val = 0;

			for (long i = l; i <= r; i++) {
				if ((x & i) * (y & i) > val) {
					val = (x & i) * (y & i);
				}
			}

			System.out.println(val);

		}

	}

}
