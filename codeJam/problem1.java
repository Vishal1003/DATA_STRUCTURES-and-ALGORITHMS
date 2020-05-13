package codeJam;

import java.util.*;

public class problem1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = 0;
		if (scn.hasNext())
			tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int k = scn.nextInt();

			ArrayList<ArrayList<Integer>> ques = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < n; i++) {
				ArrayList<Integer> kArray = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					if (scn.hasNext())
						kArray.add(scn.nextInt());
				}
			}

			Random random = new Random();

			for (int i = 0; i < n; i++) {
				int randomInteger = random.nextInt(m) + 1;
				System.out.print(randomInteger+" ");
			}
		}

	}
}