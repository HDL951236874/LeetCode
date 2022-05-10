package Inorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem248 {
    int num_limit = 0;

    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        for (int n = low.length(); n <= high.length(); n++) {
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
            for (int i = 0; i < final_res.size(); i++) {
                boolean b1 = false;
                boolean b2 = false;
                if(final_res.get(i).length()<low.length()) continue;
                if(final_res.get(i).length()>high.length()) continue;
                if(final_res.get(i).length()>low.length()) b1 = true;
                if(final_res.get(i).length()<high.length()) b2 = true;
                if(final_res.get(i).length()==low.length()) b1 = final_res.get(i).compareTo(low)>=0;
                if(final_res.get(i).length()==high.length()) b2 = final_res.get(i).compareTo(high)<=0;
                if(b1&&b2 ) res++;
            }
        }
        return res;
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

    public static void main(String[] args) {
        Problem248 problem248 = new Problem248();
        System.out.println("69".compareTo("100"));
        System.out.println(problem248.strobogrammaticInRange("50","100"));
    }
}

