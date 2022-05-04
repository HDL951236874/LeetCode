package Inorder;

public class Problem58 {
    public int lengthOfLastWord(String s) {
        int c = 0;
        boolean trigger = false;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(trigger && s.charAt(i) == ' '){
                return c;
            }
            if(s.charAt(i)!=' '){
                c++;
                trigger = true;
            }
        }
        return trigger?c:0;
    }
}
