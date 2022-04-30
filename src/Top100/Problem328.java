package Top100;

public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        ListNode temp1_ = new ListNode(0);
        ListNode temp2_ = new ListNode(0);
        ListNode head_ = new ListNode(0);
        temp1_ = temp1;
        temp2_ = temp2;
        head_.next = head;

        while (head != null) {
            temp1.next = new ListNode(head.val);
            if (head.next == null || head.next.next == null) break;
            head = head.next.next;
            temp1 = temp1.next;
        }
        head = head_.next.next;
        while (head != null) {
            temp2.next= new ListNode(head.val);
            if (head.next == null || head.next.next == null) break;
            head = head.next.next;
            temp2 = temp2.next;
        }
        ListNode temp_ = temp1_.next;
        while (temp_.next != null) {
            temp_ = temp_.next;
        }
        temp_.next = temp2_.next;
        return temp1_.next;
    }

    public static void main(String[] args) {
        Problem328 p = new Problem328();

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        System.out.println(p.oddEvenList(head.next));
    }
}
