package codeChef_90_days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TRPLSRT {

	public static void main(String[] args) {

		FastReader scn = new FastReader();

		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();

			int[] arr = new int[n + 1];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			arr[0] = 0;
			for (int i = 1; i < arr.length; i++) {
				arr[i] = scn.nextInt();
				map.put(arr[i], i);
			}

			ArrayList<pair> ans = new ArrayList<>();
			ArrayList<ArrayList<Integer>> idx = new ArrayList<ArrayList<Integer>>();

			int count = 0;
			int f = 0;

			for (int i = 1; i < arr.length; i++) {

				if (count > k) {
					f = 1;
					break;
				}

				if (arr[i] == i)
					continue;

				else {
					int val1 = arr[i];
					int val2 = arr[arr[i]];
					if (val2 == i) {

						if (ans.isEmpty()) {
							pair np = new pair();
							np.x = val1;
							np.y = val2;
							ans.add(np);
						} else {

							ArrayList<Integer> idx_sub = new ArrayList<Integer>();

							pair gp = ans.get(0);
							int num1 = gp.x;
							int num2 = gp.y;

							if (num1 == val2 && num2 == val1) {
								continue;
							}

							arr[val1] = num2;
							arr[num1] = num1;
							arr[num2] = val2;

							idx_sub.add(num2);
							idx_sub.add(num1);
							idx_sub.add(val1);

							idx.add(idx_sub);
							count++;

							idx_sub = new ArrayList<Integer>();

							arr[val1] = val1;
							arr[num2] = num2;
							arr[val2] = val2;

							idx_sub.add(val1);
							idx_sub.add(num2);
							idx_sub.add(val2);

							idx.add(idx_sub);
							count++;

							ans.remove(0);
						}

					} else {

						int num1 = map.get(i);

						ArrayList<Integer> idx_sub = new ArrayList<Integer>();

						arr[i] = arr[num1];
						arr[val1] = val1;
						arr[num1] = val2;

						map.replace(arr[num1], num1);
						map.replace(arr[val1], val1);
						map.replace(i, i);

						idx_sub.add(i);
						idx_sub.add(val1);
						idx_sub.add(num1);

						idx.add(idx_sub);
						count++;

					}

				}
			}

			if (f == 1 || (!ans.isEmpty())) {
				System.out.println("-1");
			} else {

				System.out.println(count);

				for (ArrayList<Integer> val : idx) {
					for (int i : val) {
						int num = i;
						System.out.print(num + " ");
					}
					System.out.println();
				}

			}

		}

	}

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}

class pair {
	int x;
	int y;
}
