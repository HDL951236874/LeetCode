package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                List<Integer> temp = map.get(prerequisites[i][0]);
                temp.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], temp);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) continue;
            List<Integer> permit = new ArrayList<>();
            if(!helper(map,permit,i)) return false;
            for (int j = 0; j < permit.size(); j++) {
                map.remove(permit.get(j));
            }
        }
        return true;
    }

    public boolean helper(Map<Integer, List<Integer>> map, List<Integer> permit, int num) {
        if(!map.containsKey(num)) return true;
        permit.add(num);
        boolean flag = true;
        List<Integer> temp = map.get(num);
        if(temp.size()>=2 && temp.contains(map.get(temp.get(1)).get(0))){
            int temp_ = temp.get(0);
            temp.set(0,temp.get(1));
            temp.set(1,temp_);
        }
        for (int i = 0; i < temp.size(); i++) {
            if (permit.contains(temp.get(i))) return false;
            flag = flag&& helper(map,permit,temp.get(i));
        }
        return flag;
    }

    public static void main(String[] args) {
        Problem207 p = new Problem207();
        System.out.println(p.canFinish(7,
                new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
    }
}
