package KMP;

import java.util.*;

public class kmp_algo {

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);

		String txt = scn.next();
		String pat = scn.next();

		KMPSearch(pat, txt);

	}

	public static void computeLPS(String pat, int m, int lps[]) {

		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}

			else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}

			}
		}

	}

	public static void KMPSearch(String pat, String txt) {
		int m = pat.length();
		int n = txt.length();

		int lps[] = new int[m];
		int j = 0;

		computeLPS(pat, m, lps);

		int i = 0;
		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}

			if (j == m) {
				System.out.println("Pattern found at index : " + (i - j));
				j = lps[j - 1];
			}

			else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}

		}
	}

}
