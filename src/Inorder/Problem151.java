package Inorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem151 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        List<String> container = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > 0) container.add(str);
        }
        Collections.reverse(container);
        return String.join(" ",container);
    }

    public static void main(String[] args) {
        Problem151 problem151 = new Problem151();

    }
}
