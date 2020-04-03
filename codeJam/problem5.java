package codeJam;

import java.util.Scanner;

public class problem5 {

	static boolean solved;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();

			int[][] maze = new int[60][60];
			boolean[][] row_safe = new boolean[60][60];
			boolean col_safe[][] = new boolean[60][60];

			solver(1, 1, 0, n, k, t, maze, row_safe, col_safe);

			if (!solved) {
				System.out.println("Case #" + t + ": " + "IMPOSSIBLE\n");
			}
			solved = false;

		}

	}

	public static void solver(int row, int col, int m, int n, int k, int t, int sqr[][], boolean[][] row_safe,
			boolean[][] col_safe) {
		if (row == n && col == n + 1 && m == k && !solved) {
			solved = true;
			System.out.print("Case #" + t + ": " + "POSSIBLE\n");
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					System.out.print(sqr[i][j] + " ");
				}
				System.out.println();
			}
			return;
		} else if (row > n) {
			return;
		} else if (col > n) {
			solver(row + 1, 1, m, n, k, t, sqr, row_safe, col_safe);
		}
		for (int i = 1; i <= n && !solved; ++i) {
			if (!row_safe[row][i] && !col_safe[col][i]) {
				row_safe[row][i] = col_safe[col][i] = true;
				if (row == col) {
					m += i;
				}
				sqr[row][col] = i;

				solver(row, col + 1, m, n, k, t, sqr, row_safe, col_safe);

				row_safe[row][i] = col_safe[col][i] = false;
				if (row == col) {
					m -= i;
				}
				sqr[row][col] = 0;
			}
		}
	}

}
