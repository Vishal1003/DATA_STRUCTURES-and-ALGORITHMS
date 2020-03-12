package Recursion;

public class recursion3 {
	public static void main(String[] args) {
		String str = "ab23cd3f4";

		System.out.println(printSum(str, 0, 0));
	}

	public static int printSum(String str, int sum, int i) {
		if (i == str.length())
			return sum;

		if (Character.isDigit(str.charAt(i))) {
			sum = sum + Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		return printSum(str, sum, i + 1);
	}
}
