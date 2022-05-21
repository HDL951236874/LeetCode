package Inorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {
            map.put(i, temperatures[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        while (p < temperatures.length) {
            if(!stack.empty()) {
                while (!stack.empty()&&map.get(stack.peek()) < map.get(p)) {
                    res[stack.peek()] = p - stack.peek();
                    stack.pop();
                }
            }
            stack.push(p);
            p++;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem739 problem739 = new Problem739();
        int[] res = problem739.dailyTemperatures(new int[]{4,2,1,3,5});
        System.out.println(1);
    }
}
