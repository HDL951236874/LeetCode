package Inorder;

import java.util.*;

public class Problem261 {
    List<Integer> temp = new ArrayList<>();
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0],new ArrayList<>(Arrays.asList(1)));
            }
        }
        return true;
    }
}
