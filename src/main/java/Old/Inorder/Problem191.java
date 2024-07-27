package Inorder;

public class Problem191 {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') res++;
        }
        return res;
    }

}
