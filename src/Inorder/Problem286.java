package Inorder;

import java.util.Arrays;

public class Problem286 {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    int[][] path = new int[rooms.length][rooms[0].length];
                    backtrack(rooms,i,j,0,path);
                }
            }
        }
    }

    public void backtrack(int[][] rooms, int i, int j, int distance, int[][] path) {
        path[i][j] = 1;
        if (rooms[i][j] != 0 && rooms[i][j] != -1) {
            rooms[i][j] = Math.min(rooms[i][j], distance);
        }
        if (i < rooms.length - 1 && rooms[i + 1][j] != 0 && rooms[i + 1][j] != -1 && path[i + 1][j] != 1) {

            backtrack(rooms, i + 1, j, distance + 1, copy(path));
        }
        if (i > 0 && rooms[i - 1][j] != 0 && rooms[i - 1][j] != -1 && path[i - 1][j] != 1) {
            backtrack(rooms, i - 1, j, distance + 1, copy(path));
        }
        if (j < rooms[0].length - 1 && rooms[i][j + 1] != 0 && rooms[i][j + 1] != -1 && path[i][j + 1] != 1) {
            backtrack(rooms, i, j + 1, distance + 1, copy(path));
        }
        if (j > 0 && rooms[i][j - 1] != 0 && rooms[i][j - 1] != -1 && path[i][j - 1] != 1) {
            backtrack(rooms, i, j - 1, distance + 1, copy(path));
        }
    }
    public int[][] copy(int[][] input){
        int[][] res = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                res[i][j] = input[i][j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] res = new int[][]{{1,1},{2,1}};
        int[][] res1 = Arrays.copyOf(res,res.length);
        res1[1][1]=10;
        System.out.println(res1[1][1]);
        System.out.println(res[1][1]);
    }
}
