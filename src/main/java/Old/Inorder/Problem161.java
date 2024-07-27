package Inorder;

public class Problem161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.min(s.length(), t.length()) == 0) {
            if (Math.max(s.length(), t.length()) == 1) {
                return true;
            } else return false;
        }
        int a = 0;
        int b = 0;
        while (a < s.length() && b < t.length()) {
            if (s.charAt(a) != t.charAt(b)) {
                if (s.length() == t.length()) {
                    if (s.substring(a + 1, s.length()).equals(t.substring(b + 1, t.length()))) return true;
                    else return false;

                }
                if (s.length() > t.length()) {
                    if (s.substring(a + 1, s.length()).equals(t.substring(b, t.length()))) return true;
                    else return false;
                }
                if (s.length() < t.length()) {
                    if (s.substring(a, s.length()).equals(t.substring(b + 1, t.length()))) return true;
                    else return false;
                }

            }
            a++;
            b++;
        }
        if (Math.max(s.length(), t.length()) - Math.min(s.length(), t.length()) == 1) {
            return true;
        } else
            return false;
    }
}
