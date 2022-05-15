package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>() {{
            put('a', false);
            put('b', false);
            put('c', false);
            put('d', false);
            put('e', false);
            put('f', false);
            put('g', false);
            put('h', false);
            put('i', false);
            put('j', false);
            put('k', false);
            put('l', false);
            put('m', false);
            put('n', false);
            put('o', false);
            put('p', false);
            put('q', false);
            put('r', false);
            put('s', false);
            put('t', false);
            put('u', false);
            put('v', false);
            put('w', false);
            put('x', false);
            put('y', false);
            put('z', false);
        }};
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.get(s.charAt(i))) {
                map.put(s.charAt(i), true);
                number++;
            }
            if(number == 26) break;
        }
        if(number == 26) return "abcdefghijklmnopqrstuvwxyz";
        else {
            String res = "";
            for (Character character :map.keySet()) {
                if(map.get(character) == true){
                    res+= character;
                }
            }
            return res;
        }
    }
}
