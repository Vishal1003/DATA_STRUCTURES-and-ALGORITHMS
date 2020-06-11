package Dynamic_Proramming_question;

public class count_of_subset {

	public static void main(String[] args) {

	}

//	recursive approach
	public static int countSubset(int[] arr, int n, int sum) {

		if (n == 0 && sum != 0) {
			return 0;
		}

		if (sum == 0) {
			return 1;
		}

		if (arr[n - 1] < sum) {
			return (countSubset(arr, n - 1, sum - arr[n - 1]) + countSubset(arr, n - 1, sum));
		}

		return countSubset(arr, n - 1, sum);

	}

//	bottom-up approach
	public static int countSubsetBu(int[] arr, int n, int sum, int[][] dp) {

		if (n == 0 && sum != 0) {
			return 0;
		}

		if (sum == 0) {
			return 1;
		}

		if (dp[n][sum] != -1) {
			return dp[n][sum];
		}

		if (arr[n - 1] < sum) {
			return dp[n][sum] = countSubset(arr, n - 1, sum - arr[n - 1]) + countSubset(arr, n - 1, sum);
		}

		return dp[n][sum] = countSubset(arr, n - 1, sum);
	}

//	top-down approach
	public static int countSubsetTd(int[] arr, int n, int sum) {

		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] < j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];

	}

}
