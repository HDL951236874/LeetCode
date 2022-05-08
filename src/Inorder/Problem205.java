package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        else {
            Map<Character, String> map1 = new HashMap<>();
            Map<Character, String> map2 = new HashMap<>();
            int p = 0;
            int c1 = 0;
            int c2 = 0;
            String temp1 = "";
            String temp2 = "";
            while (p < s.length()) {
                boolean b1 = map1.containsKey(s.charAt(p));
                boolean b2 = map2.containsKey(t.charAt(p));
                if (b1 != b2) return false;
                if (b1 == true) {
                    temp1 += map1.get(s.charAt(p));
                    temp2 += map2.get(t.charAt(p));
                    p++;
                    continue;
                } else {
                    temp1 += String.valueOf(c1);
                    temp2 += String.valueOf(c2);
                    map1.put(s.charAt(p), String.valueOf(c1));
                    map2.put(t.charAt(p), String.valueOf(c2));
                    c1++;c2++;
                    p++;
                }
            }
            if (temp1.equals(temp2)){
                return true;
            }
        }
        return false;
    }
}
