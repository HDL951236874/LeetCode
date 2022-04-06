package ArrayList;

public class Problem74 {
    // you can also use binary search directly
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]) return false;
        for(int i =0;i<matrix.length-1;i++){
            if(matrix[i][0] == target || matrix[i+1][0] == target) return true;
            else if(matrix[i][0]<target && matrix[i+1][0]>target){
                if (binary_search(matrix, target, i)) return true;
            }
        }
        if(target==matrix[matrix.length-1][0]) return true;
        else {
            if(binary_search(matrix,target,matrix.length-1)) return true;
        }
        return false;
    }
    public boolean binary_search(int[][] matrix,int target, int line_index){
        int l = 0, r = matrix[0].length-1;
        while (l<=r){
            int m = (l+r)/2;
            if(matrix[line_index][m]>target){
                r = m-1;
            }else if(matrix[line_index][m]<target){
                l = m+1;
            }
            if(matrix[line_index][m] == target){
                return true;
            }
        }
        return false;
    }
}
