package Old.Contest;

import java.lang.management.LockInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class contest5234 {
    public List<String> removeAnagrams(String[] words) {
        List<String> temp = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            temp.add(words[i]);
        }
        for (int i = 0; i < temp.size() - 1; i++) {
            if (compareA(temp.get(i), temp.get(i + 1))) {
                temp.remove(i + 1);
                i--;
            }
        }
        return temp;
    }

    public boolean compareA(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (!map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), 1);
            } else {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (!map.containsKey(b.charAt(i))) return false;
            else {
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) return false;
        }
        return true;
    }
}
