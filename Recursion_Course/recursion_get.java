package Recursion_Course;

import java.util.ArrayList;

public class recursion_get {

	public static void main(String[] args) {
		
		System.out.println(getSS("abc"));
		
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;

		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}

		return mr;

	}

}
