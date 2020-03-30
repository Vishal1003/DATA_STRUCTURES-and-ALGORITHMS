package codeChef_90_days;

import java.util.HashMap;
import java.util.Scanner;

public class day1 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		reverse();
		lapindrome();
	}

	private static void lapindrome() {
		int tc = scn.nextInt();

		while (tc > 0) {

			String str = scn.next();
			HashMap<Character, Integer> map = new HashMap<>();

			int fh = 0;
			int end = 0;
			int sh = 0;

			if (str.length() % 2 == 0) {
				sh = str.length() / 2;
				end = sh - 1;
			} else {
				sh = str.length() / 2 + 1;
				end = sh - 1;
			}

			for (int i = fh; i <= end; i++) {
				if (map.containsKey(str.charAt(i))) {
					map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);

				} else {
					map.put(str.charAt(i), 1);
				}
			}

			int f =0;
			
			for (int i = sh; i < str.length(); i++) {
				if (!map.containsKey(str.charAt(i))) {
					System.out.println("NO");
					f=1;
					break;
				}
				
				else if(map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) == 0) {
					System.out.println("NO");
					f=1;
					break;
				}

				else if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) != 0) {
					map.replace(str.charAt(i), map.get(str.charAt(i)) - 1);
				}
			}
			
			if(f==0) {
				System.out.println("YES");
			}

		}

	}

	private static void reverse() {
		int tc = scn.nextInt();

		for (int i = 0; i < tc; i++) {
			int n = scn.nextInt();
			int ans = 0;

			while (n != 0) {
				int digit = n % 10;
				ans = ans * 10 + digit;
				n /= 10;
			}

			System.out.println(ans);
		}

	}

}
