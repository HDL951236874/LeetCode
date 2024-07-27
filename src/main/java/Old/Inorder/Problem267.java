package Inorder;

import java.util.*;

public class Problem267 {
    Set<String> res = new HashSet<>();
    Set<Character> duplicate = new HashSet<>();

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        String odd = "";
        List<Character> temp = new ArrayList<>();
        for (Character chars : map.keySet()) {
            if (map.get(chars) % 2 == 1) {
                if (odd.length() == 0) {
                    odd = String.valueOf(chars);
                    map.put(chars, map.get(chars) - 1);
                } else return new ArrayList<>();
            }
            for (int i = 0; i < map.get(chars)/2; i++) {
                temp.add(chars);
            }
        }
        backtrack(temp, "");
        List<String> res_list = new ArrayList<>(this.res);
        for (int i = 0; i < res_list.size(); i++) {
            StringBuffer now = new StringBuffer(res_list.get(i));
            StringBuffer now_temp = new StringBuffer(now);
            now = now.append(now_temp.reverse());
            if (odd.length() != 0)
                now.insert(now.length()/2,odd);
            res_list.set(i, now.toString());
        }
        return res_list;
    }

    public void backtrack(List<Character> temp, String now) {
        if (temp.size() == 0) {
            this.res.add(now);
        }
        for (int i = 0; i < temp.size(); i++) {
            if (now.length() == 0) {
                if (this.duplicate.contains(temp.get(i)) && now.length() == 0) continue;
                else this.duplicate.add(temp.get(i));
            }
            List<Character> new_temp = new ArrayList<>(temp);
            new_temp.remove(i);
            backtrack(new_temp, now + temp.get(i));
        }
    }

    public static void main(String[] args) {
        Problem267 problem267 = new Problem267();
        problem267.generatePalindromes("a");
    }
}
