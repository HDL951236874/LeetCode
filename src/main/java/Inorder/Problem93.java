package Inorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> now = new ArrayList<>();
        helper(s,res,now);
        List<String> final_res =new ArrayList<>();
        for (List<String> ls: res){
            final_res.add(String.join(".",ls));
        }
        return final_res;
    }

    public void helper(String s, List<List<String>> res, List<String> now) {
        if (now.size() == 3) {
            if(s.length() == 0)return;
            if(s.charAt(0)=='0'&&s.length()>1) return;
            if ((s.length() <= 2&&s.length()>0) || (s.length() == 3 && Integer.parseInt(s) <= 255)) {
                now.add(s);
                Collections.reverse(now);
                res.add(now);
            }
            return;
        }
        if(s.length()>=1){
            List<String> temp1 = new ArrayList<>();
            temp1.addAll(now);
            temp1.add(s.substring(s.length()-1,s.length()));
            helper(s.substring(0,s.length()-1),res,temp1);

        }
        if(s.length()>=2&&s.charAt(s.length()-2)!='0'){
            List<String> temp2 = new ArrayList<>();
            temp2.addAll(now);
            temp2.add(s.substring(s.length()-2,s.length()));
            helper(s.substring(0,s.length()-2),res,temp2);

        }
        if(s.length()>=3&&s.charAt(s.length()-3)!='0'&&Integer.parseInt(s.substring(s.length()-3,s.length()))<=255){
            List<String> temp3 = new ArrayList<>();
            temp3.addAll(now);
            temp3.add(s.substring(s.length()-3,s.length()));
            helper(s.substring(0,s.length()-3),res,temp3);
        }
    }

    public static void main(String[] args) {
        Problem93 p = new Problem93();
        System.out.println(p.restoreIpAddresses("25525511135"));
    }
}
