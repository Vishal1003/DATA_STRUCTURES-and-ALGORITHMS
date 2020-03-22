package codeChef;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = scn.nextInt();
		for (int t = 1; t <= tc; ++t) {
			int n = scn.nextInt();
			int k = scn.nextInt();

			int arr[] = new int[n];
			int arr1[] = new int[n];

			for (int i = 0; i < n; i++) {
				if (scn.hasNext())
					arr[i] = scn.nextInt();
			}

			pair_Diff(arr, arr1, n);

			for (int i = 0; i < k; i++) {
				
				arr1[n - 1] = arr1[n - 1] - 1;

			}

			System.out.println("Case #" + t + ": " + arr1[n - 1]);

		}
	}

	public static void pair_Diff(int[] arr, int[] arr1, int n) {

		int diff = 0;
		for (int i = 0; i < n - 1; i++) {
			diff = arr[i + 1] - arr[i];
			arr1[i] = diff;
		}

	}

}