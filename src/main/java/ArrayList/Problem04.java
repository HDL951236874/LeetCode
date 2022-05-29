package ArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length ==0){
            return nums2.length%2 == 0? (nums2[nums2.length/2]+nums2[nums2.length/2-1])/2.0: nums2[nums2.length/2];
        }
        if (nums2.length == 0){
            return nums1.length%2 == 0? (nums1[nums1.length/2]+nums1[nums1.length/2-1])/2.0: nums1[nums1.length/2];
        }
        if (nums2.length<nums1.length){
            int[] temp = null;
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int l = 0;
        int r = nums1.length;
        int mark = (nums1.length+nums2.length-1)/2;

        while (l < r) {
            int mid = (l+r)/2;
            if (mid>mark-1||nums1[mid]>=nums2[mark-mid-1]){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        l = Math.min(l,r);

        int c1 = 0;
        int c2 = 0;
        if(nums1[l]<nums2[mark-l]){
            c1 = nums1[l];
            if(l+1<nums1.length){
                c2 = nums2[mark-l]>nums1[l+1]? nums1[l+1] : nums2[mark-l];
            }
            else {
                c2 = nums2[mark-l];
            }
        }
        else {
            c1 = nums2[mark-l];
            if (mark-l+1< nums2.length){
                c2 = nums2[l]>nums2[mark-l+1]? nums2[mark-l+1]: nums1[l];
            }
            else {
                c2 = nums1[l];
            }
        }
        if ((nums1.length+nums2.length)%2==0){
            return (c1+c2)/2.0;
        }else {
            return c1>c2?c2:c1;
        }
    }

    public static void main(String[] args) {
        Problem04 p = new Problem04();
        System.out.println(p.findMedianSortedArrays(new int[]{1},new int[]{2,3}));
    }
}
