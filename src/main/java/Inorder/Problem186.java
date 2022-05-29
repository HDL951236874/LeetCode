package Inorder;

import java.net.BindException;
import java.util.Arrays;
import java.util.Collections;

public class Problem186 {
    public void reverseWords(char[] s) {
        String str = "";
        for (int i = 0; i < s.length; i++) {
            str += s[i];
        }
        String[] str_l = str.split(" ");
        String[] str_ll = new String[str_l.length];
        for (int i = str_l.length - 1; i >= 0; i--) {
            str_ll[str_l.length - 1 - i] = str_l[i];
        }
        int index = 0;
        for (int i = 0; i < str_ll.length; i++) {
            for (int j = 0; j < str_ll[i].length(); j++) {
                s[index] = str_ll[i].charAt(j);
                index++;
            }
            if (i != str_ll.length - 1) {
                s[index] = ' ';
                index++;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a',' ','c'};
        String s = chars.toString();
        System.out.println(s);
    }
}
