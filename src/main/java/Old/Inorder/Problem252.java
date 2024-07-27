package Inorder;

import java.util.*;
import java.util.stream.Collectors;

public class Problem252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            if (map.containsKey(intervals[i][0])) {
                List<int[]> temp = map.get(intervals[i][0]);
                temp.add(intervals[i]);
                map.put(intervals[i][0], temp);
            } else {
                map.put(intervals[i][0], new ArrayList<>(Arrays.asList(intervals[i])));
            }
        }
        Map<Integer, List<int[]>> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<int[]> temp = new ArrayList<>();
        for (Integer num : sortedMap.keySet()) {
            for (int[] nums : sortedMap.get(num)) {
                temp.add(nums);
            }
        }
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i)[0] - temp.get(i - 1)[1] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem252 problem252 = new Problem252();
        problem252.canAttendMeetings(new int[][]{{15, 16}, {10, 15}, {16, 25}});
    }
}
