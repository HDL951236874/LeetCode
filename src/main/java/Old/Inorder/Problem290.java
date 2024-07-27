package Inorder;

import java.util.*;

public class Problem290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> finished = new HashSet<>();
        List<String> temp = new ArrayList<>(Arrays.asList(s.split(" ")));
        if(temp.size()!=pattern.length()) return false;
        for (int i = 0; i < temp.size(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if(finished.contains(temp.get(i))) return false;
                map.put(pattern.charAt(i),temp.get(i));
                finished.add(temp.get(i));
            }else {
                if(!temp.get(i).equals(map.get(pattern.charAt(i)))) return false;
            }
        }
        return true;
    }

}
