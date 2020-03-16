package Recursion_Course;

import java.util.ArrayList;

public class recursion_get {

	public static void main(String[] args) {

//		System.out.println(getSS("abc"));
//		System.out.println(getSSAscii("ab"));
		System.out.println(permutation("abc"));

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

//	print all the possible paths (diagonals) from current to end

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

}