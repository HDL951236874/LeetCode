package Redo;

public class Redo5 {

    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        String max_stirng = "";
        while (r < s.length()) {

            String temp1 = find(s, l, r);
            if (max < temp1.length()) {
                max_stirng = temp1;
                max = temp1.length();
            }

            r++;
            if (r < s.length() && s.charAt(r) == s.charAt(l)) {
                String temp2 = find(s, l, r);
                if (max<temp2.length()){
                    max_stirng = temp2;
                    max = temp2.length();
                }
            }
            l++;
        }
        return max_stirng;
    }

    public String find(String s, int l, int r) {
        if (l == r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
        } else {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        Redo5 redo5 = new Redo5();
        System.out.println(redo5.longestPalindrome("babad"));
    }
}
