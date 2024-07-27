package Top100;

import Inorder.Problem361;

import java.util.*;

public class contest2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == operations[i][1]) continue;
            if (map.containsKey(operations[i][0])) {
                if (map.containsKey(operations[i][1])) {
                    List<Integer> temp = map.get(operations[i][1]);
                    temp.addAll(map.get(operations[i][0]));
                    map.put(operations[i][1], temp);
                } else {
                    map.put(operations[i][1], map.get(operations[i][0]));
                }
                map.remove(operations[i][0]);

            } else if (map.containsKey(operations[i][1])) {
                List<Integer> temp = map.get(operations[i][1]);
                temp.add(operations[i][0]);
                map.put(operations[i][1], temp);
            } else {
                map.put(operations[i][1], new ArrayList<>(Arrays.asList(operations[i][0])));
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer num : map.keySet()) {
            List<Integer> list = map.get(num);
            for (int i = 0; i < list.size(); i++) {
                map2.put(list.get(i), num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map2.containsKey(nums[i])) {
                nums[i] = map2.get(nums[i]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        contest2295 contest2295 = new contest2295();
//        contest2295.arrayChange(new int[]{1,2,4,6},new int[][]{{1,3},{4,7},{6,1}});
        contest2295.arrayChange(new int[]{1, 2}, new int[][]{{1, 3}, {2, 1}, {3, 2}});
    }
}
