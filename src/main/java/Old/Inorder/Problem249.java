package Inorder;

import java.util.*;

public class Problem249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j < strings[i].length(); j++) {
                int ans = strings[i].charAt(j) - strings[i].charAt(j - 1);
                temp.add(ans < 0 ? ans + 26 : ans);
            }
            if (!map.containsKey(temp)) {

                map.put(temp, new ArrayList<>(Arrays.asList(strings[i])));
            } else {
                List<String> temp_ = map.get(temp);
                temp_.add(strings[i]);
                map.put(temp, temp_);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> nums : map.keySet()) {
            res.add(map.get(nums));
        }
        return res;
    }

    public static void main(String[] args) {
        Problem249 problem249 = new Problem249();
        problem249.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"});
    }
}
