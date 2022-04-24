package Top100;

public class Problem130 {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O'){
                backtrack(board,i,0);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][board[0].length-1] == 'O'){
                backtrack(board,i,board[0].length-1);
            }
        }

        for (int j = 1; j < board[0].length-1; j++) {
            if(board[0][j] == 'O'){
                backtrack(board,0,j);
            }
        }

        for (int j = 1; j < board[0].length; j++) {
            if(board[board.length-1][j] == 'O'){
                backtrack(board,board.length-1,j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void backtrack(char[][] board, int i, int j) {
        board[i][j] = 'E';
        if (i > 0 && board[i - 1][j] == 'O') {
            backtrack(board, i - 1, j);
        }
        if (i < board.length-1 && board[i + 1][j] == 'O') {
            backtrack(board, i + 1, j);
        }
        if (j > 0 && board[i][j-1] == 'O') {
            backtrack(board, i, j-1);
        }
        if (j < board[0].length-1 && board[i][j+1] == 'O') {
            backtrack(board, i, j+1);
        }
    }
}
