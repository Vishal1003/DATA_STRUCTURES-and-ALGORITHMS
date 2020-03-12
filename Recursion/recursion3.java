package Recursion;

public class recursion3 {
	public static void main(String[] args) {
		String str = "123456";

//		System.out.println(printSum(str, 0, 0));
		System.out.println(convertInt(str, 0, str.length()-1, 1));
	}

	public static int printSum(String str, int sum, int i) {
		if (i == str.length())
			return sum;

		if (Character.isDigit(str.charAt(i))) {
			sum = sum + Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		return printSum(str, sum, i + 1);
	}

	public static int convertInt(String str, int ans, int i, int multiplier) {
		if (i == -1) {
			return ans;
		}

		ans = ans + multiplier * Integer.parseInt(String.valueOf(str.charAt(i)));

		return convertInt(str, ans, i - 1, multiplier * 10);
	}
}
