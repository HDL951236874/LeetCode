package Top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        List<Integer> container = new ArrayList<>();
        while (head!=null){
            container.add(head.val);
            head = head.next;
        }
        Collections.reverse(container);
        ListNode res = temp.next;
        for (int i = 0; i < container.size(); i++) {
            res.val = container.get(i);
            res = res.next;
        }
        return temp.next;
    }
}
