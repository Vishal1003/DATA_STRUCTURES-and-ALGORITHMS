package codeChef;

import java.util.Scanner;

public class LAZER {

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;

		}

	};

	static boolean collinearity(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
				&& q.y >= Math.min(p.y, r.y))
			return true;

		return false;
	}

	static int orientation(Point p, Point q, Point r) {

		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0;

		return (val > 0) ? 1 : 2;
	}

	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {

		if (p1.x == p2.x && p1.y == p2.y) {
			if (q2.x <= p2.x)
				return false;
		}

		if (p1.x == q2.x && p1.y == q2.y) {
			if (q2.x >= p2.x)
				return false;
		}

		if (q1.x == p2.x && q1.y == p2.y) {
			if (q2.x >= p2.x)
				return false;
		}

		if (q1.x == q2.x && q1.y == q2.y) {
			if (q2.x <= p2.x)
				return false;
		}

		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4)
			return true;

		if (o1 == 0 && collinearity(p1, p2, q1))
			return true;

		if (o2 == 0 && collinearity(p1, q2, q1))
			return true;

		if (o3 == 0 && collinearity(p2, p1, q2))
			return true;

		if (o4 == 0 && collinearity(p2, q1, q2))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = 0;

		if (scn.hasNextInt()) {
			tc = scn.nextInt();
		}

		while (tc > 0) {

			int n = scn.nextInt();
			int q = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNextInt())
					arr[i] = scn.nextInt();

			}

			while (q > 0) {

				int count = 0;

				int x1 = scn.nextInt();
				int x2 = scn.nextInt();
				int y = scn.nextInt();

				for (int i = 0; i < arr.length - 1; i++) {
					Point p1 = new Point(x1, y);
					Point q1 = new Point(x2, y);
					Point p2 = new Point(i + 1, arr[i]);
					Point q2 = new Point(i + 2, arr[i + 1]);
					if (doIntersect(p1, q1, p2, q2)) {
						count++;
					}
				}

				System.out.print(count + "\n");

				q--;

			}

			tc--;
		}

	}

}
