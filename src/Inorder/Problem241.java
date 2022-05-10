package Inorder;

import javax.swing.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Character> operation_list = new ArrayList<>();
        List<Integer> int_list = new ArrayList<>();
        int p = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (i == expression.length() - 1) {
                int_list.add(Integer.valueOf(expression.substring(p, expression.length())));
            }
            if (!Character.isDigit(expression.charAt(i))) {
                int_list.add(Integer.valueOf(expression.substring(p, i)));
                operation_list.add(expression.charAt(i));
                p = i + 1;
            }
        }
        List<Integer> res = backtrack(operation_list, int_list);
        return res;
    }

    public List<Integer> backtrack(List<Character> opteration, List<Integer> integerList) {
        List<Integer> res = new ArrayList<>();
        if (integerList.size() == 1) {
            res.add(integerList.get(0));
            return res;
        }
        for (int i = 0; i < opteration.size(); i++) {
            List<Character> l_op = opteration.subList(0, i);
            List<Character> r_op = opteration.subList(i + 1, opteration.size());
            List<Integer> l_int = integerList.subList(0, i + 1);
            List<Integer> r_int = integerList.subList(i + 1, integerList.size());
            List<Integer> l_list = backtrack(l_op, l_int);
            List<Integer> r_list = backtrack(r_op, r_int);
            for (int j = 0; j < l_list.size(); j++) {
                for (int k = 0; k < r_list.size(); k++) {
                    if (opteration.get(i) == '+') res.add(l_list.get(j) + r_list.get(k));
                    if (opteration.get(i) == '-') res.add(l_list.get(j) - r_list.get(k));
                    if (opteration.get(i) == '*') res.add(l_list.get(j) * r_list.get(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem241 problem241 = new Problem241();
        problem241.diffWaysToCompute("2*3-4*5");
    }

}
