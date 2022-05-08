package Inorder;

import java.util.Arrays;
import java.util.List;

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode hocker = new ListNode(0);

        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        hocker.next = head;
        while (head != null) {
            if (head.next == null) {
                if (head.val == val) head = null;
                break;
            }
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return hocker.next;
    }

}
