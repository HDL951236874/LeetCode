import org.omg.CORBA.WStringSeqHelper;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int maxl = 0;
        for(int i=0;i<s.length();i++){
            int l =0;
            Map<Character,Integer> stringMap = new HashMap<Character,Integer>();
            for(int j=i;j<s.length();j++){
                if(stringMap.containsKey(s.charAt(j))){
                    break;
                }else {
                    l++;
                    stringMap.put(s.charAt(j),null);
                }
            }
            if(l>maxl){
                maxl = l;
            }
        }
        return maxl;
    }
    public int SliderWindowSolution(String s){
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;
        int res = 0;
        while (right<s.length()){
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index> left &&index<right){
                left = index+1;
            }
            chars[r] = right;
            res = Math.max(res, right-left+1);
        }
        return res;
    }


    public static void main(String[] args) {
        Problem3 p = new Problem3();
        System.out.println(p.SliderWindowSolution("pwwkew"));
    }
}
