package Old.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contest6087 {

    public int rearrangeCharacters(String s, String target) {

        Map<Character, Integer> target_map = new HashMap<>();
        Map<Character, Integer> s_map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            int d_v = target_map.getOrDefault(target.charAt(i), 0);
            target_map.put(target.charAt(i), d_v + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (target_map.containsKey(s.charAt(i))) {
                int d_v = s_map.getOrDefault(s.charAt(i), 0);
                s_map.put(s.charAt(i), d_v + 1);
            }
        }
        if(target_map.size()!=s_map.size()) return 0;
        int res = Integer.MAX_VALUE;
        for (Character character:s_map.keySet()){
            res = Math.min(s_map.get(character)/target_map.get(character),res);
        }
        return res;
    }

    public static void main(String[] args) {
        contest6087 contest6087 = new contest6087();
        contest6087.rearrangeCharacters("rav", "vr");
    }
}
