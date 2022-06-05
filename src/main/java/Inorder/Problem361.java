package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem361 {
    public int maxKilledEnemies(char[][] grid) {
        Map<Integer, Map<Integer, Integer>> map_row = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> map_col = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            int num = 0;
            int pos = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    num++;
                }
                if (grid[i][j] == 'W' ) {
                    for (int k = pos; k <= j - 1; k++) {
                        map.put(k, num);
                    }
                    num = 0;
                    pos = j + 1;
                }
                if(j == grid[i].length - 1){
                    for (int k = pos; k <= j; k++) {
                        map.put(k, num);
                    }
                }
            }
            map_row.put(i, map);
        }
        for (int i = 0; i < grid[0].length; i++) {
            int num = 0;
            int pos = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 'E') {
                    num++;
                }
                if (grid[j][i] == 'W') {
                    for (int k = pos; k <= j - 1; k++) {
                        map.put(k, num);
                    }
                    num = 0;
                    pos = j + 1;
                }
                if (j == grid.length - 1){
                    for (int k = pos; k <= j; k++) {
                        map.put(k, num);
                    }
                }
            }
            map_col.put(i, map);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, map_row.get(i).get(j) + map_col.get(j).get(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem361 problem361 = new Problem361();
        problem361.maxKilledEnemies(new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}});
    }
}
