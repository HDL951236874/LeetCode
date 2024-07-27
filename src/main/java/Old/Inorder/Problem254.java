package Inorder;

import org.w3c.dom.ls.LSInput;

import java.util.*;

public class Problem254 {
    Map<Integer, Set<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> getFactors(int n) {
        return new ArrayList<>(backtrack(n));
    }

    public Set<List<Integer>> backtrack(int n) {
        if(map.containsKey(n)) return map.get(n);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(i, n / i));
                Collections.sort(temp);
                set.add(temp);

                Set<List<Integer>> temp1 = backtrack(i);
                for (List<Integer> list : temp1) {
                    List<Integer> tmp1 = new ArrayList<>(list);
                    tmp1.add(n/i);
                    Collections.sort(tmp1);
                    set.add(tmp1);
                }
                Set<List<Integer>> temp2 = backtrack(n / i);
                for (List<Integer> list : temp2) {
                    List<Integer> tmp2 = new ArrayList<>(list);
                    tmp2.add(i);
                    Collections.sort(tmp2);
                    set.add(tmp2);
                }
            }
        }
        this.map.put(n,set);
        return set;
    }

    public static void main(String[] args) {
        Problem254 problem254 = new Problem254();
        problem254.getFactors(32);
    }
}
