package Old.Contest;

import java.awt.event.WindowFocusListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem6065 {
    int res = 0;

    public int largestCombination(int[] candidates) {
        int max = Arrays.stream(candidates).max().getAsInt();

        for (int i = 1; i <= 32; i++) {
            int num = 0;
            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] % 2 == 1) num++;
                candidates[j] = candidates[j] >> 1;
            }
            res = Math.max(res, num);
        }
        return res;
    }


    public static void main(String[] args) {
        Problem6065 problem6065 = new Problem6065();
        problem6065.largestCombination(new int[]{8,8});
    }
}
