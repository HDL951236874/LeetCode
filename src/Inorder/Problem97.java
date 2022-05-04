package Inorder;

public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        return backtrack(0, 0, 0, s1, s2, s3);
    }

    public boolean backtrack(int index1, int index2, int index3, String s1, String s2, String s3) {
        if (s3.length() == index3) {
            return true;
        }
        boolean b1 = false;
        boolean b2 = false;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            b1 = backtrack(index1 + 1, index2, index3 + 1, s1, s2, s3);
        }
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            b2 = backtrack(index1, index2 + 1, index3 + 1, s1, s2, s3);
        }
        return b1 || b2;
    }

    public static void main(String[] args) {
        Problem97 p = new Problem97();
        System.out.println(p.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
