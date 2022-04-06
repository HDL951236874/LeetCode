package algorithmLearn;

public class Problem278 {
    public int firstBadVersion(int n) {
        if(n == 1 || isBadVersion(1) == true) return 1;

        int l = 1;
        int r = n;
        while (l<=r){
            int mid = (l+r)/2;
            if(isBadVersion(mid) == false && isBadVersion(mid+1) == true){
                return mid;
            }else if(isBadVersion(mid) == true && isBadVersion(mid+1) == true){
                r = mid-1;
            }else if(isBadVersion(mid) == false && isBadVersion(mid+1) == false){
                l = mid +1;
            }
        }
        return -1;
    }
}
