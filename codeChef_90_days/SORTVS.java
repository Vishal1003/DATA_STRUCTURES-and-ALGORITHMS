package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SORTVS {

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
			int m = scn.nextInt();

			int[] arr = new int[n + 1];

			for (int i = 1; i < arr.length; i++) {
				arr[i] = scn.nextInt();

			}

			ArrayList<SwapInt> list = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				SwapInt s = new SwapInt();
				s.x = scn.nextInt();
				s.y = scn.nextInt();
				list.add(s);

			}

			int count = 0;

			for (int i = 1; i < arr.length; i++) {

				if (arr[i] == i) {
					continue;
				}

				for (SwapInt gp : list) {
					if (!gp.visited && gp.x == i && gp.y == arr[i] && arr[gp.y] == i) {
						arr[i] = i;
						arr[gp.y] = gp.y;
						gp.visited = true;
					}
					
					else if(!gp.visited && (gp.x == i ) ){
						
					}
				}

			}

			System.out.println(count);

		}
	}

}

class SwapInt {
	int x;
	int y;
	boolean visited = false;
}
