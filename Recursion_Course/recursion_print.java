package Recursion_Course;

public class recursion_print {

	public static void main(String[] args) {

//		printASCII("abc", "");
//		printSS("abc", "");
//		System.out.println(printPermutation("abc", ""));
		System.out.println(printBoardPath(0, 3, ""));

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

}
