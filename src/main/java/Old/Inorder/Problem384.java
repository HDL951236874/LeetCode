package Inorder;

import java.util.*;

public class Problem384 {
    class Solution {
        int[] num;

        public Solution(int[] nums) {
            this.num = nums;
        }

        public int[] reset() {
            return this.num;
        }

        public int[] shuffle() {

            List<Integer> temp = new ArrayList<>(this.num.length);
            for (int i = 0; i < num.length; i++) {
                temp.add(this.num[i]);
            }
            Collections.shuffle(temp);
            int[] res = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                res[i] = temp.get(i);
            }
            return res;
        }
    }

}
