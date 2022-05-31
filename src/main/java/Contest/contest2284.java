package Contest;

import java.util.*;

public class contest2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            if (!map.containsKey(senders[i])) {
                map.put(senders[i], messages[i].split(" ").length);
            } else {
                map.put(senders[i], map.get(senders[i]) + messages[i].split(" ").length);
            }
        }
        List<String> biggest = new ArrayList<>();
        int max = 0;
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                biggest = temp;
                max = map.get(str);
            }
            if (map.get(str) == max) {
                biggest.add(str);
            }
        }
        String max_string = biggest.get(0);
        for (int i = 1; i < biggest.size(); i++) {
            if(max_string.compareTo(biggest.get(i))<0){
                max_string = biggest.get(i);
            }
        }
        return max_string;
    }
}
