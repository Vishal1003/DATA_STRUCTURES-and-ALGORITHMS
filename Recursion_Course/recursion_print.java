package Recursion_Course;

public class recursion_print {

	public static void main(String[] args) {

		printASCII("abc", "");
//		printSS("abc", "");

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

}
