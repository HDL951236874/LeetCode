package Inorder;


import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int p = 0;
        while (p < s.length()) {
            if (s.charAt(p) == ']') {
                StringBuffer temp = new StringBuffer("");
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                temp.reverse();
                stack.pop();
                int sum = 0;
                int num = 1;
                while (!stack.empty()&&Character.isDigit(stack.peek())) {
                    sum += Integer.valueOf(String.valueOf(stack.pop())) * num;
                    num *= 10;
                }
                for (int i = 0; i < sum; i++) {
                    for (int j = 0; j < temp.length(); j++) {
                        stack.push(temp.charAt(j));
                    }
                }
            } else stack.push(s.charAt(p));
            p++;
        }
        StringBuffer res = new StringBuffer("");
        for (int i = 0, stack_size = stack.size(); i < stack_size; i++) {
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        Problem394 problem394 = new Problem394();
        System.out.println(problem394.decodeString("3[a]2[bc]"));
    }
}
