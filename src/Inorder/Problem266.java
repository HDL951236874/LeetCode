package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        int odd_number = 0;
        for (Character chars: map.keySet()){
            if(map.get(chars)%2==1) odd_number++;
            if(odd_number>1) return false;
        }
        return true;
    }
}
