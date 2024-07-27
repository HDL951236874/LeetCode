package Old.Contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Problem6068 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int right_most = Integer.MIN_VALUE;
        int left_most = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Arrays.sort(tiles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < tiles.length; i++) {
            right_most = Math.max(right_most, tiles[i][1]);
            left_most = Math.min(left_most, tiles[i][0]);
            int sum_now = tiles[i][1] - tiles[i][0] + 1;
            if (sum_now >= carpetLen) return carpetLen;
            max = Math.max(max, sum_now);
        }
        int[] contain = new int[right_most - left_most + 1];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i][0] -= left_most;
            tiles[i][1] -= left_most;
            for (int j = tiles[i][0]; j <= tiles[i][1]; j++) {
                contain[j] = 1;
            }
        }
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i][0] + carpetLen >= tiles[i + 1][0]) {
                max = Math.max(max, Arrays.stream(Arrays.copyOfRange(contain, tiles[i][0], Math.min(tiles[i][0] + carpetLen, contain.length))).sum());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(1&1);
    }
}
