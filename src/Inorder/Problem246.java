package Inorder;

import java.util.Stack;

public class Problem246 {
    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            char a = num.charAt(l);
            char b = num.charAt(r);
            if (a == '2' || b == '2' || a == '3' || b == '3' || a == '4' || b == '4' || a == '5' || b == '5' || a == '7' || b == '7') {
                return false;
            }
            if (a == '9' && b != '6') return false;
            if (a == '6' && b != '9') return false;
            if (a == '8' && b != '8') return false;
            if (a == '1' && b != '1') return false;
            if (b == '9' && a != '6') return false;
            if (b == '6' && a != '9') return false;
            if (b == '8' && a != '8') return false;
            if (b == '1' && a != '1') return false;
            l++;
            r--;
        }
        return true;
    }
}