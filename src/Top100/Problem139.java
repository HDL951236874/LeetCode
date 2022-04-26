package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, wordDict);
    }

    public boolean helper(String s, int index, List<String> wordDict) {
        boolean flag1 = false;
        for (int i = index; i < s.length(); i++) {
            String sub_string = s.substring(index, i + 1);
            if (wordDict.contains(sub_string)) {
                if (i + 1 < s.length()) {
                    boolean flag2 =  helper(s, i + 1, wordDict);
                    if(flag2 || flag1) return true;
                } else {
                    return true;
                }
            }
        }
        return flag1;
    }

    public static void main(String[] args) {
        Problem139 p = new Problem139();
        List<String> temp = new ArrayList<>();
        temp.add("aaa");
        temp.add("aaaa");
        System.out.println(p.wordBreak("aaaaaaa", temp));
    }
}
