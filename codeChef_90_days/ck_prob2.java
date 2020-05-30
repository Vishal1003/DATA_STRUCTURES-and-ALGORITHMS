package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ck_prob2 {

	public final static int d = 256;

	public static void main(String[] args) {

		FastReader scn = new FastReader();
		int tc = scn.nextInt();

		while (tc-- > 0) {
			String str = scn.next();

			int len = str.length();

			int count = 1;

			if (len == 4) {
				if (str.charAt(0) != str.charAt(1) || str.charAt(2) != str.charAt(2)) {
					System.out.println("0");
				} else
					System.out.println("1");

			} else {
				for (int i = 1; i < str.length(); i++) {
					String pat = str.substring(0, i);
					int idx = search(pat, str, 101);
					if (idx == -1 || idx != i)
						continue;
				}
			}

		}
	}

	public static int search(String pat, String txt, int q) {
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0;
		int t = 0;
		int h = 1;

		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		for (i = 0; i <= N - M; i++) {

			if (p == t) {
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				if (j == M)
					return i;
			}

			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
				if (t < 0)
					t = (t + q);
			}
		}

		return -1;
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
