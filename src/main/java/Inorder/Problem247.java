package Inorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem247 {
    int num_limit = 0;

    public List<String> findStrobogrammatic(int n) {

        this.num_limit = n / 2;
        Set<String> set = new HashSet<>();
        backtrack(set, "");
        List<String> list = new ArrayList<>(set);
        List<String> final_res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer stringBuffer = reconstruct(list.get(i));
            if (n % 2 != 0) {
                final_res.add(new StringBuffer(stringBuffer).insert(n / 2, '1').toString());
                final_res.add(new StringBuffer(stringBuffer).insert(n / 2, '8').toString());
                final_res.add(new StringBuffer(stringBuffer).insert(n / 2, '0').toString());
            } else {
                final_res.add(stringBuffer.toString());
            }
        }
        return final_res;
    }

    public void backtrack(Set<String> res, String now) {
        if (now.length() == this.num_limit) {
            res.add(now);
            return;
        }
        String temp1 = now + '1';
        backtrack(res, temp1);
        String temp2 = now + '6';
        backtrack(res, temp2);

        String temp3 = now + '8';
        backtrack(res, temp3);

        String temp4 = now + '9';
        backtrack(res, temp4);
        if (now.length() > 0) {
            String temp5 = now + '0';
            backtrack(res, temp5);
        }

    }

    public StringBuffer reconstruct(String num) {
        String append = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '6') {
                append += '9';
                continue;
            }
            if (num.charAt(i) == '9') {
                append += '6';
                continue;
            }
            append += num.charAt(i);
        }
        return new StringBuffer(num + append);
    }
}
