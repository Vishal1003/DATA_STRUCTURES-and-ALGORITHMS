package codeChef;

import java.util.Scanner;

class Point {
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	static void displayPoint(Point p) {
		System.out.println("(" + p.x + ", " + p.y + ")");
	}
}

class Test {
	static Point lineLineIntersection(Point A, Point B, Point C, Point D) {

		double a1 = B.y - A.y;
		double b1 = A.x - B.x;
		double c1 = a1 * (A.x) + b1 * (A.y);

		double a2 = D.y - C.y;
		double b2 = C.x - D.x;
		double c2 = a2 * (C.x) + b2 * (C.y);

		double determinant = a1 * b2 - a2 * b1;

		if (determinant == 0) {

			return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
		} else {
			double x = (b2 * c1 - b1 * c2) / determinant;
			double y = (a1 * c2 - a2 * c1) / determinant;
			return new Point(x, y);
		}
	}

	public static void main(String args[]) {

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
					Point intersection = lineLineIntersection(p1, q1, p2, q2);

					if (p1.x == p2.x && p1.y == p2.y) {
						if (q2.x <= p2.x)
							continue;
					}

					if (p1.x == q2.x && p1.y == q2.y) {
						if (q2.x >= p2.x)
							continue;
					}

					if (q1.x == p2.x && q1.y == p2.y) {
						if (q2.x >= p2.x)
							continue;
					}

					if (q1.x == q2.x && q1.y == q2.y) {
						if (q2.x <= p2.x)
							continue;
					}

					if (intersection.x == Double.MAX_VALUE && intersection.y == Double.MAX_VALUE) {
						continue;
					}

					else {
						if (x1 <= intersection.x && x2 >= intersection.x && y == intersection.y)
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
