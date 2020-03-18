package BackTracking_recursion;

public class n_Queens2 {

	public static void main(String[] args) {

		boolean[][] board = new boolean[4][4];

		nQueens(board, 0, "", 0, 3);

	}

	public static void nQueens(boolean[][] board, int row, String ans, int qpsf, int total) {

		if (qpsf == total) {
			System.out.println(ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(board, row, col)) {

				board[row][col] = true;
				nQueens(board, row + 1, ans + "[" + row + "-" + col + "]", qpsf + 1, total);
				board[row][col] = false;

			}
		}

		nQueens(board, row + 1, ans, qpsf, total);

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
