package codeForces;

import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc-- > 0) {

			int a = scn.nextInt();
			int b = scn.nextInt();
			int c = scn.nextInt();
			int d = scn.nextInt();
			int found = 1;
			boolean aloop = false;
			boolean bloop = false;
			boolean cloop = false;

			if (a != b) {
				aloop = true;
			}

			if (b != c) {
				bloop = true;
			}

			if (c != d) {
				cloop = true;
			}

			if (aloop) {
				for (int i = a; i <= b; i++) {
					int l = b;
					int r = c;
					if (bloop && cloop) {
						while (l <= c && r <= d) {
							if (l + r > i && l + i > r && i + r > l) {
								System.out.println(i + " " + l + " " + r);
								found = 0;
								break;
							} else {
								l++;
								r++;
							}
						}
					} else if (bloop) {
						while (l <= c) {
							if (l + r > i && l + i > r && i + r > l) {
								System.out.println(i + " " + l + " " + r);
								found = 0;
								break;
							} else {
								l++;
							}
						}
					} else if (cloop) {
						while (r <= d) {
							if (l + r > i && l + i > r && i + r > l) {
								System.out.println(i + " " + l + " " + r);
								found = 0;
								break;
							} else {
								r++;
							}
						}

					}

					if (found == 0) {
						break;
					}

				}
			} else {
				int l = b;
				int r = c;
				if (bloop && cloop) {
					while (l <= c && r <= d) {
						if (l + r > b && l + b > r && b + r > l) {
							System.out.println(b + " " + l + " " + r);
							found = 0;
							break;
						} else {
							l++;
							r++;
						}
					}
				} else if (bloop) {
					while (l <= c) {
						if (l + r > b && l + b > r && b + r > l) {
							System.out.println(b + " " + l + " " + r);
							found = 0;
							break;
						} else {
							l++;
						}
					}
				} else if (cloop) {
					while (r <= d) {
						if (l + r > a && l + a > r && a + r > l) {
							System.out.println(a + " " + l + " " + r);
							found = 0;
							break;
						} else {
							r++;
						}
					}

				}

			}
		}
	}

}
