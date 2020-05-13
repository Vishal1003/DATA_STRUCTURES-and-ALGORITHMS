package codeJam;

import java.util.*;

public class ronudB1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();
		while (tc-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			String ans = findPath(x, y, 0, 0, 1, "");
			if (ans.length() == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println("Case #" + tc + ": " + ans);
			}

		}

	}

	public static String findPath(int endX, int endY, int currx, int curry, int st, String ans) {

		if (Math.abs(currx) > Math.abs(endX) || Math.abs(curry) > Math.abs(endY)) {
			return ans;
		}

		if (currx == endX && curry == endY) {
			return ans;
		}

		else {
			int step = (int) Math.pow(2, st - 1);
			String east = findPath(endX, endY, currx + step, curry, st + 1, ans + "E");
			String west = findPath(endX, endY, currx - step, curry, st + 1, ans + "W");
			String north = findPath(endX, endY, currx, curry + step, st + 1, ans + "N");
			String south = findPath(endX, endY, currx, curry - step, st + 1, ans + "S");

			int es = east.length();
			int ws = west.length();
			int ns = north.length();
			int ss = south.length();

			if (es <= ws && es <= ns && es <= ss) {
				return east;
			} else if (ws <= es && ws <= ns && ws <= ss) {
				return west;
			} else if (ns <= es && ns <= ws && ns <= ss) {
				return north;
			} else {
				return south;
			}

		}

	}
}
