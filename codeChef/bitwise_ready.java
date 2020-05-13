package codeChef;

import java.util.*;

public class bitwise_ready {

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			String str = scn.next();

			long[] prob = new long[5];
			for (int i = 0; i < prob.length - 1; i++) {
				prob[i] = 1;
			}

			if (str.length() == 1) {
				System.out.println("748683265 748683265 748683265 748683265");
			} else {
				int count = 0;
				long[] ans = evaluate(str, prob, count);
				long res0 = (ans[0] * ans[ans.length - 1]) % 998244353;
				long res1 = (ans[1] * ans[ans.length - 1]) % 998244353;
				long resa = (ans[2] * ans[ans.length - 1]) % 998244353;
				System.out.println(res0 + " " + res1 + " " + resa + " " + resa);
			}

		}

	}

	public static long[] evaluate(String str, long[] arr, int hashc) {

		int depth = -1;
		char[] tokens = str.toCharArray();
		Stack<Character> values = new Stack<Character>();
		Stack<Character> ops = new Stack<Character>();
		char h = '#';
		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == h) {
				hashc++;
				values.push(h);
			}

			else if (tokens[i] == '(') {
				depth = -1;
				ops.push(tokens[i]);
			}

			else if (tokens[i] == ')') {
				while (ops.peek() != '(') {
					char ch1 = values.pop();
					char op = ops.pop();

					if (depth == -1) {
						if (op == '&') {
							arr[0] = (arr[0] * 9) % 998244353;
							arr[1] = (arr[1] * 1) % 998244353;
							arr[2] = (arr[2] * 3) % 998244353;
							arr[3] = (arr[3] * 3) % 998244353;
						}

						else if (op == '|') {
							arr[0] = (arr[0] * 1) % 998244353;
							arr[1] = (arr[1] * 9) % 998244353;
							arr[2] = (arr[2] * 3) % 998244353;
							arr[3] = (arr[3] * 3) % 998244353;
						} else if (op == '^') {
							arr[0] = (arr[0] * 4) % 998244353;
							arr[1] = (arr[1] * 4) % 998244353;
							arr[2] = (arr[2] * 4) % 998244353;
							arr[3] = (arr[3] * 4) % 998244353;
						}
					} else {
						if (op == '&') {
							arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
						}

						else if (op == '|') {
							arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
						} else if (op == '^') {
							arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
							arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
						}
						depth = -1;
					}
				}
				ops.pop();
			}

			else if (tokens[i] == '&' || tokens[i] == '|' || tokens[i] == '^') {
				ops.push(tokens[i]);
			}
		}

		while (!ops.empty()) {
			values.pop();
			char op = ops.pop();
			if (depth == -1) {
				if (op == '&') {
					arr[0] = (arr[0] * 9) % 998244353;
					arr[1] = (arr[1] * 1) % 998244353;
					arr[2] = (arr[2] * 3) % 998244353;
					arr[3] = (arr[3] * 3) % 998244353;
				}

				else if (op == '|') {
					arr[0] = (arr[0] * 1) % 998244353;
					arr[1] = (arr[1] * 9) % 998244353;
					arr[2] = (arr[2] * 3) % 998244353;
					arr[3] = (arr[3] * 3) % 998244353;
				} else if (op == '^') {
					arr[0] = (arr[0] * 4) % 998244353;
					arr[1] = (arr[1] * 4) % 998244353;
					arr[2] = (arr[2] * 4) % 998244353;
					arr[3] = (arr[3] * 4) % 998244353;
				}
			} else {
				if (op == '&') {
					arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
				}

				else if (op == '|') {
					arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
				} else if (op == '^') {
					arr[0] = (arr[0] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[1] = (arr[1] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[2] = (arr[2] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
					arr[3] = (arr[3] * (arr[1] + arr[2] + arr[3] + arr[0])) % 998244353;
				}
				depth = -1;
			}


		}

		long outcomes = (long) Math.pow(4, hashc);
		long total = modInverse(outcomes, 998244353);
		arr[arr.length - 1] = total;

		return arr;
	}

	static long modInverse(long a, long m) {
		long m0 = m;
		long y = 0, x = 1;

		if (m == 1)
			return 0;

		while (a > 1) {
			long q = a / m;
			long t = m;
			m = a % m;
			a = t;
			t = y;

			y = x - q * y;
			x = t;
		}

		if (x < 0)
			x += m0;

		return x;
	}

}