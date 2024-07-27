package Top100;

public class Problem289 {
    public void gameOfLife(int[][] board) {
        int[][] new_board = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = calculate(board, i, j);
                if (num == 3) new_board[i][j] = 1;
                else if (num < 2 || num > 3) new_board[i][j] = 0;
                else new_board[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new_board[i][j];
            }
        }
    }

    public int calculate(int[][] board, int i, int j) {
        int up = Math.max(0, i - 1);
        int down = Math.min(board.length - 1, i + 1);
        int left = Math.max(0, j - 1);
        int right = Math.min(board[0].length - 1, j + 1);
        int sum = 0;
        for (int k = up; k <= down; k++) {
            for (int l = left; l <= right; l++) {
                if(k==i&&l==j) continue;
                sum += board[k][l];
            }
        }
        return sum;
    }
}
