package Top100;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int mid = 0; mid < matrix.length; mid++) {


            int ll = 0;
            int rr = matrix[mid].length - 1;
            int midd = 0;
            while (ll <= rr) {
                midd = ll + (rr - ll) / 2;
                if (matrix[mid][midd] == target) return true;
                if (matrix[mid][midd] > target) {
                    rr = midd - 1;
                }
                if (matrix[mid][midd] < target) {
                    ll = midd + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem240 p = new Problem240();
        System.out.println(p.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }
}
