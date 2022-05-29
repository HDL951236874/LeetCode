package Inorder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Problem159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()<1) return s.length();
        int l = 0;
        int r = 0;
        int max = 1;
        int last = 0;
        List<Character> queue = new LinkedList<>();
        queue.add(s.charAt(l));
        while (r < s.length()) {
            if (!queue.contains(s.charAt(r))) {
                if (queue.size() == 2) {
                    queue = new LinkedList<>();
                    queue.add(s.charAt(r-1));
                    queue.add(s.charAt(r));
                    max = Math.max(r - l, max);
                    l = last;
                } else {
                    queue.add(s.charAt(r));
                }
            }
            if(r>=1&&s.charAt(r)!=s.charAt(r-1)){
                last = r;
            }
            r++;
        }
        return Math.max(r-l,max);
    }

    public static void main(String[] args) {
        Problem159 problem159 = new Problem159();
        System.out.println(problem159.lengthOfLongestSubstringTwoDistinct("ababcbcbaaabbdef"));
    }
}
