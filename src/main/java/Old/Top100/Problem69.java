package Top100;

public class Problem69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int l = 1;
        if(x>=46340*46340) return 46340;
        int r = Math.min(x / 2 + 1,46340);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long small = mid*mid;
            long big = (mid+1)*(mid+1);
            if(small<=x && big>x  ){
                return mid;
            }else if(big == x){
                return mid+1;
            }else if(small>x){
                r = mid-1;
            }else if(big<x){
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem69 p = new Problem69();
        System.out.println(p.mySqrt(2147395599));
    }
}
