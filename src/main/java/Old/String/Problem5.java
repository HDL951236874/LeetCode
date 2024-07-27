package String;

import java.util.Stack;

public class Problem5 {
    // today i have to finish 5,
    public String longestPalindrome(String s) {
        if(s.length() == 1)return s;
        String max_subString = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && j-i+1>max_subString.length()) {
                    if (check(s, i, j)) {
                        max_subString = s.substring(i,j+1);
                    }
                }
            }
        }
        return max_subString;
    }

    public boolean check(String s, int i, int j) {
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        Problem5 p = new Problem5();
        p.longestPalindrome(s);
        System.out.println(s.substring(0,2));
    }
}
