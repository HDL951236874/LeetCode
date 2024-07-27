package Inorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map_ = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            int d_v_ = map_.getOrDefault(p.charAt(i), 0);
            map_.put(p.charAt(i), d_v_ + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            if (map_.containsKey(s.charAt(i))) {
                int d_v = map.getOrDefault(s.charAt(i), 0);
                map.put(s.charAt(i), d_v + 1);
            }
        }
        int len = p.length();
        List<Integer> res = new ArrayList<>();
        if (map.equals(map_)) res.add(0);
        for (int i = len; i < s.length(); i++) {
            if (map_.containsKey(s.charAt(i))) {
                int temp = map.getOrDefault(s.charAt(i),0);
                map.put(s.charAt(i), temp+1);
            }
            if (map_.containsKey(s.charAt(i - len))) {
                map.put(s.charAt(i - len), map.get(s.charAt(i - len)) - 1);
            }
            if (map.equals(map_)) res.add(i - len + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        Problem438 problem438 = new Problem438();
        System.out.println(problem438.findAnagrams("bpaa", "aa"));
    }
}
