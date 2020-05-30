package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WWALK {

	public static void main(String[] args) {

		FastReader scn = new FastReader();

		int tc = scn.nextInt();

		while (tc-- > 0) {

			int n = scn.nextInt();
			long arr[] = new long[n];
			long arr2[] = new long[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextLong();
			}

			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = scn.nextLong();
			}

			long xa = 0;
			long xb = 0;
			long distance = 0;

			for (int i = 0; i < arr.length; i++) {
				if (xa == xb && arr[i] == arr2[i]) {
					distance += arr[i];
				}

				xa += arr[i];
				xb += arr2[i];
			}

			System.out.println(distance);

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
