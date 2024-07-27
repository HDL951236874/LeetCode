package Old.Contest;

import java.util.*;

public class contest2285 {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            if (!temp.containsKey(roads[i][0])) {
                temp.put(roads[i][0], 1);
            } else {
                temp.put(roads[i][0], temp.get(roads[i][0]) + 1);
            }
            if (!temp.containsKey(roads[i][1])) {
                temp.put(roads[i][1], 1);
            } else {
                temp.put(roads[i][1], temp.get(roads[i][1]) + 1);
            }
        }
        List<Integer> l = new ArrayList<>();
        for (Integer num : temp.keySet()) {
            l.add(temp.get(num));
        }
        Collections.sort(l,Collections.reverseOrder());
        int p = n;
        long res = 0;
        for (int i = 0; i < l.size(); i++) {
            res += l.get(i) * p;
            p--;
        }
        return res;
    }

    public static void main(String[] args) {
        contest2285 contest2285 = new contest2285();
        contest2285.maximumImportance(5, new int[][]{{0, 3}, {2, 4}, {1, 3}});
    }
}
