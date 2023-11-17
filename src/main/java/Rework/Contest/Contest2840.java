package Rework.Contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest2840 {
    public boolean checkStrings(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i< s1.length();i++){
            char c = s1.charAt(i);
            char c_ = s2.charAt(i);
            if(i%2==0) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
                map1.put(c_, map1.getOrDefault(c_, 0) - 1);
            }
            else {
                map2.put(c, map2.getOrDefault(c,0)+1);
                map2.put(c_, map2.getOrDefault(c_, 0) - 1);
            }
        }
        for(Map.Entry<Character,Integer> e: map1.entrySet()){
            if(e.getValue()!=0) return false;
        }
        for(Map.Entry<Character,Integer> e: map2.entrySet()){
            if(e.getValue()!=0) return false;
        }
        return true;
    }
}
