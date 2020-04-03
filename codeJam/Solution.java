package codeJam;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		for (int t = 1; t <= tc; t++) {

			person cameron = new person('C');
			person jamie = new person('J');

			int n = scn.nextInt();

			act allacts[] = new act[1000];

			boolean flag = false;
			String str = "";
			for (int i = 0; i < n; i++) {
				allacts[i].s = scn.nextInt();
				allacts[i].e = scn.nextInt();
			}
			for (int i = 0; i < n; i++) {
				if (cameron.isBusy(allacts[i]) && jamie.isBusy(allacts[i])) {
					flag = true;
				} else if (!cameron.isBusy(allacts[i])) {
					str += 'C';
					cameron.addact(allacts[i]);
				} else {
					str += 'J';
					jamie.addact(allacts[i]);
				}
			}
			if (flag) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + str);
			}
		}
	}

	public static class act {
		public int s = 0;
		public int e = 0;
	}

	public static class person {
		public char name;
		public int n;

		act[] acts = new act[1000];

		public person(char name) {
			this.name = name;
			this.n = 0;
		}

		public void addact(act a) {
			this.acts[n] = a;
			n++;
		}

		public boolean isBusy(act a) {
			for (int i = 0; i < n; i++) {
				if (a.s < acts[i].e && acts[i].s < a.e) {
					return true;
				}
			}

			return false;
		}

	}

}
