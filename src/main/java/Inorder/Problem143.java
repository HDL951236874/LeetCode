package Inorder;

import java.util.List;

public class Problem143 {
    public void reorderList(ListNode head) {
        if(head == null||head.next==null||head.next.next == null) return;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode fast = head;
        ListNode slow = head;
        int c = 1;
        while (fast.next != null) {
            fast = fast.next;
            if (c % 2 == 0) {
                slow = slow.next;
            }
            c++;
        }
        ListNode pointer1 = slow;
        ListNode pointer2 = slow.next;
        ListNode pointer3 = slow.next.next;
        while (pointer2 != null) {
            pointer2.next = pointer1;
            pointer1 = pointer2;
            pointer2 = pointer3;
            if (pointer3 != null)
                pointer3 = pointer3.next;
        }
        pointer2 = pointer1.next;
        pointer3 = head;
        ListNode pointer4 = head.next;
        while (pointer1!=slow&&pointer2!=null){
            pointer3.next = pointer1;
            pointer1.next = pointer4;
            pointer3 = pointer4;
            pointer4 = pointer4.next;
            pointer1 = pointer2;
            pointer2 = pointer2.next;
        }
        slow.next = null;
//        System.out.println(1);
    }

    public static void main(String[] args) {
        Problem143 problem143 = new Problem143();
        ListNode listNode =new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        problem143.reorderList(listNode);
    }
}
