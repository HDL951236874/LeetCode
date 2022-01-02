package LinkedLIst;

/*
 * This question has not been finished.
 * */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = new ListNode();
        pointer.next = head;
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        if (head == null) {
            return current.next;
        } else {
            while (head.next != null) {
                head = head.next;
                current = current.next;
            }
            current.next = current.next.next;
        }
        return pointer.next;
    }

    public static void main(String[] args) {
        Problem19 p = new Problem19();
        ListNode res = p.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        System.out.println(res.val);
    }
}
