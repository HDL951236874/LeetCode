package Inorder;

public class Problem9 {
    public boolean isPalindrome(int x) {
        String sb = new StringBuffer(String.valueOf(x)).toString();
        String sb_ = new StringBuffer(String.valueOf(x)).reverse().toString();
        return sb.equals(sb_);
    }
}
