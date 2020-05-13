package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NRWP {

	static ArrayList<Integer> ans = new ArrayList<Integer>();

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
			int h = scn.nextInt();
			int w = scn.nextInt();
			int n = scn.nextInt();

			Epair[][] maze = new Epair[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					Epair np = new Epair();
					np.hxy = scn.nextInt();
					maze[i][j] = np;
				}
			}

			for (int i = 0; i < n; i++) {
				// yi xi |pi|
				int yi = scn.nextInt();
				int xi = scn.nextInt();
				int pi = scn.nextInt();

				maze[yi][xi].pi = pi;

			}

			System.out.println(maxVal(maze, 1, 1, h, w, ans));

			for (int val : ans) {
				System.out.print(val + " ");
			}

		}

	}

	public static int maxVal(Epair[][] maze, int row, int col, int h, int w, ArrayList<Integer> ans) {
		int val = 0;
		int positive = 0;
		int negative = 0;

		Epair gp = maze[row][col];

		if (gp.pi == 0) {
			if (col == h && row != w) {
				return maxVal(maze, row + 1, 1, h, w, ans);

			}

			else if (col < h) {
				return maxVal(maze, row, col + 1, h, w, ans);

			}
		}

		else {
			if (col == h && row != w) {
				positive = maxVal(maze, row + 1, 1, h, w, ans);
				maze[row][col].pi = -maze[row][col].pi;
				negative = maxVal(maze, row + 1, 1, h, w, ans);
			}

			else if (col < h) {
				positive = maxVal(maze, row, col + 1, h, w, ans);
				maze[row][col].pi = -maze[row][col].pi;
				negative = maxVal(maze, row, col + 1, h, w, ans);
			}

			int right = 0, left = 0, up = 0, down = 0;
			maze[row][col].visited = true;

			if (row + 1 != w + 1) {
				if (!maze[row + 1][col].visited)
					right = maze[row + 1][col].pi;
			}

			if (col + 1 != h + 1) {
				if (!maze[row][col + 1].visited)
					up = maze[row][col + 1].pi;
			}

			if (row - 1 != 0) {
				if (!maze[row - 1][col].visited)
					left = maze[row - 1][col].pi;
			}

			if (col - 1 != 0) {
				if (!maze[row][col - 1].visited)
					down = maze[row][col - 1].pi;
			}

			int sum_positive = gp.pi * right + gp.pi * left + gp.pi * up + gp.pi * down;
			int sum_negative = (-1) * gp.pi * right + (-1) * gp.pi * left + (-1) * gp.pi * up + (-1) * gp.pi * down;

			int sum = positive + sum_positive;
			int sum2 = negative + sum_negative;

			if (sum >= sum2) {
				val = sum;
				maze[row][col].pi = Math.abs(maze[row][col].pi);
				ans.add(1);
			} else {
				val = sum2;
				ans.add(-1);
			}
		}
		return val;

	}

}

class Epair {
	int pi = 0;
	int hxy;
	boolean visited = false;
}
