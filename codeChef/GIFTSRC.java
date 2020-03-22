package codeChef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class GIFTSRC {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 0; t < tc; t++) {

			int n = scn.nextInt();
			String str = scn.next();

			int x = 0;
			int y = 0;
			int count = -1;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'L' && count != 0) {
					x = x - 1;
					count = 0;
				}

				else if (str.charAt(i) == 'R' && count != 0) {
					x = x + 1;
					count = 0;
				}

				else if (str.charAt(i) == 'U' && count != 1) {
					y = y + 1;
					count = 1;
				}

				else if (str.charAt(i) == 'D' && count != 1) {
					y = y - 1;
					count = 1;
				}
			}
			
			System.out.println(x+" "+y);

		}
	}

}
