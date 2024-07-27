package Old.ArrayList;

import java.util.*;

public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> listRow = new ArrayList<>();
        List<Set<Character>> listCol = new ArrayList<>();
        List<Set<Character>> listCube = new ArrayList<>();
        for(int n = 0 ; n<9;n++){
            listRow.add(new HashSet<Character>());
            listCol.add(new HashSet<Character>());
            listCube.add(new HashSet<Character>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != ".".toCharArray()[0]) {
                    boolean flag1 = listRow.get(i).add(board[i][j]);
                    boolean flag2 = listCol.get(j).add(board[i][j]);
                    boolean flag3 = listCube.get((i/3)*3+j/3).add(board[i][j]);
                    System.out.println(board[i][j]);
                    if (!(flag1&&flag2&&flag3)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem36 p = new Problem36();
        System.out.println(p.isValidSudoku(new char[][]{{"1".toCharArray()[0],"1".toCharArray()[0]},{"1".toCharArray()[0],"1".toCharArray()[0]}}));

    }
}

