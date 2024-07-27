package Old.ArrayList;

import java.util.Arrays;

public class Problem79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //do the
                    char[][] temp = copy(board);
                    temp[i][j] = '0';
                    if (backtrack(temp, word, i, j, 1)) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word,   int i, int j, int index) {
        if (index == word.length()) return true;

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        if (i > 0 && board[i - 1][j] == word.charAt(index)) {
            char[][] temp = copy(board);;
            temp[i-1][j] = '0';
            b1 = backtrack(temp, word, i - 1, j, index + 1);
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(index)) {
            char[][] temp = copy(board);;
            temp[i+1][j] = '0';
            b2 = backtrack(temp, word, i + 1, j, index + 1);
        }
        if (j > 0 && board[i][j - 1] == word.charAt(index)) {
            char[][] temp = copy(board);;
            temp[i][j-1] = '0';
            b3 = backtrack(temp, word, i, j - 1, index + 1);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(index)) {
            char[][] temp = copy(board);;
            temp[i][j+1] = '0';
            b4 = backtrack(temp, word, i, j + 1, index + 1);
        }
        return b1 || b2 || b3 || b4;
    }
    public char[][] copy(char[][] chars){
        char[][] res = new char[chars.length][chars[0].length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                res[i][j] = chars[i][j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Problem79 p = new Problem79();
        char[][] in = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String str = "AAB";
        p.exist(in,str);
    }
}
