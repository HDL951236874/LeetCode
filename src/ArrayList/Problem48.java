package ArrayList;

public class Problem48 {
    public void rotate(int[][] matrix) {
        int l = matrix.length-1;
        int colNum = (matrix.length+1)/2;
        int rowNum = (matrix.length)/2;
        for(int i = 0;i<colNum;i++){
            for(int j = 0;j<rowNum;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l-j][i];
                matrix[l-j][i] = matrix[l-i][l-j];
                matrix[l-i][l-j] = matrix[j][l-i];
                matrix[j][l-i] = temp;

            }
        }
    }
}
