package Inorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem345 {
    public String reverseVowels(String s) {

        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (avowl(s.charAt(i))) {
                temp.add(s.charAt(i));
            }
        }
        Collections.reverse(temp);
        StringBuffer stringBuffer = new StringBuffer(s);
        Iterator<Character> iterator = temp.iterator();
        for (int i = 0; i < s.length(); i++) {
            if (avowl(s.charAt(i))) {
                stringBuffer.setCharAt(i,iterator.next());
            }
        }
        return stringBuffer.toString();
    }
    public boolean avowl(char ch){
        return ch == 'a'||ch == 'o'||ch == 'e'||ch == 'i'||ch == 'u'||ch == 'A'||ch == 'O'||ch == 'E'||ch == 'I'||ch == 'U';
    }
}
