package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        while(rowEnd>=rowStart&&colEnd>=colStart){
            for(int i =colStart;i<=colEnd;i++){
                res.add(matrix[rowStart][i]);
            }
            for(int i = rowStart+1;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
            }
            if(rowEnd == rowStart||colEnd == colStart) break;
            for(int i = colEnd-1;i>=colStart;i--){
                res.add(matrix[rowEnd][i]);
            }
            for(int i = rowEnd-1;i>=rowStart+1;i--){
                res.add(matrix[i][colStart]);
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem54 p = new Problem54();
        int[][] in  = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = p.spiralOrder(in);
        System.out.println(1);
    }
}
