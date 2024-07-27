package Inorder;

import java.util.HashSet;
import java.util.Set;

public class Problem142 {
    public LinkedLIst.ListNode detectCycle(LinkedLIst.ListNode head) {
        Set<LinkedLIst.ListNode> set = new HashSet<>();
        while (head!=null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
