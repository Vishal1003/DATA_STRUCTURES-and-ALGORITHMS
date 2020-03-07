package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class string1 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
//		System.out.println(isPalindrome(str));
//		System.out.println(subString(str));
//		permutation(str);
//		maxOccurance(str);
//		removeDuplicates(str);
		stringCompression(str);

	}

	public static boolean isPalindrome(String str) {

		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static int subString(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String ans = str.substring(i, j);
				if (isPalindrome(ans)) {
					count++;
					System.out.println(ans);
				}
			}
		}
		return count;
	}

	public static void permutation(String str) {

		ArrayList<String> ans = new ArrayList<String>();

		ans.add(String.valueOf(str.charAt(0))); // valueOf(c) coverts different type of datatype to String

		for (int i = 1; i < str.length(); i++) {

			for (int j = ans.size() - 1; j >= 0; j--) {
				String rm = ans.remove(j);

				for (int k = 0; k <= rm.length(); k++) {
					ans.add(rm.substring(0, k) + str.charAt(i) + rm.substring(k));
				}
			}

		}
		System.out.println(ans);
	}

	public static void maxOccurance(String str) {
		int max = 0;
		int count = 0;
		int index = -1;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {

				if (str.charAt(i) == str.charAt(j))
					count++;

			}
			if (count > max) {
				max = count;
				index = i;
			}
		}

		if (index == -1) {
			System.out.println("All Occured the same number of times");
		} else
			System.out.println(str.charAt(index));
	}

	public static void removeDuplicates(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {

				if (str.charAt(i) == str.charAt(j)) {
					str = str.substring(0, j) + str.substring(j + 1);
					j = j - 1;
				}
			}
		}

		System.out.println(str);
	}

	public static void stringCompression(String str) {

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
					str = str.substring(0, j) + str.substring(j + 1);
					j = j - 1;
				}
			}
			str = str.substring(i) + count + str.substring(i);
		}
	}
}
