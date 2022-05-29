package Top100;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams_(String[] strs) {
        // this complexity is too big
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> res = makeMapper(strs[i]);
            boolean new_key = true;
            for (Map mapper : map.keySet()) {
                if (res.equals(mapper)) {
                    new_key = false;
                    List<String> temp = map.get(mapper);
                    temp.add(strs[i]);
                    map.put(mapper, temp);
                }
            }
            if (new_key == true) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(res, temp);
            }
        }
        List<List<String>> final_res = new ArrayList<>();
        for (List<String> string_list : map.values()) {
            final_res.add(string_list);
        }
        return final_res;
    }

    public Map<Character, Integer> makeMapper(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (res.containsKey(str.charAt(i))) {
                res.put(str.charAt(i), res.get(str.charAt(i)) + 1);
            } else {
                res.put(str.charAt(i), 1);
            }
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // the method will use the count way
        Map<Character, Integer> map = new HashMap() {{
            put('a', 0);
            put('b', 1);
            put('c', 2);
            put('d', 3);
            put('e', 4);
            put('f', 5);
            put('g', 6);
            put('h', 7);
            put('i', 8);
            put('j', 9);
            put('k', 10);
            put('l', 11);
            put('m', 12);
            put('n', 13);
            put('o', 14);
            put('p', 15);
            put('q', 16);
            put('r', 17);
            put('s', 18);
            put('t', 19);
            put('u', 20);
            put('v', 21);
            put('w', 22);
            put('x', 23);
            put('y', 24);
            put('z', 25);
        }};
        Map<Integer[], List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Integer[] char_list = new Integer[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
            for (int j = 0; j < strs[i].length(); j++) {
                char_list[map.get(strs[i].charAt(j))] += 1;
            }
            boolean new_key = true;
            for (Integer[] int_list_ : res.keySet()) {
                if (Arrays.equals(int_list_,char_list)) {
                    List<String> temp = res.get(int_list_);
                    temp.add(strs[i]);
                    res.put(int_list_, temp);
                    new_key = false;
                }
            }
            if (new_key == true) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                res.put(char_list, temp);
            }
        }
        List<List<String>> final_res = new ArrayList<>();
        for (List<String> l : res.values()) {
            final_res.add(l);
        }
        return final_res;
    }

    public static void main(String[] args) {
        Problem49 p = new Problem49();
        List<List<String>> res = p.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
//        System.out.println();
        int[] x = new int[2];
        x[0] += 1;
    }
}
