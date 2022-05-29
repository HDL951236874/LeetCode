package Inorder;

import java.util.List;

public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode hocker = new ListNode(0);
        ListNode tmp = new ListNode(Integer.MIN_VALUE);
        hocker.next = tmp;
        while (head != null) {
            int aim = head.val;
            while (tmp != null) {
                if (tmp.next == null) {
                    if (aim > tmp.val) {
                        tmp.next = new ListNode(aim);
                    }
                    continue;
                }
                if (tmp.val < aim && tmp.next.val >= aim) {
                    ListNode temp = tmp.next;
                    tmp.next = new ListNode(aim);
                    tmp.next.next = temp;
                    tmp = tmp.next;

                    break;
                }
                tmp = tmp.next;
            }
            head = head.next;
        }
        return hocker.next.next;
    }
}
