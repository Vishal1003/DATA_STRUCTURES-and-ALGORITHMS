package BackTracking_recursion;

public class n_Queens {

	public static void main(String[] args) {

		boolean[][] board = new boolean[4][4];
		NQueens(board, 0, "");

	}

//	print all the possible ways 4 queens can be placed in a 4x4 chess board
	public static void NQueens(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				NQueens(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}

	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c])
				return false;

			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c])
				return false;

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c])
				return false;
			r--;
			c++;
		}

		// all fine
		return true;

	}

}
