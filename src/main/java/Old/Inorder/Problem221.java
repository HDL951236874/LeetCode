package Inorder;

import java.util.Map;

public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max,helper(matrix,i,j));
                }
            }
        }
        return (int)Math.pow(max,2);
    }

    public int helper(char[][] mat, int i, int j) {
        int limit = Math.min(mat.length - i, mat[0].length - j);
        for (int k = 2; k <= limit; k++) {
            for (int l = i; l < i + k - 1; l++) {
                if (mat[l][j + k - 1] != '1') return k - 1;
            }
            for (int l = j; l < j + k - 1; l++) {
                if (mat[i + k - 1][l] != '1') return k - 1;
            }
            if (mat[i + k - 1][j + k - 1] != '1') return k - 1;
        }
        return limit;
    }
}
