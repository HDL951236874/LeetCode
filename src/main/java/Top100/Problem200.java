package Top100;

public class Problem200 {
    public int numIslands(char[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    backtrack(grid, i, j);
                    c++;
                }
            }
        }
        return c;
    }

    public void backtrack(char[][] grid, int i, int j) {
        grid[i][j] = 'E';
        if (i > 0 && grid[i - 1][j] == '1') {
            backtrack(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            backtrack(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            backtrack(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            backtrack(grid, i, j + 1);
        }
    }
}
