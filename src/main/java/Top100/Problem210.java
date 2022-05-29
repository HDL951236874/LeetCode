package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], temp);
            }
        }
        boolean[] finished = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> path = new ArrayList<>();
            if(helper(map,finished,checked,path,i)) return new int[]{};
            res.addAll(path);
        }
        int[] final_res = new int[numCourses];
        for (int i = 0; i < res.size(); i++) {
            final_res[i] = res.get(i);
        }
        return final_res;
    }

    public boolean helper(Map<Integer, List<Integer>> map, boolean[] finished, boolean[] checked, List<Integer> path, int num) {
        if (checked[num]) return false;
        if (!map.containsKey(num)) {
            path.add(num);
            checked[num] = true;
            return false;
        }
        finished[num] = true;
        List<Integer> prerequisite_list = map.get(num);
        boolean flag = false;
        for (int i = 0; i < prerequisite_list.size(); i++) {
            if (finished[prerequisite_list.get(i)]) return true;
//            if (!path.contains(prerequisite_list.get(i)))
//                path.add(prerequisite_list.get(i));
            flag = flag || helper(map, finished, checked, path, prerequisite_list.get(i));
        }
        finished[num] = false;
        checked[num] = true;
        if(!flag&&!path.contains(num)) path.add(num);
        return flag;
    }

    public static void main(String[] args) {
        Problem210 p = new Problem210();
        System.out.println(p.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }
}
