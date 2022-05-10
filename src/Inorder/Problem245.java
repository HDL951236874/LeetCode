package Inorder;

public class Problem245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int p = 0;
            for (int i = 0; i < wordsDict.length; i++) {
                if(wordsDict[i].equals(word1)){
                    min = Math.min(Math.abs(i-p),min);
                    p = i;
                }
            }
        } else {
            int l = -1;
            int r = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    l = i;
                }
                if (wordsDict[i].equals(word2)) {
                    r = i;
                }
                if (l != -1 && r != -1) {
                    min = Math.min(min, Math.abs(r - l));
                }
            }
        }
        return min;

    }
}
