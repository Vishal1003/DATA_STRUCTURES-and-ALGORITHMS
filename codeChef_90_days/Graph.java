package codeChef_90_days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;

class AllPathBetweenTwoNodes {
	static int dim = 5; // dim is number of nodes in graph
//color is used to mark if the node is visited or not
	static boolean[] color = new boolean[dim + 1];

	// graph is given in 2-D matrix form
	static int[][] graph = new int[10][10];

	// this list will store nodes on the path from source to destination
	static ArrayList<Integer> list = new ArrayList<Integer>();

	// this is the size of "list" declared above
	// size is used to remember index of the node in the list to be removed
	// when the node is marked unvisited
	static int size;

	public static void main(String... args) throws IOException {

		BufferedReader br = new BufferedReader(/* new FileReader("input.txt") */new InputStreamReader((System.in)));
		for (int I = 1; I <= dim; I++) {

			String[] input = br.readLine().split(" ");
			int len = input.length;

			for (int J = 1; J <= len; J++) {
				graph[I][J] = Integer.parseInt(input[J - 1]);
			}
		}

		Arrays.fill(color, false);// initially all are unvisited

		int src = Integer.parseInt(br.readLine()); // Source node
//Destination node        
		int dst = Integer.parseInt(br.readLine());

		dfs(src, dst); // backtracking
	}

	static void dfs(int src, int dst) {
		// node added to path
		list.add(src);
		size++;

		// node marked as visited
		color[src] = true;

		// when the destination node is found
		if (src == dst) {

			// Print the path
			for (Integer node : list) {
				System.out.print(node + "  ");
			}
			System.out.println();
			return;
		}

		for (int I = 1; I <= dim; I++) {
			// if there's an edge between src and node
			if (graph[src][I] == 1) {

				// and that node is not visited yet
				if (color[I] == false) {

					// start dfs from that node
					dfs(I, dst);

					// This line is critical to understand
					// it marks the node unvisited which we have just visited
					// so that the dfs could find another path to destination
					color[I] = false;

					// size of list reduced by 1
					// as the node is marked unvisited
					// hence removed from the list
					size--;

					// remove that node at index "size" from list
					list.remove(size);
				}
			}
		}
	}
}