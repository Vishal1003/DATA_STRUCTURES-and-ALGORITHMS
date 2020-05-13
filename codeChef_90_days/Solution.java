package codeChef_90_days;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc-- > 0) {
			int n = scn.nextInt();
			int s = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				if (scn.hasNext())
					arr[i] = scn.nextInt();
			}

			int[] play = new int[n];

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < play.length; i++) {
				
				if (scn.hasNext())
					play[i] = scn.nextInt();
				
				if (map.containsKey(play[i]) && map.get(play[i]) > arr[i]) {
					
					map.replace(play[i], arr[i]);
				} 
				
				else if (!map.containsKey(play[i])) {
					map.put(play[i], arr[i]);
				}
			}

			int sum = map.get(0) + map.get(1);

			if (s + sum <= 100) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}
}
