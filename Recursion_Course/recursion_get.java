package Recursion_Course;

import java.util.ArrayList;

public class recursion_get {

	public static void main(String[] args) {

//		System.out.println(getSS("abc"));
//		System.out.println(getSSAscii("ab"));
//		System.out.println(permutation("abc"));
//		System.out.println(boardPath(0, 2));
//		System.out.println(mazePath(0, 0, 2, 2));
//		System.out.println(mazePathMM(0, 0, 2, 2));
//		System.out.println(coinToss(3));
		System.out.println(paranthesis(3));

	}

//	print Subsequences

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;

		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}

		return mr;

	}

//	Print Ascii Subsequences

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSSAscii(ros);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add(val);
			mr.add(val + ch);
			mr.add(val + (int) ch);
		}

		return mr;
	}

//	Function to print the permutation of the string.

	public static ArrayList<String> permutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = permutation(ros);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		return mr;
	}

//	print all the possible board paths (diagonals of square mtx) from current to end

	public static ArrayList<String> boardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> nr = new ArrayList<String>();
			return nr;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = boardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(val + dice);
			}
		}

		return mr;

	}

//	print all the possible board path with initial dice as 1 or 6

	public static ArrayList<String> getBoardPath16(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> nr = new ArrayList<String>();
			return nr;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int dice = 1; dice <= 6; dice++) {

			if ((curr == 0 && (dice == 1 || dice == 6)) || curr != 0) {
				ArrayList<String> rr = getBoardPath16(curr + dice, end);

				for (String val : rr) {
					mr.add(val + dice);
				}

			}
		}

		return mr;
	}

//	print all the possible maze path (no diagonal)

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> nr = new ArrayList<String>();
			return nr;
		}

		ArrayList<String> mr = new ArrayList<String>();

		ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		return mr;

	}

//	print all possible maze path (with diagonal)

	public static ArrayList<String> mazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> nr = new ArrayList<String>();
			return nr;
		}

		ArrayList<String> mr = new ArrayList<String>();

		ArrayList<String> rrh = mazePathD(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = mazePathD(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrd = mazePathD(cr + 1, cc + 1, er, ec);

		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;

	}

//	print all possible maze path (with moves)

	public static ArrayList<String> mazePathMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int move = 1; move <= ec - cc; move++) {
			ArrayList<String> rrh = mazePathMM(cr, cc + move, er, ec);

			for (String val : rrh) {
				mr.add("H" + move + val);
			}
		}

		for (int move = 1; move <= er - cr; move++) {
			ArrayList<String> rrv = mazePathMM(cr + move, cc, er, ec);

			for (String val : rrv) {
				mr.add("V" + move + val);
			}
		}

		for (int move = 1; move <= ec - cc && move <= er - cr; move++) {
			ArrayList<String> rrd = mazePathMM(cr + move, cc + move, er, ec);

			for (String val : rrd) {
				mr.add("D" + move + val);
			}
		}

		return mr;

	}

//	print all possible outcomes of n coin tosses

	public static ArrayList<String> coinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;

	}

	public static ArrayList<String> paranthesis(int n) {
		if (n == 1) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("()");
			return br;
		}

		ArrayList<String> rr = paranthesis(n - 1);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add("(" + val + ")");

			mr.add("()" + val);

			if (!mr.contains(val + "()")) {
				mr.add(val + "()");
			}
		}
		return mr;
	}
}
