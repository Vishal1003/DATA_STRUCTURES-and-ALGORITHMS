package Suffix_Array;

import java.util.*;

public class suffix_Array {

	public static void main(String[] args) {

		String str = "banana";

		int[] suff_arr = suffixArray(str);

		for (int i = 0; i < suff_arr.length; i++) {
			System.out.print(suff_arr[i] + " ");
		}

		System.out.println("--------");

		String pat = "nan";
		search(pat, str, suff_arr, str.length());

	}

//	creating suffix array
	public static int[] suffixArray(String s) {
		int n = s.length();
		Suffix[] su = new Suffix[n];

		for (int i = 0; i < n; i++) {
			su[i] = new Suffix(i, s.charAt(i) - '$', 0);
		}
		for (int i = 0; i < n; i++)
			su[i].next = (i + 1 < n ? su[i + 1].rank : -1);

		Arrays.sort(su);

		int[] ind = new int[n];

		for (int length = 4; length < 2 * n; length <<= 1) {

			int rank = 0, prev = su[0].rank;
			su[0].rank = rank;
			ind[su[0].index] = 0;
			for (int i = 1; i < n; i++) {
				if (su[i].rank == prev && su[i].next == su[i - 1].next) {
					prev = su[i].rank;
					su[i].rank = rank;
				} else {
					prev = su[i].rank;
					su[i].rank = ++rank;
				}
				ind[su[i].index] = i;
			}

			for (int i = 0; i < n; i++) {
				int nextP = su[i].index + length / 2;
				su[i].next = nextP < n ? su[ind[nextP]].rank : -1;
			}
			Arrays.sort(su);
		}
		int[] suf = new int[n];

		for (int i = 0; i < n; i++)
			suf[i] = su[i].index;

		return suf;

	}

// 	class for storing suffix properties
	public static class Suffix implements Comparable<Suffix> {
		int index;
		int rank;
		int next;

		public Suffix(int ind, int r, int nr) {
			index = ind;
			rank = r;
			next = nr;
		}

		public int compareTo(Suffix s) {
			if (rank != s.rank)
				return Integer.compare(rank, s.rank);
			return Integer.compare(next, s.next);
		}
	}

//	searching a particular pattern
	public static void search(String pat, String txt, int[] suffArr, int n) {

		int l = 0;
		int r = n - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;
			
			int res = pat.compareTo(txt + suffArr[mid]);

			if (res == 0) {
				System.out.println("Pattern found at index : " + suffArr[mid]);
				return;
			}

			else if (res < 0) {
				r = mid - 1;
			}

			else {
				l = mid + 1;
			}
		}

		System.out.println("Pattern not found");
	}

}
