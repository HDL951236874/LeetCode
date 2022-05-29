package ArrayList;

public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int layer = Math.min(Math.min(i+1,n-i),Math.min(j+1,n-j));
                int begin_number = n*n- (n - 2* (layer -1))*(n - 2* (layer -1)) + 1;

                if(i<=j){
                    res[i][j] = begin_number + (i - layer + 1) + (j - layer +1);
                }else if(i>j){
                    res[i][j] = begin_number + (n - (layer -1)*2) *2 -2 + (n - (layer-1) -1 -j) + (n - (layer -1) - 1 - i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem59 p = new Problem59();
        int[][] res = p.generateMatrix(4);
        System.out.println(2^2);
    }
}
