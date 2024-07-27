package algorithmLearn;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem189 {
    public void rotate_(int[] nums, int k) {
        // time is out of limite in this method
        int i = 0;
        while(i<k){
            int temp = nums[nums.length-1];
            for (int j = nums.length-1; j >=1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
            i++;
        }

    }
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            list.addFirst(list.get(list.size()-1));
            list.removeLast();
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Problem189 p = new Problem189();
        p.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
