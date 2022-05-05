package Inorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> container = new ArrayList<>();
        int n = triangle.size();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            if (i == 0) {
                container = triangle.get(0);
                continue;
            }
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    temp.add(container.get(0) + triangle.get(i).get(0));
                    continue;
                }
                if (j == i) {
                    temp.add(container.get(container.size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
                    continue;
                }
                if (j > 0 && j < i) {
                    int candidate = Math.min(container.get(j - 1), container.get(j));
                    temp.add(candidate + triangle.get(i).get(j));
                }
            }
            container = temp;
        }
        return Collections.max(container);
    }

    public static void main(String[] args) {
        Problem120 p = new Problem120();
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        tri.add(l1);
        tri.add(l2);
        tri.add(l3);
        System.out.println(p.minimumTotal(tri));
    }
}
