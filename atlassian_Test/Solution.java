package atlassian_Test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'paperCuttings' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER textLength 2. INTEGER_ARRAY starting 3.
	 * INTEGER_ARRAY ending
	 */

	public static long paperCuttings(int textLength, List<Integer> starting, List<Integer> ending) {

		long count = 0;
		for (int i = 0; i < starting.size(); i++) {
			for (int j = 0; j < ending.size(); j++) {
				if (i != j && ending.get(i) < starting.get(j)) {
					count++;
				} else
					continue;
			}
		}

		return count;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int textLength = Integer.parseInt(bufferedReader.readLine().trim());

		int startingCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> starting = IntStream.range(0, startingCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int endingCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ending = IntStream.range(0, endingCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = Result.paperCuttings(textLength, starting, ending);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
