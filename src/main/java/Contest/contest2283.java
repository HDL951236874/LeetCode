package Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contest2283 {
    public boolean digitCount(String num) {
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < num.length(); i++) {
            int now = Character.getNumericValue(num.charAt(i));
            temp.add(now);
            if (!map.containsKey(now))
                return false;
            else
                map.put(now, map.get(now) + 1);
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) != map.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        contest2283 contest2283 = new contest2283();
        contest2283.digitCount("030");
    }
}
