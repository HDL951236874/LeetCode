package Rework.Top100;

import ArrayList.Porblem39;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length()==1) return 1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        int b = 0;
        int e = 1;
        int res = 1;
        while(b<s.length()&&e<s.length()){
            char c = s.charAt(e);
            if(map.containsKey(c)){
                int x = map.get(c);
                if(x>=b){
                    res = Math.max(e-b, res);
                    b = x+1;
                }
            }
            map.put(c,e);
            e++;
        }
        return Math.max(e-b, res);
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("aab"));
    }
}
