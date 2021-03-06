package Recursion;

public class recursion3 {
	public static void main(String[] args) {

		String str = "hichihihicdhicdhighhi";
		String str1 = "axxxhgh";

//		System.out.println(isReverse(str1, str2, 0));
//		System.out.println(isPalindrome(str1, 0));
//		System.out.println(replaceD(str, 0));
//		System.out.println(reduceD(str, 0));

		System.out.println(movesX(str1, 0, str.length()));
//		System.out.println(removeHi(str, 0));

//		System.out.println(printSum(str, 0, 0));
//		System.out.println(convertInt(str, 0, str.length() - 1, 1));

	}

//	print the sum of numbers in a string
	public static int printSum(String str, int sum, int i) {
		if (i == str.length())
			return sum;

		if (Character.isDigit(str.charAt(i))) {
			sum = sum + Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		return printSum(str, sum, i + 1);
	}

//	convert the string number in an integer number
	public static int convertInt(String str, int ans, int i, int multiplier) {
		if (i == -1) {
			return ans;
		}

		ans = ans + multiplier * Integer.parseInt(String.valueOf(str.charAt(i)));

		return convertInt(str, ans, i - 1, multiplier * 10);
	}

//	check is string2 is the reverse of string1
	public static boolean isReverse(String str1, String str2, int i) {

		if (str1.length() != str2.length())
			return false;

		if (i == str1.length()) {
			return true;
		}

		if (str1.charAt(i) == str2.charAt(str2.length() - 1 - i))
			return isReverse(str1, str2, i + 1);

		return false;
	}

//	check if a string is palindrome or not
	public static boolean isPalindrome(String str, int i) {
		if (i == (str.length()) / 2) {
			return true;
		}

		if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
			return isPalindrome(str, i + 1);
		}

		return false;
	}
	
	
//	replace duplicate character of a string with *
	public static String replaceD(String str, int i) {

		if (i == str.length() - 1 || i == str.length()) {
			return str;
		}

		if (str.charAt(i) == str.charAt(i + 1)) {
			str = str.substring(0, i + 1) + "*" + str.substring(i + 1);
		}

		return replaceD(str, i + 1);

	}

//	reduce the duplicate element
	public static String reduceD(String str, int i) {
		if (i == str.length() - 1 || i == str.length())
			return str;

		if (str.charAt(i) == str.charAt(i + 1)) {
			str = str.substring(0, i) + str.substring(i + 1);
		}

		return reduceD(str, i + 1);
	}

//	move the character "x" present in a string to end
	public static String movesX(String str, int i, int length) {

		if (i == length - 1 || i == length)
			return str;

		if (str.charAt(i) == 'x') {
			str = str.substring(0, i) + str.substring(i + 1) + 'x';
			
		}

		return movesX(str, i + 1, length);

	}

//	count the number of times a word appears in a string
	public static int countHi(String str, int i, int count) {
		if (i == str.length() - 1)
			return count;

		if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
			count = count + 1;
		}

		return countHi(str, i + 1, count);

	}

//	remove all the occurrences of a word in a string
	public static String removeHi(String str, int i) {
		if (i == str.length() - 1 || i == str.length())
			return str;

		if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {

			if (i + 2 <= str.length() - 1)
				str = str.substring(0, i) + str.substring(i + 2);
			else
				str = str.substring(0, i);

			i = i - 1;
		}

		return removeHi(str, i + 1);

	}

}
