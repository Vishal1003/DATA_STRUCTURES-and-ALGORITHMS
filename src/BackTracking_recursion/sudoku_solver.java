package BackTracking_recursion;

import java.util.Scanner;

public class sudoku_solver {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		sudoku_Solver(arr, 0, 0);

	}

	public static void sudoku_Solver(int[][] arr, int row, int col) {

		// base case
		if (row == arr.length) {
			display(arr);
			return;
		}

		// work on new row
		if (col == arr[0].length) {
			sudoku_Solver(arr, row + 1, 0);
			return;
		}

		// if a value is already present move to next col
		if (arr[row][col] != 0) {
			sudoku_Solver(arr, row, col + 1);
			return;
		}

		// self work
		for (int i = 1; i <= 9; i++) {

			if (isItSafe(arr, row, col, i)) {
				arr[row][col] = i;

				sudoku_Solver(arr, row, col + 1);

				arr[row][col] = 0;
			}
		}

	}

	public static boolean isItSafe(int[][] arr, int row, int col, int val) {
		return IsItSafeRow(arr, row, val) && IsItSafeCol(arr, col, val) && IsItSafeCell(arr, row, col, val);
	}

	public static boolean IsItSafeCell(int[][] arr, int row, int col, int val) {

		int rs = row - row % 3;
		int cs = col - col % 3;

		for (int r = rs; r < rs + 3; r++) {
			for (int c = cs; c < cs + 3; c++) {
				if (arr[r][c] == val)
					return false;
			}
		}

		return true;

	}

	public static boolean IsItSafeCol(int[][] arr, int col, int val) {

		for (int row = 0; row < arr.length; row++) {
			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static boolean IsItSafeRow(int[][] arr, int row, int val) {

		for (int col = 0; col < arr[0].length; col++) {
			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println("--------------------");

	}

}
