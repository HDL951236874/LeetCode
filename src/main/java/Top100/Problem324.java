package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem324 {
    public void wiggleSort(int[] nums) {
        if(nums.length == 1) return;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) temp.add(num);
        Collections.sort(temp);
        int mid = (int) Math.ceil((double) nums.length / 2);
        int temp_ = nums[0];
        temp.add(0,temp.get(mid-1));
        temp.add(mid-1,temp_);
        temp_ = nums[nums.length    - 1];
        temp.add(nums.length-1,temp.get(mid));
        temp.add(mid,temp_);
        for (int i = 0; i < mid; i++) {
            nums[i * 2] = (int) temp.get(i);
            if (mid + i < nums.length) {
                nums[2 * i + 1] = (int) temp.get(mid + i);
            }
        }
    }

    public static void main(String[] args) {
        Problem324 p = new Problem324();
        p.wiggleSort(new int[]{4,5,5,6});
        System.out.println(7 / 2);
    }
}
