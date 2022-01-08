package LinkedLIst;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode head_ = new ListNode();
        ListNode pointer = head_;
        int temp=0;
        if (head.val!=head.next.val){

            head_.next = new ListNode(head.val);
            head_ = head_.next;
        }
        while (head.next.next != null) {
            temp = head.val;
            head = head.next;
            if (head.val != temp && head.val != head.next.val) {
                head_.next = new ListNode(head.val);
                head_ = head_.next;
            }
        }
        if (head.val!=head.next.val){
            head_.next = new ListNode(head.next.val);
        }
        return pointer.next;
    }

    public static void main(String[] args) {
        Problem82 p = new Problem82();
        ListNode res = p.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2))));
        res.print();
    }
}
