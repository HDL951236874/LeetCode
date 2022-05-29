package LinkedLIst;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode head_ = new ListNode();
        head_.next = head;
        ListNode leftPointer = head_;

        for (int i = 0; i < left - 1; i++) {
            head_ = head;
            head = head.next;
        }
        ListNode middle = new ListNode(head.val);
        ListNode middleEndPointer = middle;
        //this head is the start of the inverse
        for (int i = 0; i < right - left; i++) {
            head = head.next;
            ListNode temp = new ListNode(head.val);
            temp.next = middle;
            middle = temp;
        }
        head_.next = middle;
        middleEndPointer.next = head.next;
        return leftPointer.next;
    }

    public static void main(String[] args) {
        Problem92 p = new Problem92();
        ListNode res = p.reverseBetween(new ListNode(1, new ListNode(2)), 1, 2);
        res.print();
    }
}
