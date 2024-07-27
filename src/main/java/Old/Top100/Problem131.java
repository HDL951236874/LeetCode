package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> now = new ArrayList<>();
        helper(s,res,now,0);
        return res;
    }

    public void helper(String s, List<List<String>> res, List<String> now, int now_index) {
        if(now_index >= s.length()){
            res.add(now);
            return;
        }
        for (int i = now_index; i < s.length(); i++) {
            String sub_stirng = s.substring(now_index, i + 1);
            if (check(sub_stirng)) {
                List<String> temp = new ArrayList<>(now);
                temp.add(sub_stirng);
                helper(s,res,temp,i+1);
            }
        }
    }

    public boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
