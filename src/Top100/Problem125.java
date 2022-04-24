package Top100;

import java.util.concurrent.ConcurrentNavigableMap;

public class Problem125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetter(s.charAt(l))&&!Character.isDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetter(s.charAt(r))&&!Character.isDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem125 p = new Problem125();
        System.out.println(p.isPalindrome("0P"));
    }
}
