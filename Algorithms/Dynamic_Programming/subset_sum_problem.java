package Dynamic_Programming;

public class subset_sum_problem {

	public static void main(String[] args) {

	}

	public static boolean subSet(int[] arr, int sum, int n) {
		if (n == 0 && sum != 0) {
			return false;
		}

		if (sum == 0) {
			return true;
		}

		if (arr[n - 1] <= sum) {
			return (subSet(arr, sum - arr[n - 1], n - 1) || subSet(arr, sum, n - 1));
		}

		return subSet(arr, sum, n - 1);

	}

	public static boolean subSet_bu(int[] arr, int sum, int n, boolean dp[][]) {

		if (n == 0 && sum != 0) {
			return false;
		}

		if (sum == 0) {
			return true;
		}

		if (dp[n][sum] != false) {
			return dp[n][sum];
		}

		if (arr[n - 1] <= sum) {
			return dp[n][sum] = (subSet_bu(arr, sum - arr[n - 1], n - 1, dp) || subSet_bu(arr, sum, n - 1, dp));
		}

		return dp[n][sum] = subSet_bu(arr, sum, n - 1, dp);

	}

	public static boolean subset_td(int[] arr, int sum, int n) {

		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];

	}

}
