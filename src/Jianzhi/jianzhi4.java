package Jianzhi;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    Jianzhi.ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class jianzhi4 {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[]{};
        List<Integer> temp = new ArrayList<>();
        while (head!=null){
            temp.add(head.val);
            head = head.next;
        }
        int[] res = new int[temp.size()];
        for (int i = temp.size()-1; i >=0 ; i--) {
            res[temp.size()-1-i] = temp.get(i);
        }
        return res;
    }
}
