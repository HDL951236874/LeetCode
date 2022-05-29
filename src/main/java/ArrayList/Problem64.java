package ArrayList;

public class Problem64 {
    public int minPathSum(int[][] grid) {

        // this is the length of the shorter side of the rect
        int num = Math.min(grid.length, grid[0].length);
        int[][] res = new int[grid.length][grid[0].length];
        for(int i = 0;i< num;i++){
            for(int col = i;col< grid[0].length;col++){
                res[i][col] = calculate(res,grid,i,col);
            }
            for(int row = i+1;row<grid.length;row++){
                res[row][i] = calculate(res,grid,row,i);
            }
        }
        return res[res.length-1][res[0].length-1];
    }
    public int calculate(int[][] res,int[][] grid, int row, int col){
        if(row == 0 && col ==0) return grid[0][0];
        else if(row ==0 && col != 0){
            return res[row][col-1]+grid[row][col];
        }else if(col == 0&& row!= 0){
            return res[row-1][col] + grid[row][col];
        }else {
            return grid[row][col] + Math.min(res[row][col-1], res[row-1][col]);
        }
    }
}
