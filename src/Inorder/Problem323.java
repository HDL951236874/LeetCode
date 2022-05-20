package Inorder;

import javafx.geometry.HPos;
import org.omg.PortableServer.ImplicitActivationPolicy;

import javax.swing.event.ListDataEvent;
import java.util.*;

public class Problem323 {
    int res = 0;

    public int countComponents(int n, int[][] edges) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][1]);
                map.put(edges[i][0], set);
            } else {
                map.get(edges[i][0]).add(edges[i][1]);
            }
            if (!map.containsKey(edges[i][1])) {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][0]);
                map.put(edges[i][1], set);
            } else {
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        while (list.size() > 0) {
            List<Integer> now = new ArrayList(Arrays.asList(list.get(0)));
            backtrack(now, map, list.get(0));
            List<Integer> new_list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (!now.contains(list.get(i))) {
                    new_list.add(list.get(i));
                }
            }
            list = new_list;
            this.res++;
        }
        return this.res+n-map.size();
    }

    public void backtrack(List<Integer> now, Map<Integer, Set<Integer>> map, int cur) {
        Set<Integer> set = map.get(cur);
        for (Integer num : set) {
            if (now.contains(num)) continue;
            now.add(num);
            backtrack(now, map, num);
        }
    }

    public static void main(String[] args) {
        Problem323 problem323 = new Problem323();
        System.out.println(problem323.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}
