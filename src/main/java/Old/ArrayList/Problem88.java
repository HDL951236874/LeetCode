package Old.ArrayList;

public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //three pointer is also a way to solve this problem
        if(nums2.length == 0) return;
        int i = 0;
        int j = 0;
        while (i<nums1.length&&j<nums2.length) {
            if(nums2[j]<nums1[i]){
                for (int k = m+j; k >i ; k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j ++;
            }
            i++;
        }
        for (int k = j; k < nums2.length; k++) {
            nums1[nums1.length-(nums2.length-k)] = nums2[k];
        }
    }

    public static void main(String[] args) {
        Problem88 p = new Problem88();
        p.merge(new int[]{0,0,3,0,0,0,0,0,0}, 3, new int[]{-1,1,1,1,2,3}, 6);
    }
}
