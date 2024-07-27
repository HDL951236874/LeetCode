package Old.ArrayList;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem45 {
    //greedy is the best
    int minCount = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if(nums.length == 0)return 0;
        int i = 0;
        int jump = 1;
        while (nums[i] + i < nums.length - 1) {
            int farther = 0;
            int next = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (j + nums[i+j] > farther) {
                    farther = j + nums[i+j];
                    next = j;
                }
            }
            i += next;
            jump++;
        }
        return jump;
    }


    public static void main(String[] args) {
        Problem45 p = new Problem45();
        int minCount = Integer.MAX_VALUE;
//        p.backTrack(new int[]{2, 3, 1, 1, 4}, 4, 0);
        System.out.println(p.jump(new int[]{1,2,1,1,1}));
    }
}
