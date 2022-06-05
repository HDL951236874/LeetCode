package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        //ax^2 + bx +c
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        list.forEach((x) -> {
            res.add((int) (a * Math.pow(x, 2) + b * x + c));
        });
        Collections.sort(res);
        int[] final_res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            final_res[i] = res.get(i);
        }
        return final_res;
    }
}
