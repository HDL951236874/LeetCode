package Old.ArrayList;

public class Problem85 {
    //stack can be used to solve this question
    public int maximalRectangle(char[][] matrix) {
        int max_value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max_value = Math.max(find_exam(matrix,i,j),max_value);
                }
            }
        }
        return max_value;
    }

    public int find_exam(char[][] matrix, int i, int j) {
        int right_boundary = 0;
        int max_value = 0;
        for (int k = j; k < matrix[0].length; k++) {
            if (matrix[i][k] != '1') {
                right_boundary = k - 1;
                break;
            }else if(k == matrix[0].length-1){
                right_boundary = k;
                break;
            }
        }

        for (int k = i; k < matrix.length; k++) {
            for (int l = j; l <= right_boundary; l++) {
                if(matrix[k][l] != '1'){
                    max_value = Math.max((l-j)*(k-i+1),max_value);
                    right_boundary = l-1;
                    continue;
                }
                if (l == right_boundary && matrix[k][l] == '1') {
                    max_value = Math.max((right_boundary-j+1)*(k-i+1),max_value);
                }
            }
        }
        return max_value;
    }

    public static void main(String[] args) {
        Problem85 p = new Problem85();
//        char[][] in = new char[][]{{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'1','1','1','1','1','0','0','0'}};
        char[][] in = new char[][]{{'0','1'},{'1','0'}};
        p.maximalRectangle(in);
    }
}

