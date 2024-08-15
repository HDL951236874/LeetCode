package ukg;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question1 {
    /*
    This is obviously not the best answer.
    Add all the elements of two arrays into one list and using the Api of Collections to sort then put the result back to the num1
    */

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        LinkedList<Integer> l = new LinkedList<>();
        Arrays.stream(nums1).limit(m).forEach(l::add);
        Arrays.stream(nums2).forEach(l::add);
        Collections.sort(l);
        IntStream.range(0,m+n-1).forEach(i->{nums1[i]=l.get(i);});

    }
    /**
    The second way is using the two pointer method
    * */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = 0, p1 = 0, p2 = 0, n1 = 0, n2 = 0;
        int[] num1_copy = nums1.clone();
        while (p<m+n){
            n1 = p1< m? num1_copy[p1]:Integer.MAX_VALUE;
            n2 = p2< n? nums2[p2]:Integer.MAX_VALUE;
            if(n1<n2){
                nums1[p] = n1;
                p1++;
            }else {
                nums1[p] = n2;
                p2++;
            }
            p++;
        }
    }
    /**
     * we can also you the linkedlist insert method to solve this problem
     * **/
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        question1.merge1(new int[]{1,2,3,0,0,0},3, new int[]{4,5,6}, 3);
    }
}
