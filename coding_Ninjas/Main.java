package coding_Ninjas;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int counter = 0;

		for (int i = 0; i < n; i++) {
			int value = scn.nextInt();

			if (map.containsKey(value + 1)) {
				map.put(value + 1, map.get(value + 1) - 1);

				if (map.get(value + 1) == 0) {
					map.remove(value + 1);
				}

				if (map.containsKey(value) == true) {
					map.put(value, map.get(value) + 1);
				}

				else {
					map.put(value, 1);
				}

			} else {
				if (map.containsKey(value)) {
					map.put(value, map.get(value) + 1);
				} else {
					map.put(value, 1);
				}
			}

		}

		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int val : al) {
			counter += map.get(val);
		}

		System.out.println(counter);
		scn.close();

	}

}