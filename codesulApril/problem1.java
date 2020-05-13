package codesulApril;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();
		while (tc-- > 0) {
			int n = scn.nextInt();
			String str = scn.next();

			System.out.println(numberSteps(str, n));
		}

	}

	public static int numberSteps(String str, int N) {

		int[][] dp = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = 0;
			}
		}

		for (int len = 1; len <= N; len++) {
			for (int i = 0, j = len - 1; j < N; i++, j++) {
				if (len == 1) {
					dp[i][j] = 1;
				}

				else {
					dp[i][j] = 1 + dp[i + 1][j];
					if (str.charAt(i) == str.charAt(i + 1)) {
						dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);
					}
					for (int idx = i + 2; idx <= j; idx++) {
						if (str.charAt(i) == str.charAt(idx)) {
							dp[i][j] = Math.min(dp[i + 1][idx - 1] + dp[idx + 1][j], dp[i][j]);
						}
					}
				}
			}
		}
		return dp[0][N - 1];
	}

}
