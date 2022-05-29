package Top100;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int deault_value1 = map.getOrDefault(intervals[i][0], 0);
            map.put(intervals[i][0], deault_value1 + 1);
            int deault_value2 = map.getOrDefault(intervals[i][1], 0);
            map.put(intervals[i][1], deault_value2 - 1);
        }
        Map sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//        return 1;
        int c = 0;
        int max = 1;
        for (Object num:sortedMap.keySet()) {
            c+= map.get(num);
            max = Math.max(max,c);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem253 p = new Problem253();
        System.out.println(p.minMeetingRooms(new int[][]{{0,30}, {5,10},{15,20}}));

    }
}
