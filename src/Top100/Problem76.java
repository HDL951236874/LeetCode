package Top100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem76 {
    //this question is not very reasonable for the intvalue
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        List<Pair<Character, Integer>> filter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.indexOf(s.charAt(i)) != -1) {
                filter.add(new Pair<>(s.charAt(i), i));
            }
        }
        Map<Character, Integer> t_map = map_generator(t);
        Map<Character, Integer> s_map = new HashMap<>();
//        s_map.put(s.charAt(0), 1);
        int l = 0;
        int r = 0;
        int success = 0;
        int min = Integer.MAX_VALUE;
        int[] min_index = new int[]{-1,-1};
        int required = t_map.size();
        while (r < filter.size()) {
            char nowr = filter.get(r).getKey();
            int temp = s_map.getOrDefault(nowr, 0);
            s_map.put(nowr, temp + 1);
            if (t_map.get(nowr).intValue() == s_map.get(nowr).intValue()) {
                success++;
            }
            while (success == required && l <= r) {
                int length = filter.get(r).getValue() - filter.get(l).getValue() + 1;
                if (length < min) {
                    min = length;
                    min_index[0] = filter.get(l).getValue();
                    min_index[1] = filter.get(r).getValue();
                }
                char nowl = filter.get(l).getKey();
                s_map.put(nowl, s_map.get(nowl) - 1);
                if (s_map.get(nowl).intValue() < t_map.get(nowl).intValue()) {
                    success--;
                }
                l++;
            }
            r++;
        }
        if(min ==Integer.MAX_VALUE){
            return "";
        }else {
            return s.substring(min_index[0], min_index[1]+1);
        }
    }

    public Map<Character, Integer> map_generator(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (res.containsKey(str.charAt(i))) {
                res.put(str.charAt(i), res.get(str.charAt(i)) + 1);
            } else {
                res.put(str.charAt(i), 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem76 p = new Problem76();
        System.out.println(p.minWindow("ADOBECODEBANC", "ABC"));
    }
}
