package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                temp.add(i);
            }
        }
        int p = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word2)) {
                if (i < temp.get(0)) {
                    min = Math.min(min, Math.abs(i - temp.get(0)));
                    continue;
                }
                if (i > temp.get(temp.size() - 1)) {
                    min = Math.min(min, Math.abs(i - temp.get(temp.size() - 1)));
                    continue;
                }
                while (temp.get(p + 1) < i) {
                    p++;
                }
                min = Math.min(min,Math.min(Math.abs(i-temp.get(p)),Math.abs(i-temp.get(p+1))));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Problem243 problem243 = new Problem243();
        System.out.println(problem243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding",
                "practice"));
    }
}
