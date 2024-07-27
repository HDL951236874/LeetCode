package Inorder;

import java.util.Arrays;

public class Problem256 {
    public int minCost(int[][] costs) {
        int[] cost_acc = new int[3];
        Arrays.fill(cost_acc,0);
        for (int i = 0; i < costs.length; i++) {
            int[] temp = new int[3];
            temp[0] = costs[i][0]+ Math.min(cost_acc[1],cost_acc[2]);
            temp[1] = costs[i][1]+ Math.min(cost_acc[0],cost_acc[2]);
            temp[2] = costs[i][2]+ Math.min(cost_acc[0],cost_acc[1]);
            cost_acc = temp;
        }
        return Arrays.stream(cost_acc).min().getAsInt();
    }

    public static void main(String[] args) {
        Problem256 problem256 = new Problem256();
        System.out.println(problem256.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
