package Rework.Contest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Contest2934 {
    public int minOperations(int[] nums1, int[] nums2) {
        int last1 = nums1[nums1.length-1];
        int last2 = nums2[nums2.length-1];
        int bigger = Math.max(last1,last2);
        int smaller = Math.min(last1,last2);
        int side1 = 0;
        int side2 = 0;
        for(int i =0;i< nums1.length-1;i++){
            int n1 = nums1[i];
            int n2 = nums2[i];
            if(n1>bigger || n2>bigger) return -1;
            if(n1<=smaller && n2<=smaller) continue;
            if(n1<=bigger&&n1>smaller&&n2<=bigger&&n2>smaller) return -1;
            if(n1>n2){
                side1 ++;
            }else {
                side2 ++;
            }
        }
        if(side1 == side2) return side1;
        if(side1< side2){
            if(last1<last2)return side1;
            else return side1+1;
        }else {
            if(last2<last1) return side2;
            else return side2+1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,12,2,4,13,1,8,17,14,11,15,14,8,18,1,20,20,6,14,10,1,10,9,3,20,19,18};
        int[] b = new int[]{12,16,3,8,4,19,18,11,13,12,9,9,3,2,2,12,17,7,14,18,2,8,19,6,8,16,20};
        Contest2934 c = new Contest2934();
        c.minOperations(a,b);
    }
}
