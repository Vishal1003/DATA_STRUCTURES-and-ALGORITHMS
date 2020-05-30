package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LOSTWEEK {

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

			int[] arr = new int[5];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int p = scn.nextInt();

			int arr2[] = new int[5];
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i] * p;
				sum += arr2[i];
			}
			
			if(sum <= (24*5)) {
				System.out.println("No");
			}else {
				System.out.println("Yes");
			}
		}

	}

}
