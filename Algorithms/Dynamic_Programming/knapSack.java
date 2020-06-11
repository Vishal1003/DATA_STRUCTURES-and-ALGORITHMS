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

}
