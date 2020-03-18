package Recursion_Course;

public class recursion_print {

	public static void main(String[] args) {

//		printASCII("abc", "");
//		printSS("abc", "");
//		System.out.println(printPermutation("abc", ""));
//		System.out.println(printBoardPath(0, 3, ""));
//		System.out.println(printMazePathD(0, 0, 2, 2, ""));
		System.out.println(printMazePathDMM(0, 0, 2, 2, ""));

	}

//	print subSequences
	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ch);
		printSS(roq, ans);

	}

//	print ASCII subSeq
	public static void printASCII(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);
		String roq = str.substring(1);

		printASCII(roq, ans + ch);
		printASCII(roq, ans);
		printASCII(roq, ans + (int) ch);
	}

//	print permutation
	public static int printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int sum = 0;

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			sum += printPermutation(roq, ans + ch);
		}

		return sum;

	}

//	board path
	public static int printBoardPath(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans + "\n---------------");
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += printBoardPath(curr + dice, end, ans + dice);
		}

		return sum;
	}

//	mazePath
	public static int printMazePath(int cr, int cc, int er, int ec, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		int rh = printMazePath(cr, cc + 1, er, ec, ans + "H");
		int rv = printMazePath(cr + 1, cc, er, ec, ans + "V");

		return rh + rv;
	}

//	mazePath Diagonal
	public static int printMazePathD(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int rh = printMazePathD(cr, cc + 1, er, ec, ans + "H");
		int rv = printMazePathD(cr + 1, cc, er, ec, ans + "V");
		int rd = printMazePathD(cr + 1, cc + 1, er, ec, ans + "D");

		return rh + rv + rd;
	}

//	mazePath with moves
	public static int printMazePathDMM(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {

			System.out.println(ans);
			return 1;

		}

		int sum = 0;
		for (int move = 1; move <= ec - cc; move++) {
			sum += printMazePathDMM(cr, cc + 1, er, ec, ans + "H" + move);
		}

		for (int move = 1; move <= er - cr; move++) {
			sum += printMazePathDMM(cr + 1, cc, er, ec, ans + "V" + move);
		}

		for (int move = 1; move <= er - cr && move <= ec - cc; move++) {
			sum += printMazePathDMM(cr + 1, cc, er, ec, ans + "D" + move);
		}

		return sum;
	}
}
