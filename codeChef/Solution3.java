package codeChef;


import java.util.*;
import java.io.*;

public class Solution3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = scn.nextInt();
		for (int t = 1; t <= tc; ++t) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int p = scn.nextInt();

			int[][] maze = new int[n][k];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < k; j++) {
					maze[i][j] = scn.nextInt();
				}
			}
			int[][] dp = new int[n + 1][p + 1];

			for (int i[] : dp)
				Arrays.fill(i, -1);

			int ans = dp_call(0, p, k, n, dp, maze);

			System.out.println("Case #" + t + ": " + ans);
		}
	}

	public static int dp_call(int index_dp, int count, int k, int n, int[][] dp, int[][] maze) {
		if (index_dp == n && count == 0)
			return 0;
		if (index_dp == n)
			return Integer.MIN_VALUE;
		if (count == 0)
			return 0;
		int temp = count;
		if (dp[index_dp][count] != -1)
			return dp[index_dp][count];
		int max = dp_call(index_dp + 1, count, k, n, dp, maze);
		int sum = 0;

		for (int i = 0; i < k; i++) {
			if (count == 0)
				break;
			sum += maze[index_dp][i];
			max = Math.max(max, sum + dp_call(index_dp + 1, count - 1, k, n, dp, maze));
			count -= 1;
		}
		dp[index_dp][temp] = max;
		return max;
	}
}