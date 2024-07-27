package Inorder;

public class Problem174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] health_mat = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                if(i == 0&& j== 0){
                    health_mat[i][j] = -1*dungeon[i][j];
                    continue;
                }
                int up = i > 0 ? health_mat[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? health_mat[i][j - 1] : Integer.MAX_VALUE;
                health_mat[i][j] = Math.min(up, left) + dungeon[i][j] * -1;
            }
        }
        return health_mat[health_mat.length-1][health_mat[0].length-1];
    }

    public static void main(String[] args) {
        Problem174 problem174 = new Problem174();
        System.out.println(problem174.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
