package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CHEFZRON {

	static int min;

	public static void main(String[] args) {

		FastReader scn = new FastReader();

		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();
			int q = scn.nextInt();

			int dim = n;
			boolean[] color = new boolean[dim + 1];
			int[][] graph = new int[n+1][n+1];

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			for (int i = 0; i < n - 1; i++) {

				int u = scn.nextInt();
				int v = scn.nextInt();
				graph[u][v] = 1;
				graph[v][u] = 1;

			}

			for (int i = 0; i < q; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				Arrays.fill(color, false);

				int src = scn.nextInt();
				int dst = scn.nextInt();

				min = 0;
				dfs(src, dst, list, list.size(), color, dim, graph);
			}

		}

	}

	static void dfs(int src, int dst, ArrayList<Integer> list, int size, boolean[] color, int dim, int[][] graph) {
		// node added to path
		list.add(src);
		size++;

		color[src] = true;

		if (src == dst) {

			Collections.sort(list);
			int diff = Integer.MAX_VALUE;

			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i + 1) - list.get(i) < diff) {
					diff = list.get(i + 1) - list.get(i);
				}
			}

			min = diff;

			for (Integer node : list) {
				System.out.print(node + "  ");
			}
			System.out.println();
			return;
		}

		for (int I = 1; I <= dim; I++) {
			// if there's an edge between src and node
			if (graph[src][I] == 1) {

				if (color[I] == false) {

					dfs(I, dst, list, size, color, dim, graph);
					color[I] = false;
					size--;
					list.remove(size);
				}
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
