package Dynamic_Programming;

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

}
