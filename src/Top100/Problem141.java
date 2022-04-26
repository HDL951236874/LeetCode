package Top100;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


public class Problem141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)) {
                return true;
            }else {
                set.add(head);
            }
            head.next = head;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem141 p = new Problem141();
    }
}
