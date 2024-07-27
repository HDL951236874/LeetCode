package Old.ArrayList;

import java.util.*;

public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> dup = new HashSet<>();
        Arrays.sort(nums);
        /*
         * [-2,-1,-1,1,1,2,2]
         * */
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j - 1] != nums[j]) {
                        int l = j + 1;
                        int r = nums.length - 1;
                        while (l < r) {
                            int sum = nums[i] + nums[j] + nums[l] + nums[r];
                            if (sum == target) {
                                List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]);
                                Collections.sort(temp);
                                res.add(temp);
                                while (nums[l - 1] == nums[l] && l < r) {
                                    l++;
                                }
                            } else if (sum < target) {
                                l++;
                            } else {
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem18 P = new Problem18();
        System.out.println(P.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }
}
