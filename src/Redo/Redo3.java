package Redo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Redo3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int r = 0;
        int max = 1;
        List<Character> list = new ArrayList<>();
        while (r < s.length()) {
            if (list.contains(s.charAt(r))) {
                max = Math.max(max, list.size());
                int index = list.indexOf(s.charAt(r));
                list = list.subList(index + 1, list.size());
            }
            list.add(s.charAt(r));
            r++;
        }
        return Math.max(list.size(), max);
    }

    public static void main(String[] args) {
        Redo3 r = new Redo3();
        System.out.println(r.lengthOfLongestSubstring("aab"));
    }
}
