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

}
