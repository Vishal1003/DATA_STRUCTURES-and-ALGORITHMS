package BackTracking_recursion;

public class rat_inMaze {

	public static void main(String[] args) {

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		display(maze);
		System.out.println(blockedMaze(maze, 0, 0, "", new boolean[4][4]));

	}

//	Display of the maze
	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

//	rat in a maze problem or blocked maze
	public static int blockedMaze(int[][] maze, int cr, int cc, String ans, boolean[][] visited) {

		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println(ans);
			return 1;
		}

		if (cr < 0 || cr >= maze.length || cc < 0 || cc >= maze[0].length || maze[cr][cc] == 1 || visited[cr][cc]) {
			return 0;
		}

		visited[cr][cc] = true;

		// DTLR
		int d = blockedMaze(maze, cr + 1, cc, ans + "D", visited);
		int t = blockedMaze(maze, cr - 1, cc, ans + "T", visited);
		int l = blockedMaze(maze, cr, cc - 1, ans + "L", visited);
		int r = blockedMaze(maze, cr, cc + 1, ans + "R", visited);

		// Backtrack
		visited[cr][cc] = false;

		return d + t + l + r;

	}

	
	
}
