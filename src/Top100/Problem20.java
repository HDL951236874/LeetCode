package Top100;

import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        //this question will definitely using stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{')) {
                stack.pop();
            }else {
                return false;
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
}
