package ukg;

import java.util.Arrays;

public class Question18 {
    public String longestCommonPrefix(String[] strs) {

        int len = Arrays.stream(strs).map(String::length).min(Integer::compare).get();
        for(int i =0; i<len;i++){
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    StringBuilder sb = new StringBuilder(strs[0]);
                    return sb.substring(0, i);
                }
            }
        }
        return new StringBuilder(strs[0]).substring(0,len);
    }

    public static void main(String[] args) {
        Question18 q = new Question18();
        System.out.println(q.longestCommonPrefix(new String[]{"","a"}));
    }
    public String longestCommonPrefix1(String[] strs) {
        for(int i =0; i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c){
                    StringBuilder sb = new StringBuilder(strs[0]);
                    return sb.substring(0, i);
                }
            }
        }
        return strs[0];

    }

}
