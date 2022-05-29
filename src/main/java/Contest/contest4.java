package Contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class contest4 {
    public long appealSum(String s) {
        for (int i = 1; i <= s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                int default_value = map.getOrDefault(s.charAt(j), 0);
                map.put(s.charAt(j), default_value + 1);
            }

        }
        return 1;
    }

}
