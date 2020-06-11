package Dynamic_Programming;

public class knapSack {

	public static void main(String[] args) {
		
		
	}

//	knapsack recursive
	public static int knapsack(int[] wt, int[] val, int w, int n) {
		if (n == 0 || w == 0) {
			return 0;
		}

		if (wt[n - 1] <= w) {
			int in = val[n - 1] + knapsack(wt, val, w - val[n - 1], n - 1);
			int out = knapsack(wt, val, w, n - 1);

			return Math.max(in, out);
		}

		else {
			return knapsack(wt, val, w, n - 1);
		}
	}

//	bottom-up approach
	public static int knapsack(int[] wt, int[] val, int w, int n, int[][] dp) {
		if (w == 0 || n == 0) {
			return 0;
		}

		if (dp[n][w] != -1) {
			return dp[n][w];
		}

		if (wt[n - 1] <= w) {
			int in = val[n - 1] + knapsack(wt, val, w - val[n - 1], n - 1);
			int out = knapsack(wt, val, w, n - 1);
			return dp[n][w] = Math.max(in, out);
		}

		else {
			return dp[n][w] = knapsack(wt, val, w, n - 1);
		}

	}

//	top-down approach
	public static int knapsackdp(int[] wt, int[] val, int w, int n) {

		int[][] dp = new int[n + 1][w + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (wt[i - 1] <= j) {

					int in = val[i - 1] + dp[i - 1][j - wt[i - 1]];
					int out = dp[i - 1][j];

					dp[i][j] = Math.max(in, out);

				} else {

					dp[i][j] = dp[i - 1][j];

				}

			}
		}

		return dp[n][w];

	}
}
