package ArrayList;

public class Problem63 {
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        // the time complexity of this method is to big
        if (obstacleGrid[0][0] == 1) return 0;
        return backtrack(obstacleGrid, new int[]{0, 0});
    }

    public int backtrack(int[][] obstacleGrid, int[] pos) {
        if (pos[0] == obstacleGrid.length - 1 && pos[1] == obstacleGrid[0].length - 1 && obstacleGrid[pos[0]][pos[1]] != 1) {
            return 1;
        }
        int row = pos[0];
        int col = pos[1];
        int res1 = 0, res2 = 0;
        if (row < obstacleGrid.length - 1 && obstacleGrid[pos[0] + 1][pos[1]] != 1) {
            res1 = backtrack(obstacleGrid, new int[]{pos[0] + 1, pos[1]});
        }
        if (col < obstacleGrid[0].length - 1 && obstacleGrid[pos[0]][pos[1] + 1] != 1) {
            res2 = backtrack(obstacleGrid, new int[]{pos[0], pos[1] + 1});
        }
        return res1 + res2;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int num = Math.min(obstacleGrid.length,obstacleGrid[0].length);
        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0;i<num;i++){
            for(int r = i;r<obstacleGrid[0].length;r++){
                if(obstacleGrid[i][r] != 1){
                    map[i][r] = calculate(map,i,r);
                }else {
                    map[i][r] = 0;
                }
            }
            for(int c =i+1;c<obstacleGrid.length;c++){
                if(obstacleGrid[c][i] != 1){
                    map[c][i] = calculate(map,c,i);
                }else {
                    map[c][i] = 0;
                }
            }
        }
        return map[map.length-1][map[0].length-1];
    }
    public int calculate(int[][] map, int i, int j){
        if(i == 0&&j==0){
            return 1;
        }else if(i == 0&&j!=0){
            return map[i][j-1];
        }else if(i!=0 && j==0){
            return map[i-1][j];
        }else {
            return map[i][j-1]+map[i-1][j];
        }
    }

    public static void main(String[] args) {
        Problem63 p = new Problem63();
        int[][] inp = new int[3][3];
        inp[0] = new int[]{0,0,0};
        inp[1] = new int[]{0,1,0};
        inp[2] = new int[]{0,0,0};
        p.uniquePathsWithObstacles(inp);
    }
}