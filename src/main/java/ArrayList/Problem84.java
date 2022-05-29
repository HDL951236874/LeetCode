package ArrayList;

import java.util.Arrays;

public class Problem84 {
    //stack can be used to solve this question
    public int largestRectangleArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = backtrack(heights, l, r);
        return res;
    }

    public int backtrack(int[] height, int l, int r) {
        if (l == r) return height[l];
        if (r - l == 1) {
            if (Math.min(height[l], height[r]) == 0) {
                return Math.max(height[l], height[r]);
            } else {
                return 2 * Math.min(height[l], height[r]);
            }
        }
        int[] temp = Arrays.copyOfRange(height, l, r + 1);
        int min = Arrays.stream(temp).min().getAsInt();
        int[] tuple = new int[]{-1, -1};
        for (int i = l; i <= r; i++) {
            if (height[i] == min) {
                if (tuple[0] == -1) {
                    tuple[0] = i;
                    tuple[1] = i;
                } else {
                    tuple[1] = i;
                }
            }
        }
        int now = (r - l + 1) * min;
        int mid = 0;
        int left = 0;
        int right = 0;
        if(tuple[1]-tuple[0]>1){
            mid = backtrack(height,tuple[0]+1,tuple[1]-1);
        }
        if (l < tuple[0]) {
            left = backtrack(height, l, tuple[0] - 1);
        }
        if (r > tuple[1]) {
            right = backtrack(height, tuple[1] + 1, r);
        }
        return Arrays.stream(new int[]{now, left, right, mid}).max().getAsInt();
    }

    public static void main(String[] args) {
        Problem84 p = new Problem84();
        p.largestRectangleArea(new int[]{0, 0, 0});
    }
}
