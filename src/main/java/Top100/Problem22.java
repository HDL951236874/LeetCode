package Top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrakc(res, "", n, stack);
        return res;
    }

    public void backtrakc(List<String> res, String now, int n, Stack<Character> stack) {
        if (now.length() == 2*n) {
            if (stack.isEmpty()) {
                res.add(now);
                return;
            }else return;

        }
        if (stack.isEmpty()) {
            stack.push('(');
            backtrakc(res, now + "(", n, stack);
        } else {

            Stack<Character> stack1 = (Stack<Character>) stack.clone();
            stack1.push('(');
            backtrakc(res, now + '(', n, stack1);

            Stack<Character> stack2 = (Stack<Character>) stack.clone();
            if (stack2.peek() == '(') {
                stack2.pop();
            } else {
                stack2.push(')');
            }
            backtrakc(res, now + ')', n, stack2);
        }
    }

    public static void main(String[] args) {
        Problem22 p = new Problem22();
        p.generateParenthesis(1);
    }
}
