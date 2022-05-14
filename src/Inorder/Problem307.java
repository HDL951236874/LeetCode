package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem307 {
    class NumArray {
        int[] nums;
        Map<Integer, Integer> map = new HashMap<>();

        public NumArray(int[] nums) {
            this.nums = nums;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                map.put(i, sum);
            }
        }

        public void update(int index, int val) {
            for (int i: this.map.keySet()) {
                if(i<=index){
                    map.put(i,map.get(i)+val-this.nums[index]);
                }
            }
            this.nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return map.get(right) - map.get(left) + this.nums[left];
        }
    }
}
