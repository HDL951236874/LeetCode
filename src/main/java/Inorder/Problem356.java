package Inorder;

import javafx.util.Pair;

import java.util.*;

public class Problem356 {
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (!map.containsKey(points[i][1])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(points[i][0]);
                map.put(points[i][1], temp);
            } else {
                List<Integer> temp = map.get(points[i][1]);
                temp.add(points[i][0]);
                map.put(points[i][1], temp);
            }
        }
        for (Integer num:map.keySet()) {
            if(exam(map.get(num))[0] == Integer.MAX_VALUE) return false;
        }
        return true;
    }

    public int[] exam(List<Integer> list) {
        //according to the equation
        // sum/len = point1 + point2/2 -> sum*2 = poiny12*len

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        int len = list.size();

        List<Integer> temp = new ArrayList<>();
        list.forEach(mem -> temp.add(mem * len));
        for (int i = 0; i < temp.size(); i++) {
            if (!temp.contains(sum * 2 - temp.get(i))) return new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        }
        return new int[]{sum,len};
    }
}
