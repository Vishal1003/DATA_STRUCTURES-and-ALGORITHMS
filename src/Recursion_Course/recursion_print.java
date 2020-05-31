package Recursion_Course;

public class recursion_print {

	public static void main(String[] args) {

//		printASCII("abc", "");
//		printSS("abc", "");
//		System.out.println(printPermutation("abc", ""));
//		System.out.println(printBoardPath(0, 3, ""));
//		System.out.println(printMazePathD(0, 0, 2, 2, ""));
//		System.out.println(printMazePathDMM(0, 0, 2, 2, ""));
		printLexicoCount2(1, 100);

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

//	print Lexico Counting starting from same digit
	public static void printLexicoCount(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;
		if (curr == 0) {
			i = 1;
		}

		while (i <= 9) {
			printLexicoCount(curr * 10 + i, end);
			i++;
		}

	}

//	lexicoGraphical printing
	public static void printLexicoCount2(int curr, int end) {
		if (curr > end) {
			return;
		}

		System.out.println(curr);

		for (int i = 0; i <= 9; i++) {
			printLexicoCount2(curr * 10 + i, end);
		}

		if (curr + 1 <= 9) {
			printLexicoCount2(curr + 1, end);
		}
	}

//	permutation with no Duplicates
	public static int permutationNodp(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int sum = 0;
		boolean visited[] = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);

			if (visited[ch]) {
				continue;
			}

			String roq = ques.substring(0, i) + ques.substring(i + 1);

			sum += permutationNodp(roq, ans + ch);

			visited[ch] = true;
		}

		return sum;
	}

//	coin Toss
	public static void coinToss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "V");
	}

// 	coin Toss with no consecutive heads
	public static void coinTossNoConsecutiveHead(int n, String ans, boolean wasHeadIncluded) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasHeadIncluded) {
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else {
			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		}
	}

//	coin Toss with no consecutive heads and tails
	public static void coinTossNoConsecutive(int n, String ans, boolean wasHeadIncluded, boolean wasTailIncluded) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasHeadIncluded == false && wasTailIncluded == false) {
			coinTossNoConsecutive(n - 1, ans + "H", true, false);
			coinTossNoConsecutive(n - 1, ans + "T", false, true);
		}

		if (wasHeadIncluded) {
			coinTossNoConsecutive(n - 1, ans + "T", false, true);
		}

		if (wasTailIncluded) {
			coinTossNoConsecutive(n - 1, ans + "H", true, false);
		}

	}
}
