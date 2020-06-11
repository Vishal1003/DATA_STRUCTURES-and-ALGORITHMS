package Dynamic_Programming;

public class equal_sum_partition {

	public static void main(String[] args) {

	}

	public static boolean isPossible(int[] arr, int n) {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) {
			return false;
		} else {
			return subset_td(arr, sum / 2, n);
		}

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
				}
			}
		}

		return dp[n][sum];

	}

}
