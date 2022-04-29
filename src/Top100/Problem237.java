package Top100;

import java.util.List;

public class Problem237 {
    public void deleteNode(ListNode node) {
        while (node!=null){
            node.val = node.next.val;
            if(node.next.next == null){
                node.next = null;
            }
            node = node.next;

        }
    }

    public static void main(String[] args) {
        Problem237 p = new Problem237();
        ListNode l = new ListNode(4);
        l.next = new ListNode(5);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(9);
        p.deleteNode(l.next);
    }
}
