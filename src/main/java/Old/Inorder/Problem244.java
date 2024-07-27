package Inorder;

public class Problem244 {
    String[] wordsDict;

    public Problem244(String[] wordsDict) {
        this.wordsDict = wordsDict;
    }

    public int shortest(String word1, String word2) {
        int l = -1;
        int r = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.wordsDict.length; i++) {
            if (this.wordsDict[i].equals(word1)) {
                l = i;
            }
            if (this.wordsDict[i].equals(word2)) {
                r = i;
            }
            if (l != -1 && r != -1) {
                min = Math.min(min, Math.abs(r - l));
            }
        }
        return min;
    }
}


