package Old.Inorder;

public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        return helper(n);
    }
    public boolean helper(int n){
        if(n == 1) return true;
        return helper(n/2)&&n%2 == 0;
    }
}
