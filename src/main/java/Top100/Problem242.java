package Top100;

import java.util.HashMap;
import java.util.Map;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) return false;
            else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0) {
                    map.remove(t.charAt(i));
                }
            }
        }
        if (map.size() == 0) return true;
        else return false;
    }
}
