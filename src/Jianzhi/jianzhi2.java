package Jianzhi;

public class jianzhi2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0|| matrix[0].length == 0) return false;
        for (int i = 0; i <matrix.length ; i++) {
            if(matrix[i][0] == target) return true;
            if(matrix[i][0] > target) break;
            int[] list = matrix[i];
            int ll = 0;
            int rr = list.length - 1;
            while (ll <= rr) {
                int midd = ll + (rr - ll) / 2;
                if (list[midd] == target) return true;
                else if (list[midd] < target) {
                    ll = midd + 1;
                } else if (list[midd] > target) {
                    rr = midd - 1;
                }
            }
        }
        return false;
    }
}
