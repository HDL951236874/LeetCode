package ArrayList;

import java.net.Inet4Address;
import java.util.*;

// this is a very classic problem
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> res2 = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {

        }
        return res2;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int l = i + 1;
                int r = nums.length - 1;
                int target = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                        while (l < r && nums[l - 1] == nums[l]) {
                            l++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> nosort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicate.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int wanted = 0 - nums[i] - nums[j];
                    if (map.containsKey(wanted) && map.get(wanted) == i) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], wanted);
                        Collections.sort(temp);
                        res.add(temp);
                    }
                    map.put(nums[j], i);

                }
            }
        }
        return new ArrayList(res);

    }

    public static void main(String[] args) {
        Problem15 p = new Problem15();
        System.out.println(p.threeSum(new int[]{1, 2, -1, -3}));
    }
}
