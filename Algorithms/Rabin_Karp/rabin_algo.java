package Rabin_Karp;

public class rabin_algo {

	public static final int d = 256;

	public static void Search(String pat, String txt, int q) {
		int m = pat.length();
		int n = txt.length();

		int i, j;
		int p = 0; // hash value of the pattern
		int t = 0; // hash value of text
		int h = 1;

		for (i = 0; i < m - 1; i++) {
			h = (h * d) % q;
		}

		for (i = 0; i < m; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		for (i = 0; i <= n - m; i++) {
			if (p == t) {
				for (j = 0; j < m; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				if (j == m)
					System.out.println("Pattern found at index " + i);
			}

			if (i < n - m) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

				if (t < 0)
					t = (t + q);
			}
		}

	}
	
	public static void main(String[] args) 
    { 
        String txt = "GEEKS FOR GEEKS"; 
        String pat = "GEEK"; 
        int q = 101; // A prime number 
        Search(pat, txt, q); 
    } 

}
