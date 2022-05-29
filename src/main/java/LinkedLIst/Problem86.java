package LinkedLIst;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode smallPointer = small;
        ListNode bigPointer = big;
        while (head != null) {
            if (head.val < x) {
                small.next = new ListNode(head.val);
                small = small.next;

            } else {
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigPointer.next;
        return smallPointer.next;
    }

    public static void main(String[] args) {
        Problem86 p = new Problem86();
        ListNode res = p.partition(new ListNode(1,new ListNode(2,new ListNode(3))),2);
        res.print();
    }
}
